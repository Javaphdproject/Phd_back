package com.PhD_UAE.PhD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync

@SpringBootApplication(scanBasePackages = "com.PhD_UAE.PhD")
public class PhDApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhDApplication.class, args);
	}

}
