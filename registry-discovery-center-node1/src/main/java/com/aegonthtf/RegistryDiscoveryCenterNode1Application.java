package com.aegonthtf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class RegistryDiscoveryCenterNode1Application {

	public static void main(String[] args) {
		SpringApplication.run(RegistryDiscoveryCenterNode1Application.class, args);
	}
}
