package com.stanimalis.springboot.nycsummerbaseball;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class NycsummerbaseballApplication {

	public static void main(String[] args) {
		SpringApplication.run(NycsummerbaseballApplication.class, args);
	}

}
