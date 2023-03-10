package com.tsmc.template.online.web.controller;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import com.tsmc.template.common.vo.OnPhotoLayerVo;
import com.tsmc.template.common.vo.ReturnOnPhotoLayerVo;
import com.tsmc.template.online.web.BaseTest;


public class OnPhotoLayerControllerTest extends BaseTest {
	
	public static OnPhotoLayerVo onPhotoLayerVo;
	public static HttpEntity<OnPhotoLayerVo> request;
	
	@BeforeAll
	public static void init() {
		onPhotoLayerVo = new OnPhotoLayerVo();
		onPhotoLayerVo.setPhotoLayer("963");
		onPhotoLayerVo.setPhotoLayerName("jjj");
		onPhotoLayerVo.setConfigType("bbb");
		
		request = new HttpEntity<>(onPhotoLayerVo);
	}
	
	@Test
	@Order(1)
	public void testSave() {

        ResponseEntity<ReturnOnPhotoLayerVo> responseEntity =
                testRestTemplate.postForEntity("/onPhotoLayer/save", request, ReturnOnPhotoLayerVo.class);
        
        ReturnOnPhotoLayerVo returnOnPhotoLayerVo = responseEntity.getBody();
        assertNotNull(returnOnPhotoLayerVo);
        assertTrue(returnOnPhotoLayerVo.isSuccess());
        

	}
	
	@Test
	@Order(2)
	public void testFindById() {
		ResponseEntity<ReturnOnPhotoLayerVo> responseEntity =
	                testRestTemplate.postForEntity("/onPhotoLayer/findById", request, ReturnOnPhotoLayerVo.class);

		ReturnOnPhotoLayerVo returnOnPhotoLayerVo = responseEntity.getBody();
		assertNotNull(returnOnPhotoLayerVo);
		assertTrue(returnOnPhotoLayerVo.isSuccess());

	}
	
	@Test
	@Order(3)
	public void testFindAll() {

		ResponseEntity<ReturnOnPhotoLayerVo> responseEntity =
	                testRestTemplate.postForEntity("/onPhotoLayer/findAll", null, ReturnOnPhotoLayerVo.class);

		ReturnOnPhotoLayerVo returnOnPhotoLayerVo = responseEntity.getBody();
		assertNotNull(returnOnPhotoLayerVo);
		assertTrue(returnOnPhotoLayerVo.isSuccess());
		
	}
	
	@Test
	@Order(4)
	public void testUpdate() {
		String photoLayerName = "hhh";
		onPhotoLayerVo.setPhotoLayerName(photoLayerName);
		
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
                testRestTemplate.postForEntity("/onPhotoLayer/deleteById", request, ReturnOnPhotoLayerVo.class);
        
        ReturnOnPhotoLayerVo returnOnPhotoLayerVo = responseEntity.getBody();
        assertNotNull(returnOnPhotoLayerVo);
        assertTrue(returnOnPhotoLayerVo.isSuccess());

	}

}
