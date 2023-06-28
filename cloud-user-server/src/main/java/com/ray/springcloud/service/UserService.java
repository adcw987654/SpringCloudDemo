package com.ray.springcloud.service;

import com.ray.springcloud.dto.LoginUserReqDto;
import com.ray.springcloud.dto.RegisterUserReqDto;
import com.ray.springcloud.entities.ResponseEntity;

public interface UserService {

    void registerUser(RegisterUserReqDto reqDto);

    ResponseEntity login(LoginUserReqDto reqDto);
}
