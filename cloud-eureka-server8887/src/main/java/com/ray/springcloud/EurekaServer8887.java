package com.ray.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServer8887 {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServer8887.class, args);
	}

}
