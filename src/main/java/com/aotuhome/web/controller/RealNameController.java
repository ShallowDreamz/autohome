package com.aotuhome.web.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aotuhome.dto.RequestBean;
import com.aotuhome.dto.RequestParams;
import com.aotuhome.dto.ResponseParam;
import com.aotuhome.service.RealNameService;
import com.aotuhome.service.serviceImpl.RealNameServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RealNameController {
    public static final Logger logger = LoggerFactory.getLogger(RealNameController.class);
    @Autowired
    private RealNameService realNameService;
    @RequestMapping(method= RequestMethod.POST,value = "/returnRealNameData",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ResponseParam returnRealNameData(@RequestBody RequestBean requestBean){
        logger.info(requestBean.toString());
        ResponseParam responseParam = realNameService.getResponse(requestBean);
        return responseParam;
    }
    @RequestMapping(method= RequestMethod.POST,value = "/returnResponseData",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ResponseParam returnResponseData(@RequestBody RequestParams requestParams , HttpServletRequest request){
        logger.info(requestParams.toString());
        try {
            System.out.println(JSON.toJSONString(request.getHeader("Content-Type")));
            ResponseParam responseParam = realNameService.getResponse(requestParams);
            return responseParam;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
