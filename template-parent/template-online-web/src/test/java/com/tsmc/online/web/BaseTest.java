package com.tsmc.online.web;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@Transactional(rollbackFor = Exception.class)
//@Rollback
public class BaseTest {
	
    protected TestRestTemplate testRestTemplate;
	
	@Autowired
	public void setBaseTest(TestRestTemplate testRestTemplate) {
		this.testRestTemplate = testRestTemplate;
	}
	
}
