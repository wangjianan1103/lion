package com.core.lion.config;

import com.core.lion.enums.ErrorCodeEnum;
import lombok.Data;

/**
 * 接口统一返回对象
 */
@Data
public class ResponseInfo {

    private int status;
    private String message;
    private Object content;

    public ResponseInfo() {
    }

    public ResponseInfo(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public ResponseInfo(int status, String message, Object content) {
        this.status = status;
        this.message = message;
        this.content = content;
    }

    public ResponseInfo(ErrorCodeEnum errorCodeEnum, Object content) {
        this.status = errorCodeEnum.errorCode;
        this.message = errorCodeEnum.message;
        this.content = content;
    }

    public ResponseInfo(ErrorCodeEnum errorCodeEnum) {
        this.status = errorCodeEnum.errorCode;
        this.message = errorCodeEnum.message;
    }
}

