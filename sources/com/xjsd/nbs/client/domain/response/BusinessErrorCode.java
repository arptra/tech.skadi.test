package com.xjsd.nbs.client.domain.response;

import com.xjsd.nbs.common.domain.response.CommonErrorCode;
import com.xjsd.nbs.common.domain.response.ErrorCode;

public enum BusinessErrorCode implements ErrorCode {
    PARAM_TOKEN_ERROR(CommonErrorCode.PARAM_ERROR.getErrorCode(), "设置的token 为空");
    
    private final int errorCode;
    private final String errorMessage;

    private BusinessErrorCode(int i, String str) {
        this.errorCode = i;
        this.errorMessage = str;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }
}
