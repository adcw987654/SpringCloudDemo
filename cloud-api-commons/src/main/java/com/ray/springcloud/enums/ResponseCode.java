package com.ray.springcloud.enums;

import lombok.Getter;

@Getter
public enum ResponseCode {
    OK(200, "處理完成!");

    ResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private int code;
    private String msg;
}
