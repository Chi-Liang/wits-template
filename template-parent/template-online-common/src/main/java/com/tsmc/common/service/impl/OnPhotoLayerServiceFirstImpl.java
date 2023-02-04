package com.tsmc.common.service.impl;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import com.tsmc.common.entity.OnPhotoLayer;
import com.tsmc.common.repository.OnPhotoLayerRepository;
import com.tsmc.common.util.EntityVoTranfer;
import com.tsmc.common.util.MessageSourceUtil;
import com.tsmc.common.vo.OnPhotoLayerVo;
import com.tsmc.common.service.OnPhotoLayerService;
import lombok.RequiredArgsConstructor;

@Service("onPhotoLayerServiceFirst")
@RequiredArgsConstructor
public class OnPhotoLayerServiceFirstImpl implements OnPhotoLayerService {
	
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
	public OnPhotoLayerVo insertOrUpdate(OnPhotoLayerVo t) {
		
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
