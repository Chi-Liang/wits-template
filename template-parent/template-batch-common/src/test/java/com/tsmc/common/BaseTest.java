package com.tsmc.common;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.tsmc.common.service.PhotoLayerService;
import com.tsmc.common.service.SampleService;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@Transactional(rollbackFor = Exception.class)
//@Rollback
public class BaseTest {

	protected PhotoLayerService photoLayerService;

	protected SampleService sampleService;

	@Autowired
	public void setBaseTest(PhotoLayerService photoLayerService, SampleService sampleService) {

		this.photoLayerService = photoLayerService;
		this.sampleService = sampleService;

	}

}
