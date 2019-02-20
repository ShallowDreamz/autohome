package com.aotuhome.service;

import com.aotuhome.commons.ExcelToDto.dto.ExcelDto;
import com.aotuhome.dto.ResponseParam;

public interface BatchProcessingService {
    public ResponseParam excelBatchService(ExcelDto excelDto);
}
