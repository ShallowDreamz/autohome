package com.aotuhome.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Data
public class BatchRequestBody extends ResponseParam {
    private String caseId;
    private String caseName;
    private String reuqestParam;
    private String responseBody;
    private boolean isPass;
    private String expected;
}
