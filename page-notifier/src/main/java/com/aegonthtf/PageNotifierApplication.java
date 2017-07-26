package com.aegonthtf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@SpringBootApplication
@EnableEurekaClient
@RestController
@EnableHystrix
@EnableHystrixDashboard
public class PageNotifierApplication {

	private static Logger log = LoggerFactory.getLogger(PageNotifierApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(PageNotifierApplication.class, args);
	}


	@RequestMapping("/notify")
    @HystrixCommand(fallbackMethod = "NotifyError")
    public void pageNotify() {
        log.info("SMS message has been sent");
    }

    public void NotifyError() {
    	log.error("SMS send error");
    }	
}
