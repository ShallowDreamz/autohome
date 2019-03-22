package com.aotuhome.service;

import com.aotuhome.commons.ExcelToDto.dto.ExcelDto;
import com.aotuhome.dto.BatchResponseBody;

public interface BatchProcessingService {
    BatchResponseBody excelBatchService(ExcelDto excelDto);
}
