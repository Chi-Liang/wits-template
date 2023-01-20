package com.tsmc.online.web.smaple;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import com.tsmc.common.vo.OnPhotoLayerVo;
import com.tsmc.common.vo.ReturnOnPhotoLayerVo;
import com.tsmc.online.web.BaseTest;

public class OnPhotoLayerControllerTest extends BaseTest {
	
	public static OnPhotoLayerVo onPhotoLayerVo;
	
	@BeforeAll
	public static void init() {
		onPhotoLayerVo = new OnPhotoLayerVo();
		onPhotoLayerVo.setPhotoLayer("kkk");
		onPhotoLayerVo.setPhotoLayerName("jjj");
		onPhotoLayerVo.setConfigType("bbb");
	}
	
	@Test
	@Order(1)
	public void testInsert() {


        HttpEntity<OnPhotoLayerVo> request = new HttpEntity<>(onPhotoLayerVo);
        ResponseEntity<ReturnOnPhotoLayerVo> responseEntity =
                testRestTemplate.postForEntity("/onPhotoLayer/insert", request, ReturnOnPhotoLayerVo.class);
        
        ReturnOnPhotoLayerVo returnOnPhotoLayerVo = responseEntity.getBody();
        assertNotNull(returnOnPhotoLayerVo);
        assertTrue(returnOnPhotoLayerVo.isSuccess());
        

	}
	
	@Test
	@Order(2)
	public void testFindById() {

		ResponseEntity<ReturnOnPhotoLayerVo> responseEntity = testRestTemplate.postForEntity(
				"/onPhotoLayer/findById?photoLaye=" + onPhotoLayerVo.getPhotoLayer(), null, ReturnOnPhotoLayerVo.class);

		ReturnOnPhotoLayerVo returnOnPhotoLayerVo = responseEntity.getBody();
		assertNotNull(returnOnPhotoLayerVo);
		assertTrue(returnOnPhotoLayerVo.isSuccess());

	}
	
	@Test
	@Order(3)
	public void testFindAll() {

		ResponseEntity<ReturnOnPhotoLayerVo> responseEntity = testRestTemplate.postForEntity(
				"/onPhotoLayer/findAll", null, ReturnOnPhotoLayerVo.class);

		ReturnOnPhotoLayerVo returnOnPhotoLayerVo = responseEntity.getBody();
		assertNotNull(returnOnPhotoLayerVo);
		assertTrue(returnOnPhotoLayerVo.isSuccess());
		
	}
	
	@Test
	@Order(4)
	public void testUpdate() {
		String photoLayerName = "hhh";
		onPhotoLayerVo.setPhotoLayerName(photoLayerName);
		
		HttpEntity<OnPhotoLayerVo> request = new HttpEntity<>(onPhotoLayerVo);
        ResponseEntity<ReturnOnPhotoLayerVo> responseEntity =
                testRestTemplate.postForEntity("/onPhotoLayer/update", request, ReturnOnPhotoLayerVo.class);
        
        ReturnOnPhotoLayerVo returnOnPhotoLayerVo = responseEntity.getBody();
        assertNotNull(returnOnPhotoLayerVo);
        assertTrue(returnOnPhotoLayerVo.isSuccess());

	}
	
	@Test
	@Order(5)
	public void testDelete() {

        ResponseEntity<ReturnOnPhotoLayerVo> responseEntity =
				testRestTemplate.postForEntity("/onPhotoLayer/delete?photoLaye=" + onPhotoLayerVo.getPhotoLayer(),
						null, ReturnOnPhotoLayerVo.class);
        
        ReturnOnPhotoLayerVo returnOnPhotoLayerVo = responseEntity.getBody();
        assertNotNull(returnOnPhotoLayerVo);
        assertTrue(returnOnPhotoLayerVo.isSuccess());

	}

}
