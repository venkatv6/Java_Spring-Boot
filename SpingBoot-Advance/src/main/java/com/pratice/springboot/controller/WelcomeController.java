package com.pratice.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@Autowired
	private WelcomeService welcomeService;
	


	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome" + "		" + welcomeService.retireWelcomeMessage();

	}
	
	@GetMapping("/welcomefromProp")
	public String welcomefromProp() {
		return "Welcome" + "		" + welcomeService.retireWelcomeMessageProp();

	}

}
