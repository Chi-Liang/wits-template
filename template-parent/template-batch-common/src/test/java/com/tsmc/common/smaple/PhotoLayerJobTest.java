package com.tsmc.common.smaple;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobInstance;
import org.springframework.beans.factory.annotation.Autowired;

import com.tsmc.common.BaseTest;
import com.tsmc.common.entity.OnPhotoLayer;
import com.tsmc.common.vo.BaseVo;
import com.tsmc.common.vo.OnPhotoLayerVo;

public class PhotoLayerJobTest extends BaseTest {

	@Test
	public void testPhotoLayerJob() {
		BaseVo vo = photoLayerService.startJob();
		assertTrue(vo.isSuccess());
	}

}
