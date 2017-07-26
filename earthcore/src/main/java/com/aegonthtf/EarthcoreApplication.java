package com.aegonthtf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class EarthcoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(EarthcoreApplication.class, args);
	}
}
