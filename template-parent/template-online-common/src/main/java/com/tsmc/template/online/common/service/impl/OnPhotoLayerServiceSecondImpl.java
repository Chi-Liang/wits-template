package com.tsmc.template.online.common.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

import com.tsmc.template.common.entity.OnPhotoLayer;
import com.tsmc.template.common.repository.OnPhotoLayerRepository;
import com.tsmc.template.common.util.EntityVoTranfer;
import com.tsmc.template.common.vo.OnPhotoLayerVo;
import com.tsmc.template.online.common.service.OnPhotoLayerService;
import lombok.RequiredArgsConstructor;

@Service("onPhotoLayerServiceSecond") //示意 一個interface可以有多個impl
@RequiredArgsConstructor
public class OnPhotoLayerServiceSecondImpl implements OnPhotoLayerService {

	private final OnPhotoLayerRepository onPhotoLayerRepository;
	private final EntityVoTranfer<OnPhotoLayer,OnPhotoLayerVo> entityToVo;
	private final EntityVoTranfer<OnPhotoLayerVo,OnPhotoLayer> voToentity;
	
	@Override
	public List<OnPhotoLayerVo> findAll() {
		
		List<OnPhotoLayerVo> onPhotoLayerVoList = onPhotoLayerRepository.findAll().stream().map( u -> {
			OnPhotoLayerVo onPhotoLayerVo = new OnPhotoLayerVo();
			entityToVo.Tranfer(u, onPhotoLayerVo);
			return onPhotoLayerVo;
		}).collect(Collectors.toList());
		
		return onPhotoLayerVoList;
	}
	
	@Override
	public OnPhotoLayerVo findById(OnPhotoLayerVo t) {
		Optional<OnPhotoLayer> onPhotoLayer = onPhotoLayerRepository.findById(t.getPhotoLayer());
		OnPhotoLayerVo onPhotoLayerVo = new OnPhotoLayerVo();
		if(onPhotoLayer.isPresent()) {
			entityToVo.Tranfer(onPhotoLayer.get(), onPhotoLayerVo);
		}
		return onPhotoLayerVo;
	}
	
	@Override
	public OnPhotoLayerVo saveOrUpdate(OnPhotoLayerVo t) {
		
		OnPhotoLayer onPhotoLayer = new OnPhotoLayer();
		voToentity.Tranfer(t, onPhotoLayer);
		onPhotoLayerRepository.save(onPhotoLayer);
		entityToVo.Tranfer(onPhotoLayer, t);
		return t;
		
	}
	@Override
	public void deleteById(OnPhotoLayerVo t) {
		
		onPhotoLayerRepository.deleteById(t.getPhotoLayer());
		
	}

}
