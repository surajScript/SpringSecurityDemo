package com.example.springsecuritydemo;

import com.example.springsecuritydemo.model.User;
import com.example.springsecuritydemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringsecuritydemoApplication implements CommandLineRunner {

	@Autowired
	UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(SpringsecuritydemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = User.builder()
				.userName("Suraj")
				.password("1234")
				.roles("SUPERUSER,ADMIN")
				.build();
		userService.saveUser(user);

	}
}
