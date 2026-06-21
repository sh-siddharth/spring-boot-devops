package com.example.deploy_demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.test.web.servlet.client.RestTestClient;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureRestTestClient
class DeployDemoApplicationTests {

	@Autowired
	private RestTestClient client;

	@Test
	void contextLoads() {
	}

	@Test
	void shouldReturnDefaultMessage() {
		// 1. Send the request and expect a String body back
		String response = this.client.get()
				.uri("/")
				.exchange()
				.expectStatus().isOk() // Optional: Good DevOps practice to check HTTP 200 first!
				.expectBody(String.class)
				.returnResult()
				.getResponseBody();

		// 2. Verify the response contains our string
		assertThat(response).contains("Wow! My automated pipeline");
	}


}
