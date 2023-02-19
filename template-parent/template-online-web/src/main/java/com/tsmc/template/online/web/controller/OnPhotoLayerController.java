package com.tsmc.template.online.web.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

import com.tsmc.template.common.vo.OnPhotoLayerVo;
import com.tsmc.template.common.vo.ReturnOnPhotoLayerVo;
import com.tsmc.template.online.common.service.OnPhotoLayerService;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/onPhotoLayer")
@RequiredArgsConstructor
//http://localhost:8081/online/onPhotoLayer/findAll
public class OnPhotoLayerController {
	
	private final OnPhotoLayerService onPhotoLayerServiceFirst;
	
	private final OnPhotoLayerService onPhotoLayerServiceSecond;
	
	
	@PostMapping("/findAll")
	public ReturnOnPhotoLayerVo findAll() {
		List<OnPhotoLayerVo> onPhotoLayerVoList = onPhotoLayerServiceFirst.findAll();
		return new ReturnOnPhotoLayerVo(true,"",onPhotoLayerVoList);
	}
	
	@PostMapping("/findById")
	public ReturnOnPhotoLayerVo findById(@RequestBody OnPhotoLayerVo onPhotoLayerVo) {
		OnPhotoLayerVo onPhotoLayerVo1 = onPhotoLayerServiceFirst.findById(onPhotoLayerVo);
		return new ReturnOnPhotoLayerVo(true,"",Arrays.asList(onPhotoLayerVo1));
	}
	
	@PostMapping("/save")
	public ReturnOnPhotoLayerVo save(@RequestBody OnPhotoLayerVo onPhotoLayerVo) {
		onPhotoLayerServiceFirst.saveOrUpdate(onPhotoLayerVo);
		return new ReturnOnPhotoLayerVo(true,"",null);
	}
	
	@PostMapping("/update")
	public ReturnOnPhotoLayerVo update(@RequestBody OnPhotoLayerVo onPhotoLayerVo) {
		onPhotoLayerServiceFirst.saveOrUpdate(onPhotoLayerVo);
		return new ReturnOnPhotoLayerVo(true,"",null);
	}
	
	@PostMapping("/deleteById")
	public ReturnOnPhotoLayerVo deleteById(@RequestBody OnPhotoLayerVo onPhotoLayerVo) {
		onPhotoLayerServiceSecond.deleteById(onPhotoLayerVo);
		return new ReturnOnPhotoLayerVo(true,"",null);
	}
	
}
