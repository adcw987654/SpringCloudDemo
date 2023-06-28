package com.ray.springcloud.service.impl;

import com.ray.springcloud.enums.ResponseCode;
import com.ray.springcloud.dao.UserDao;
import com.ray.springcloud.dto.LoginUserReqDto;
import com.ray.springcloud.dto.LoginUserResDto;
import com.ray.springcloud.dto.RegisterUserReqDto;
import com.ray.springcloud.entities.ResponseEntity;
import com.ray.springcloud.entities.UserEntity;
import com.ray.springcloud.service.UserService;
import com.ray.springcloud.utils.JwtTokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Value("${jwt.key}")
    private String jwtKey;

    @Override
    public void registerUser(RegisterUserReqDto reqDto) {
        userDao.create(reqDto.toEntity());
    }

    @Override
    public ResponseEntity<LoginUserResDto> login(LoginUserReqDto reqDto) {
        LoginUserResDto resDto = new LoginUserResDto();
        String username = reqDto.getUsername();
        UserEntity userEntity = userDao.getUserByUserName(username);
        String token = null;
        if (userEntity == null) {
            //找不到該使用者
            return null;
        } else if (new BCryptPasswordEncoder().matches(reqDto.getPassword(), userEntity.getPassword())) {
            token = getJwtToken(username);
            resDto.setAccessToken(token);
        }
        return new ResponseEntity(ResponseCode.OK, resDto);
    }

    private String getJwtToken(String username) {
        String token = null;
        try {
            token = JwtTokenUtils.generateToken(username, jwtKey);
        } catch (Exception e) {
            log.error("產token時 發生錯誤!", e);
        }
        return token;
    }


}
