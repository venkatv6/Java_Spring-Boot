package com.pratice.springboot.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pratice.springboot.configuration.BasicConfiguration;

@RestController
public class WelcomeController {

	@Autowired
	private WelcomeService welcomeService;
	
	@Autowired
	private BasicConfiguration configuration;

	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome" + "		" + welcomeService.retireWelcomeMessage();

	}
	
	@GetMapping("/welcomefromProp")
	public String welcomefromProp() {
		return "Welcome" + "		" + welcomeService.retireWelcomeMessageProp();

	}
	
	@GetMapping("/configuration")
	public Map configurationDynamic() {
		
		Map map = new HashMap<>();
		map.put("message", configuration.getDescription());
        map.put("number", configuration.getNumber());
        map.put("key", configuration.isValue());
		
		return map;

	}
	

}
