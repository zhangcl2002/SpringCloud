package com.aegonthtf;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RefreshScope
@RestController
public class SpringConfigClientApplication {

	
	private final Logger logger = LoggerFactory.getLogger(SpringConfigClientApplication.class);
	
    @Value("${message}")
    private String message;

    @Value("${logcenterAddr}")
    private String logcenterAddr;
          
    @RequestMapping("/message")
    String getMessage() {    	    
    	
    	logger.info("information from a bootiful client");   
    	logger.info("message:" + message);
    	logger.info("logcenterAddr:"+logcenterAddr);
        return this.message;
    }
    
   
	public static void main(String[] args) {
		
		SpringApplication.run(SpringConfigClientApplication.class, args);
	}
}


