package com.tsmc.template.online.common.service;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import com.tsmc.template.common.vo.OnPhotoLayerVo;
import com.tsmc.template.online.common.BaseTest;

public class MailServiceTest extends BaseTest {
	
	
	@Test
	public void testSendMail() {
		
		boolean reusult = mailService.sendMail("ChiLiangChen@wistronits.com", "2023-02-26 14:00", "2023-02-26 16:00");
		assertTrue(reusult);

	}
	

}
