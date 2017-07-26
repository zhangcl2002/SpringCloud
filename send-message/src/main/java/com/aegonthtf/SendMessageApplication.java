package com.aegonthtf;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@SpringBootApplication
@EnableEurekaClient
@RestController
@EnableHystrix
@EnableHystrixDashboard
public class SendMessageApplication {
	private static Logger log = LoggerFactory.getLogger(SendMessageApplication.class);
	@Autowired
	DiscoveryClient client;

	@Autowired
	private RestTemplate restTemplate;	

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(SendMessageApplication.class, args);
	}


	@RequestMapping("/notify-user")
    @HystrixCommand(fallbackMethod = "notifyError")
    public void sendMessage() {
		
		log.info("notify executed mail notification.....");
        notify("MAIL-NOTIFIER");
		log.info("notify finish executing mail notification");
		log.info("page notification begin");
        notify("PAGE-NOTIFIER");
        log.info("page notification end");
        
    }

    public void notifyError() {
        log.info("hi,sorry,error!");
    }	
    
    public String notify(String notifyService){
		try {
			List<ServiceInstance> list = client.getInstances(notifyService);
			//log.info("list" + list.toString());

			if (list != null && list.size() > 0) {
				URI uri = list.get(0).getUri();
				//log.info("uri:" + uri.toString());
				uri = new URI(uri.toString().concat("/notify"));

				if (uri != null) {					
					return restTemplate.getForObject(uri, String.class);
				}
			}
			return null;
		} catch (Exception e) {
			log.info(e.toString());
			return null;
		}
    	
    }




}
