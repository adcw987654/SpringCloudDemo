package com.ray.springcloud.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ray.springcloud.entities.ResponseEntity;
import com.ray.springcloud.entities.Payment;

@Component
@FeignClient(value = "CLOUD-ORDER-SERVICE")
public interface OrderFeignClient {

	@GetMapping("/consumer/payment/create")
	public ResponseEntity<Integer> create(Payment payment);

	@GetMapping("/consumer/payment/get/{id}")
	public ResponseEntity<Payment> getPayment(@PathVariable("id") Long id);

}
