package com.ray.springcloud.dto;

import lombok.Data;

@Data
public class LoginUserReqDto {
    private String username;
    private String password;
}
