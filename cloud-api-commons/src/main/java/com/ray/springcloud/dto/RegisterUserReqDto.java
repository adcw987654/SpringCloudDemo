package com.ray.springcloud.dto;

import com.ray.springcloud.entities.UserEntity;
import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Data
public class RegisterUserReqDto {
    private String username;
    private String password;

    public UserEntity toEntity() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(username);
        userEntity.setPassword(new BCryptPasswordEncoder().encode(password));
        return userEntity;
    }
}
