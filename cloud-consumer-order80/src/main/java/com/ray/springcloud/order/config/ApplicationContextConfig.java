package com.ray.springcloud.order.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {

	@Bean("RibbonRestTemplate")
	@LoadBalanced // 告訴Spring創建一个支持Ribbon loadBalance的restTemplate
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
