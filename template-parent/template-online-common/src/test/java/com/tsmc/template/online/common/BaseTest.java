package com.tsmc.template.online.common;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import com.tsmc.template.online.common.service.OnPhotoLayerService;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@Transactional(rollbackFor = Exception.class)
//@Rollback
public class BaseTest {
	
    protected OnPhotoLayerService onPhotoLayerServiceFirst;
	
    protected OnPhotoLayerService onPhotoLayerServiceSecond;
	
	@Autowired
	public void setBaseTest(OnPhotoLayerService onPhotoLayerServiceFirst,
			                 OnPhotoLayerService onPhotoLayerServiceSecond) {
		
		this.onPhotoLayerServiceFirst = onPhotoLayerServiceFirst;
		this.onPhotoLayerServiceSecond = onPhotoLayerServiceSecond;
		
	}
	
}
