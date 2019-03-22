package com.aotuhome.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Data
public class BatchResponseBody extends ResponseParam {
    private String caseId;
    private String caseName;
    private String requestParam;
    private String isPass;
    private String expected;
    private String code;
    private long responseTime;
}
