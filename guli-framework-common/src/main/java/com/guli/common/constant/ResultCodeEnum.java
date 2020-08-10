package com.guli.common.constant;

import lombok.Getter;

@Getter
public enum ResultCodeEnum {
    SUCCESS("成功",true,20000),
    UNKNOW_ERROR("失败",false,20001)
    ;


    private String message;
    private Boolean success;
    private Integer code;

    ResultCodeEnum(String message, Boolean success, Integer code) {
        this.message = message;
        this.success = success;
        this.code = code;
    }
}
