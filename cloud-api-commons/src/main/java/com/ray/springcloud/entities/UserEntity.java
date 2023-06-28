package com.ray.springcloud.entities;

import lombok.Data;

@Data
public class UserEntity {
    private long id;

    private String username;

    private String password;

    private String email;

    private String oauth2;

    private String nickName;
}
