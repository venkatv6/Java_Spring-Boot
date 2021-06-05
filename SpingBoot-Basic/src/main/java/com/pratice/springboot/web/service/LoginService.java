package com.pratice.springboot.web.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

	public boolean validate(String userid, String password) {
		return userid.equalsIgnoreCase("venkat") && password.equalsIgnoreCase("password");
	}
}
