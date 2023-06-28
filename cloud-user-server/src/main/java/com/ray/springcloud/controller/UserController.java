package com.ray.springcloud.controller;


import com.ray.springcloud.enums.ResponseCode;
import com.ray.springcloud.dto.LoginUserReqDto;
import com.ray.springcloud.entities.ResponseEntity;
import com.ray.springcloud.dto.RegisterUserReqDto;
import com.ray.springcloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody RegisterUserReqDto reqDto) {
        service.registerUser(reqDto);
        return new ResponseEntity(ResponseCode.OK);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginUserReqDto reqDto) {
        return service.login(reqDto);
    }
}
