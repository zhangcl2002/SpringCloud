package com.aegonthtf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@SpringBootApplication
@EnableEurekaClient
@RestController
@EnableHystrix
@EnableHystrixDashboard
public class MailNotifierApplication {
	private static Logger log = LoggerFactory.getLogger(MailNotifierApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MailNotifierApplication.class, args);
	}

	@RequestMapping("/notify")
	@HystrixCommand(fallbackMethod = "NotifyError")
	public void mailNotify() {
		log.info("Mail message has been sent");
	}

	public void NotifyError() {
		log.error("Mail send error");
	}
}
