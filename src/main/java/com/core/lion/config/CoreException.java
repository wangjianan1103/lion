package com.core.lion.config;

import com.core.lion.enums.ErrorCodeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 自定义异常
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CoreException extends RuntimeException {
    private int status;
    private String message;

    public CoreException(int status) {
        this.status = status;
    }

    public CoreException(ErrorCodeEnum errorCodeEnum) {
        this.status = errorCodeEnum.errorCode;
    }

    public CoreException(int status, String message) {
        this.status = status;
        this.message = message;
    }
}



