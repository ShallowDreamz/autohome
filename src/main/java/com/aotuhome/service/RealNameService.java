package com.aotuhome.service;

import com.aotuhome.dto.RequestBean;
import com.aotuhome.dto.RequestParams;
import com.aotuhome.dto.ResponseParam;

public interface RealNameService {
    ResponseParam getResponse(RequestBean requestBean);

    ResponseParam getResponse(RequestParams requestParams);
}
