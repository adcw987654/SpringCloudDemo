package com.ray.springcloud.aop;

import com.ray.springcloud.entities.ResponseEntity;
import com.ray.springcloud.enums.ResponseCode;
import feign.Response;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class JwtAuthAspect {

    @Pointcut("@annotation(com.ray.springcloud.annotation.JwtAuth)")
    public void aopPointCut() {
    }

    @Around(value = "aopPointCut()")
    public ResponseEntity jwtAuthAop(ProceedingJoinPoint proceedingJoinPoint) {
        //TODO
        return new ResponseEntity<>(ResponseCode.OK);
    }

}
