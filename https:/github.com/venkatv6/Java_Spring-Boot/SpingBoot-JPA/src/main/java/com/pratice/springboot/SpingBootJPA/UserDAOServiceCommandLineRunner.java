package com.pratice.springboot.SpingBootJPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.pratice.springboot.SpingBootJPA.Service.UserDAOService;
import com.pratice.springboot.SpingBootJPA.entity.User;

@Component
public class UserDAOServiceCommandLineRunner implements CommandLineRunner{

	@Autowired
	UserDAOService userDAOService;
	
	@Override
	public void run(String... args) throws Exception {

		User user = new User("Jack" , "Admin" );
		userDAOService.insert(user);
	}

}
