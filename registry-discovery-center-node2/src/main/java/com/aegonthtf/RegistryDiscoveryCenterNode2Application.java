package com.aegonthtf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class RegistryDiscoveryCenterNode2Application {

	public static void main(String[] args) {
		SpringApplication.run(RegistryDiscoveryCenterNode2Application.class, args);
	}
}
