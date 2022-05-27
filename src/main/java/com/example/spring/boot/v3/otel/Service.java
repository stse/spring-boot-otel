package com.example.spring.boot.v3.otel;

import io.micrometer.tracing.annotation.NewSpan;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Service {
	
	private final RestTemplate heise;
	
	Service(RestTemplateBuilder restTemplateBuilder) {
		this.heise = restTemplateBuilder.rootUri("https://www.heise.de").build();
	}
	
	@GetMapping
	public String self() {
		return heise.getForEntity("/", String.class).getBody();
	}
}
