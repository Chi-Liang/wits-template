package com.tsmc.online.web.controller;

import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import com.tsmc.common.service.OnPhotoLayerService;
import com.tsmc.common.vo.OnPhotoLayerVo;
import com.tsmc.common.vo.ReturnOnPhotoLayerVo;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/onPhotoLayer")
@RequiredArgsConstructor
//http://localhost:8081/online/onPhotoLayer/findAll
public class OnPhotoLayerController {
	
	private final OnPhotoLayerService onPhotoLayerServiceFirst;
	
	private final OnPhotoLayerService onPhotoLayerServiceSecond;
	
	@PostMapping("/findAll")
	@Operation(summary = "Find all PhotoLaye")
	public ReturnOnPhotoLayerVo findAll() {
		List<OnPhotoLayerVo> onPhotoLayerVoList = onPhotoLayerServiceFirst.findAll();
		return new ReturnOnPhotoLayerVo(true,"",onPhotoLayerVoList);
	}
	
	@PostMapping("/findById")
	@Operation(summary = "findById PhotoLaye")
	public ReturnOnPhotoLayerVo findById(@RequestParam String photoLaye) {
		OnPhotoLayerVo onPhotoLayerVo = onPhotoLayerServiceFirst.findById(photoLaye);
		return new ReturnOnPhotoLayerVo(true,"",Arrays.asList(onPhotoLayerVo));
	}
	
	@PostMapping("/insert")
	@Operation(summary = "insert PhotoLaye")
	public ReturnOnPhotoLayerVo insert(@RequestBody OnPhotoLayerVo onPhotoLayerVo) {
		onPhotoLayerServiceFirst.insert(onPhotoLayerVo);
		return new ReturnOnPhotoLayerVo(true,"",null);
	}
	
	@PostMapping("/update")
	@Operation(summary = "update PhotoLaye")
	public ReturnOnPhotoLayerVo update(@RequestBody OnPhotoLayerVo onPhotoLayerVo) {
		onPhotoLayerServiceFirst.update(onPhotoLayerVo);
		return new ReturnOnPhotoLayerVo(true,"",null);
	}
	
	@PostMapping("/delete")
	@Operation(summary = "delete PhotoLaye")
	public ReturnOnPhotoLayerVo delete(@RequestParam String photoLaye) {
		onPhotoLayerServiceSecond.delete(photoLaye);
		return new ReturnOnPhotoLayerVo(true,"",null);
	}
	
}
