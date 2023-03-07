package com.example.scmap.Common;

import lombok.Getter;

@Getter
public class CommonException extends RuntimeException {

    private CommonErrorCode commonErrorCode;

    private Object errorMsg;

    public CommonException() {
    }

    public CommonException(CommonErrorCode commonErrorCode) {
        this.commonErrorCode = commonErrorCode;
    }

    public CommonException(CommonErrorCode commonErrorCode, Object errorMsg) {
        this.commonErrorCode = commonErrorCode;
        this.errorMsg = errorMsg;
    }
}
