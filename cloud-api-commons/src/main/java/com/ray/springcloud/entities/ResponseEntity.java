package com.ray.springcloud.entities;

import com.ray.springcloud.enums.ResponseCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseEntity<T> {

    private Integer code;

    private String message;

    private T data;

    public ResponseEntity(ResponseCode code) {
        this(code.getCode(), code.getMsg(), null);
    }

    public ResponseEntity(ResponseCode code, T data) {
        this(code.getCode(), code.getMsg(), data);
    }

}
