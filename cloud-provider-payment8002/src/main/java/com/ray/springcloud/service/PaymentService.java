package com.ray.springcloud.service;

import com.ray.springcloud.entities.Payment;

public interface PaymentService {

	public int create(Payment payment);

	public Payment getPaymentById(Long id);

}
