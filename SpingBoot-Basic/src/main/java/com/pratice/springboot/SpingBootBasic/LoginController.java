package com.pratice.springboot.SpingBootBasic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pratice.springboot.service.LoginValidatorService;

@Controller
public class LoginController {
	
	//@Autowired
	LoginValidatorService loginValidatorService = new LoginValidatorService();

	@GetMapping("/login")
	public String loginMessage(ModelMap model) {
		return "login";
	}

	@PostMapping("/login")
	public String loginMessage(@RequestParam String name,@RequestParam String password, ModelMap model) {
		boolean isValidate = loginValidatorService.validate(name, password);
		
		if(!isValidate) {
			model.put("errorMessage", "InvalidCreds!!");
			return "login";
		}
		model.put("name", name);
		model.put("password", password);
		return "welcome";
	}
}
