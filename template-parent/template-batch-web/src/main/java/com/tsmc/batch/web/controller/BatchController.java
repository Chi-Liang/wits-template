package com.tsmc.batch.web.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tsmc.common.service.SampleService;
import com.tsmc.common.vo.BaseVo;
import com.tsmc.common.service.PhotoLayerService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/job")
@RequiredArgsConstructor
public class BatchController {
	
	private final PhotoLayerService photoLayerService;
	private final SampleService sampleService;
	
	@PostMapping("/photoLayer")
	public BaseVo photoLayer() {
		
		return photoLayerService.startJob();
		
	}
	
	@PostMapping("/sample")
	public BaseVo sample() {
		
		return sampleService.startJob();
		
	}
	
}
