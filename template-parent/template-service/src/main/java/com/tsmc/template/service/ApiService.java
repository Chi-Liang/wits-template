package com.tsmc.template.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ApiService {
	
	public void opentdb() {
		
		RestTemplate restTemplate = new RestTemplate();
		
		Object object = restTemplate.getForObject("https://opentdb.com/api.php?amount=1&category=18", Object.class);
		log.info(object.toString());
		
	}
	
}
