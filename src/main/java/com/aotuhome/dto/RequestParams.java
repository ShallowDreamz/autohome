package com.aotuhome.dto;

import java.util.List;

public class RequestParams {
    private String requestUrl;
    private String _appid;
    private String is_timestamp;
    private String isSign;
    private String sign_method;
    private String format;
    private String requestType;
    private List<ParamList> requestHeader;
    private List<ParamList> requestBody;
    private String codeName;
    private String check;
    private String except;

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getCheck() {
        return check;
    }

    public void setCheck(String check) {
        this.check = check;
    }

    public String getExcept() {
        return except;
    }

    public void setExcept(String except) {
        this.except = except;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public String get_appid() {
        return _appid;
    }

    public void set_appid(String _appid) {
        this._appid = _appid;
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

    public List<ParamList> getRequestHeader() {
        return requestHeader;
    }

    public void setRequestHeader(List<ParamList> requestHeader) {
        this.requestHeader = requestHeader;
    }

    public List<ParamList> getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(List<ParamList> requestBody) {
        this.requestBody = requestBody;
    }

    @Override
    public String toString() {
        return "RequestParams{" +
                "requestUrl='" + requestUrl + '\'' +
                ", _appid='" + _appid + '\'' +
                ", is_timestamp='" + is_timestamp + '\'' +
                ", isSign='" + isSign + '\'' +
                ", sign_method='" + sign_method + '\'' +
                ", format='" + format + '\'' +
                ", requestType='" + requestType + '\'' +
                ", requestHeader=" + requestHeader +
                ", requestBody=" + requestBody +
                ", codeName='" + codeName + '\'' +
                ", check='" + check + '\'' +
                ", except='" + except + '\'' +
                '}';
    }
}
