package com.pratice.springboot.service;

import org.springframework.stereotype.Component;

@Component
public class LoginService {

	public boolean validate(String userid, String password) {
		return userid.equalsIgnoreCase("venkat") && password.equalsIgnoreCase("password");
	}

}
