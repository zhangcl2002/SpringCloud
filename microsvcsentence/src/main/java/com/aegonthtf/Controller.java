package com.aegonthtf;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controller {

	private static Logger log = LoggerFactory.getLogger(Controller.class);
	@Autowired
	DiscoveryClient client;

	@Autowired
	private RestTemplate restTemplate;

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@RequestMapping("/sentence")
	public String getSentence() {
		log.info("sentence making....");
		return getWord("WORD");// 大小写不区分
	}

	public String getWord(String service) {
		try {
			List<ServiceInstance> list = client.getInstances(service);
			log.info("list" + list.toString());
			if (list != null && list.size() > 0) {
				URI uri = list.get(0).getUri();
				log.info("uri:" + uri.toString());
				uri = new URI(uri.toString().concat("/microsvcword"));

				if (uri != null) {
					log.info("getForObject");
					return restTemplate.getForObject(uri, String.class);
				}
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}