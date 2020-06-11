package com.exp.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootApplication
@PropertySource("classpath:application.properties")
public class PlateformeApplication {

	public static PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);

	public static void main(String[] args) {
		SpringApplication.run(PlateformeApplication.class, args);
	}

}
