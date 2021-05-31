package com.pratice.springboot.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component
public class LoginValidatorService {

	public boolean validate(String userid, String password) {
		return userid.equalsIgnoreCase("venkat") && password.equalsIgnoreCase("password");
	}

}
