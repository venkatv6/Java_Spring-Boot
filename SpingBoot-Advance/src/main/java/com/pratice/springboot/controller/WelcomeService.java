package com.pratice.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class WelcomeService {
	@Value("${welcome.message}")
	private String welcomeMsg;
	
	public String retireWelcomeMessage() {
		return "To SpringBoot Prep";

	}
	
	public String retireWelcomeMessageProp() {
		return welcomeMsg;

	}
}
