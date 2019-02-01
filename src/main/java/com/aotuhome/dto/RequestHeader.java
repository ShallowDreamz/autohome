package com.aotuhome.dto;

public class RequestHeader {
    private String requestHeaderData;

    public String getRequestHeaderData() {
        return requestHeaderData;
    }

    public void setRequestHeaderData(String requestHeaderData) {
        this.requestHeaderData = requestHeaderData;
    }

    @Override
    public String toString() {
        return "RequestHeader{" +
                "requestHeaderData='" + requestHeaderData + '\'' +
                '}';
    }
}
