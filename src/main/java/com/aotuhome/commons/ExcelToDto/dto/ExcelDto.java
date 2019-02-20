package com.aotuhome.commons.ExcelToDto.dto;


import com.aotuhome.commons.ExcelToDto.ExcelInterface.ExcelColunm;

import java.lang.annotation.Annotation;

public class ExcelDto implements Annotation {

    @ExcelColunm(colName="id")
    private String id;

    @ExcelColunm(colName="casename")
    private String casename;

    @ExcelColunm(colName="requestUrl")
    private String requestUrl;

    @ExcelColunm(colName="is_timestamp")
    private String is_timestamp;

    @ExcelColunm(colName="isSign")
    private String isSign;

    @ExcelColunm(colName="_appid")
    private String _appid;

    @ExcelColunm(colName="sign_method")
    private String sign_method;

    @ExcelColunm(colName="format")
    private String format;

    @ExcelColunm(colName="requestType")
    private String requestType;

    @ExcelColunm(colName="requestHeader")
    private String requestHeader;

    @ExcelColunm(colName="parameters")
    private String parameters;

    @ExcelColunm(colName="check")
    private String check;

    @ExcelColunm(colName="expect")
    private String expect;

    @Override
    public boolean equals(Object obj) {
        return false;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCasename() {
        return casename;
    }

    public void setCasename(String casename) {
        this.casename = casename;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public String getIs_timestamp() {
        return is_timestamp;
    }

    public void setIs_timestamp(String is_timestamp) {
        this.is_timestamp = is_timestamp;
    }

    public String getIsSign() {
        return isSign;
    }

    public void setIsSign(String isSign) {
        this.isSign = isSign;
    }

    public String get_appid() {
        return _appid;
    }

    public void set_appid(String _appid) {
        this._appid = _appid;
    }

    public String getSign_method() {
        return sign_method;
    }

    public void setSign_method(String sign_method) {
        this.sign_method = sign_method;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getRequestHeader() {
        return requestHeader;
    }

    public void setRequestHeader(String requestHeader) {
        this.requestHeader = requestHeader;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public String getCheck() {
        return check;
    }

    public void setCheck(String check) {
        this.check = check;
    }

    public String getExpect() {
        return expect;
    }

    public void setExpect(String expect) {
        this.expect = expect;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", casename='" + casename + '\'' +
                ", requestUrl='" + requestUrl + '\'' +
                ", is_timestamp='" + is_timestamp + '\'' +
                ", isSign='" + isSign + '\'' +
                ", _appid='" + _appid + '\'' +
                ", sign_method='" + sign_method + '\'' +
                ", format='" + format + '\'' +
                ", requestType='" + requestType + '\'' +
                ", requestHeader='" + requestHeader + '\'' +
                ", parameters='" + parameters + '\'' +
                ", check='" + check + '\'' +
                ", expect='" + expect + '\'' +
                '}';
    }
}
