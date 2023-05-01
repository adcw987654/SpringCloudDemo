package com.ray.springcloud.order.controller;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.ray.springcloud.entities.CommonResult;
//import com.ray.springcloud.entities.Payment;
//import com.ray.springcloud.rest.OrderFeignClient;
//import com.ray.springcloud.rest.PaymentFeignClient;

//@RestController
//@RequestMapping("/feign")
//public class OrderControllerFeignRest implements OrderFeignClient {
//
//	@Autowired
//	PaymentFeignClient paymentFeigntClient;
//	
//	@Override
//	public CommonResult<Integer> create(Payment payment) {
//		return paymentFeigntClient.create(payment);
//	}
//
//	@Override
//	public CommonResult<Payment> getPayment(Long id) {
//		return paymentFeigntClient.getPaymentById(id);
//	}
//
//}
