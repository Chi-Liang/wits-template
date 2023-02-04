package com.tsmc.common.smaple;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import com.tsmc.common.BaseTest;
import com.tsmc.common.vo.OnPhotoLayerVo;

public class OnPhotoLayerServiceTest extends BaseTest {
	
	public static OnPhotoLayerVo onPhotoLayerVo;
	
	@BeforeAll
	public static void init() {
		onPhotoLayerVo = new OnPhotoLayerVo();
		onPhotoLayerVo.setPhotoLayer("zzz");
		onPhotoLayerVo.setPhotoLayerName("jjj");
		onPhotoLayerVo.setConfigType("bbb");
	}
	
	@Test
	@Order(1)
	public void testInsert() {
		OnPhotoLayerVo returnVo = onPhotoLayerServiceFirst.insertOrUpdate(onPhotoLayerVo);
		assertEquals(returnVo.getPhotoLayer(),onPhotoLayerVo.getPhotoLayer());

	}
	
	@Test
	@Order(2)
	public void testFindById() {

		OnPhotoLayerVo returnVo = onPhotoLayerServiceFirst.findById(onPhotoLayerVo);
		assertEquals(returnVo.getPhotoLayer(),onPhotoLayerVo.getPhotoLayer());

	}
	
	@Test
	@Order(3)
	public void testFindAll() {

		List<OnPhotoLayerVo> returnVo = onPhotoLayerServiceFirst.findAll();
		assertNotNull(returnVo);
		assertTrue(returnVo.size() > 0); 
		
	}
	
	@Test
	@Order(4)
	public void testUpdate() {
		String photoLayerName = "hhh";
		onPhotoLayerVo.setPhotoLayerName(photoLayerName);
		OnPhotoLayerVo returnVo = onPhotoLayerServiceFirst.insertOrUpdate(onPhotoLayerVo);
		assertEquals(returnVo.getPhotoLayer(),onPhotoLayerVo.getPhotoLayer());
		assertEquals(returnVo.getPhotoLayerName() ,onPhotoLayerVo.getPhotoLayerName());

	}
	
	@Test
	@Order(5)
	public void testDelete() {
		
		onPhotoLayerServiceFirst.deleteById(onPhotoLayerVo);

	}

}
