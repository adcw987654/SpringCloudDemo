package com.ray.springcloud.dao;

import com.ray.springcloud.entities.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDao {
    public int create(UserEntity user);

    public UserEntity getUserByUserName(@Param("username") String username);
}
