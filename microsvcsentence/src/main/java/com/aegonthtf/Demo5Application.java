package com.aegonthtf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Demo5Application {
	public static void main(String[] args) {
		SpringApplication.run(Demo5Application.class, args);
	}
}
