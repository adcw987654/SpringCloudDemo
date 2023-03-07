package com.ray.springcloud;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = PaymentMain8001.class)
@ActiveProfiles("dev")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureMockMvc
public class PaymentTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	@Order(1)
	void queryPaymentTest() throws Exception {
		String id = "1";
		mockMvc.perform(get(String.format("/payment/get/%s", id)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(jsonPath("$.code", is("200")));
	}

//	@Test
//	@Order(2)
//	void createPaymentTest() throws Exception {
//		String requestJson = IOUtils
//				.toString(this.getClass().getClassLoader().getResourceAsStream("queryPaymentTest.json"), "UTF8");
//	}
}
