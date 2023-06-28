package com.ray.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ray.springcloud.entities.ResponseEntity;
import com.ray.springcloud.entities.Payment;
import com.ray.springcloud.service.PaymentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class PaymentController {

	@Value("${server.port}")
	private String port;

	@Autowired
	private PaymentService paymentService;

	@PostMapping(value = "/payment/create")
	public ResponseEntity<Integer> create(@RequestBody Payment payment) {
		log.info("port:" + port);
		int result = paymentService.create(payment);
		log.info("插入結果:" + result);
		if (result > 0) {
			return new ResponseEntity<Integer>(200, "新增成功,port:" + port, result);
		}
		return new ResponseEntity<Integer>(444, "新增失敗", null);
	}

	@GetMapping(value = "/payment/get/{id}")
	public ResponseEntity<Payment> getPaymentById(@PathVariable("id") Long id) {
		Payment payment = paymentService.getPaymentById(id);
		log.info("查詢結果:" + payment);
		if (payment != null) {
			return new ResponseEntity<Payment>(200, "查詢成功,port:" + port, payment);
		} else {
			return new ResponseEntity<Payment>(444, "查詢失敗", payment);
		}
	}

}
