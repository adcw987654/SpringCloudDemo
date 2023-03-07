package com.ray.springcloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ray.springcloud.dao.PaymentDao;
import com.ray.springcloud.entities.Payment;
import com.ray.springcloud.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

	// 也可以使用@Resource
	@Autowired
	private PaymentDao paymentDao;

	@Override
	public int create(Payment payment) {
		return paymentDao.create(payment);
	}

	@Override
	public Payment getPaymentById(Long id) {
		return paymentDao.getPaymentById(id);
	}

}
