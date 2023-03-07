package com.ray.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ray.springcloud.entities.CommonResult;
import com.ray.springcloud.entities.Payment;
import com.ray.springcloud.service.PaymentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@PostMapping(value = "/payment/create")
	public CommonResult<Integer> create(Payment payment) {
		int result = paymentService.create(payment);
		log.info("插入結果:" + result);
		if (result > 0) {
			return new CommonResult<Integer>(200, "新增成功", result);
		}
		return new CommonResult<Integer>(444, "新增失敗", null);
	}

	@GetMapping(value = "/payment/get/{id}")
	public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
		Payment payment = paymentService.getPaymentById(id);
		log.info("插入結果:" + payment);
		if (payment != null) {
			return new CommonResult<Payment>(200, "新增成功", payment);
		} else {
			return new CommonResult<Payment>(444, "新增失敗", payment);
		}
	}

}
