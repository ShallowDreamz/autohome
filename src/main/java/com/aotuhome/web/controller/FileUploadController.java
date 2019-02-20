package com.aotuhome.web.controller;

import com.aotuhome.commons.BatchParameterNormalization;
import com.aotuhome.commons.ExcelToDto.Utils.ExcelToDto;
import com.aotuhome.commons.ExcelToDto.dto.ExcelDto;
import com.aotuhome.commons.ExcelUtil;
import com.aotuhome.commons.Path;
import com.aotuhome.dto.ResponseParam;
import com.aotuhome.service.BatchProcessingService;
import com.aotuhome.service.serviceImpl.RealNameServiceImpl;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
public class FileUploadController {
    public static final Logger logger = LoggerFactory.getLogger(RealNameServiceImpl.class);
    @Autowired
    private Path path;
    @Autowired
    private ExcelUtil excelUtil;
    @Autowired
    private BatchProcessingService batchProcessingService;
    @Autowired
    private ExcelToDto excelToDto;
    @Autowired
    private BatchParameterNormalization batchParameterNormalization;
    @RequestMapping(method= RequestMethod.POST,value = "/upload")
    @ResponseBody
    public String springUpload(HttpServletRequest request) throws IllegalStateException{
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        if (multipartResolver.isMultipart(request)) {
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            Iterator iter = multiRequest.getFileNames();
            while (iter.hasNext()) {
                //一次遍历所有文件
                MultipartFile file = multiRequest.getFile(iter.next().toString());
                if (file != null) {
                    String lastPath = path.getPath(file);
                    //上传
                    try {
                        file.transferTo(new File(lastPath));
                        excelUtil.setExcelPath(lastPath);
                        System.out.println("=======测试Excel 默认 读取========");
                        List<Row> list = excelUtil.readExcel();
                        System.out.println(list.size());
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }
        }
        return "success";
    }
    @RequestMapping(method= RequestMethod.GET,value = "/read",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List springUpload(@RequestParam(value="path", required=false) String path){
        File f = new File(path);
        List<ExcelDto> list;
        List<ResponseParam> responseParamList = new ArrayList<>();
        try {
            list = excelToDto.readExcel(f, ExcelDto.class);
            for (int ExcelDtoIndex = 0; ExcelDtoIndex < list.size(); ExcelDtoIndex++) {
                ResponseParam responseParam = batchProcessingService.excelBatchService(list.get(ExcelDtoIndex));
                responseParamList.add(responseParam);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
        return responseParamList;
    }
}
