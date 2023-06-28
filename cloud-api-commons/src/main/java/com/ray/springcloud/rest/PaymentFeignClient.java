package com.ray.springcloud.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ray.springcloud.entities.ResponseEntity;
import com.ray.springcloud.entities.Payment;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignClient {

	@PostMapping(value = "/payment/create")
	public ResponseEntity<Integer> create(@RequestBody Payment payment);

	@GetMapping(value = "/payment/get/{id}")
	public ResponseEntity<Payment> getPaymentById(@PathVariable("id") Long id);

}
