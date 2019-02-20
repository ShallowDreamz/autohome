package com.aotuhome.service.serviceImpl;

import com.aotuhome.commons.BatchParameterNormalization;
import com.aotuhome.commons.ExcelToDto.dto.ExcelDto;
import com.aotuhome.commons.HttpClientDriver;
import com.aotuhome.dto.ResponseParam;
import com.aotuhome.service.BatchProcessingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.*;

@Service
public class BatchProcessingServiceImpl implements BatchProcessingService {
    public static final Logger logger = LoggerFactory.getLogger(BatchProcessingServiceImpl.class);
    @Autowired
    private BatchParameterNormalization batchParameterNormalization;
    @Override
    public ResponseParam excelBatchService(ExcelDto excelDto) {
        String url = excelDto.getRequestUrl();
        String headers = excelDto.getRequestHeader();
        String isSing = excelDto.getIsSign();
        String isTimetamp = excelDto.getIs_timestamp();
        String requestBody = excelDto.getParameters();
        HashMap<String,String> headerMap = batchParameterNormalization.paramOverWrite(headers);
        HashMap <String,String>BodyMap = batchParameterNormalization.paramOverWrite(requestBody);
        BodyMap.put("_appid", excelDto.get_appid());
        BodyMap.put("sign_method", excelDto.getSign_method());
        BodyMap.put("format", excelDto.getFormat());
        if ("get".equalsIgnoreCase(excelDto.getRequestType().trim())) {
            ResponseParam responseParam = new ResponseParam();
            String host = batchParameterNormalization.getExcelURL(BodyMap, url, isSing, isTimetamp, headerMap);
            List list = HttpClientDriver.httpGet(host, headerMap);
            responseParam.setCode(list.get(0).toString());
            responseParam.setMessage(list.get(1).toString());
            return responseParam;
        }else if("post".equalsIgnoreCase(excelDto.getRequestType().trim())){
            ResponseParam responseParam = new ResponseParam();
            SortedMap sortedMap = batchParameterNormalization.getExcelBody(BodyMap, isSing, isTimetamp, headerMap);
            if ("application/x-www-form-urlencoded".equalsIgnoreCase(headerMap.get("Content-Type").trim()) || headerMap.get("Content-Type").isEmpty() || headerMap.get("Content-Type").length() == 0) {
                List list = HttpClientDriver.formPost(url, sortedMap, headerMap);
                responseParam.setCode(list.get(0).toString());
                responseParam.setMessage(list.get(1).toString());
                return responseParam;
            }else if("application/json".equalsIgnoreCase(headerMap.get("Content-Type").trim())){
                List list = null;
                try {
                    list = HttpClientDriver.httpPost(url, sortedMap, headerMap);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                responseParam.setCode(list.get(0).toString());
                responseParam.setMessage(list.get(1).toString());
                return responseParam;
            }else {
                responseParam.setCode("250");
                responseParam.setMessage("还TM没实现");
                return responseParam;
            }
        }
        return null;
    }
}
