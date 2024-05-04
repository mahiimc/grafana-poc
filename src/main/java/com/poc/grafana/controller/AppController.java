package com.poc.grafana.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.instrument.MeterRegistry;

@RestController
public class AppController {
	
	
	private final MeterRegistry registry;
	
	@Autowired
	public AppController(MeterRegistry registry) {
		this.registry = registry;
	}
	
	@GetMapping("/message/{message}")
	public String getMessage(@PathVariable("message") String message) {
		registry.counter("custom.metrics.message", "value", message).increment();
		return message;
	}

}
