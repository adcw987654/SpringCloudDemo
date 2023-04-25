package com.ray.springcloud.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ray.springcloud.entities.CommonResult;
import com.ray.springcloud.entities.Payment;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class OrderControllerRest {

	/**
	 * 從eureka server 取得資訊
	 */
	public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

	@Autowired
	@Qualifier("RibbonRestTemplate")
	private RestTemplate ribbonRestTemplate; // 透過ribbonRestTemplate調用payment
	
	

	@GetMapping("/ribbon/consumer/payment/create")
	public CommonResult<Payment> create(Payment payment) {
		log.info("call order payment create");
		return ribbonRestTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
	}

	@GetMapping("/ribbon/consumer/payment/get/{id}")
	public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
		log.info("call order payment get");
		return ribbonRestTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
	}

}
