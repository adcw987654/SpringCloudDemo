package com.ray.springcloud.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ray.springcloud.entities.CommonResult;
import com.ray.springcloud.entities.Payment;

public interface OrderFeignClient {

	@GetMapping("/consumer/payment/create")
	public CommonResult<Payment> create(Payment payment);

	@GetMapping("/consumer/payment/get/{id}")
	public CommonResult<Payment> getPayment(@PathVariable("id") Long id);

}
