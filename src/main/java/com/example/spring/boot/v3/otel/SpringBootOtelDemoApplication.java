package com.example.spring.boot.v3.otel;

import io.opentelemetry.exporter.otlp.trace.OtlpGrpcSpanExporter;
import io.opentelemetry.sdk.trace.export.SpanExporter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootOtelDemoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootOtelDemoApplication.class, args);
	}

	@Bean
	public SpanExporter OtlpGrpcSpanExporter() {
		return OtlpGrpcSpanExporter
			.builder()
			.setEndpoint("https://otlp.eu01.nr-data.net")
			.addHeader("api-key", "please-insert-newrelic-license-key")
			.build();
	}
}
