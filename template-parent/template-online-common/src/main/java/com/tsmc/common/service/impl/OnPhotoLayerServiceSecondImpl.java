package com.tsmc.common.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.tsmc.common.entity.OnPhotoLayer;
import com.tsmc.common.repository.OnPhotoLayerRepository;
import com.tsmc.common.util.EntityVoTranfer;
import com.tsmc.common.vo.OnPhotoLayerVo;
import com.tsmc.common.service.OnPhotoLayerService;
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
	public OnPhotoLayerVo findById(String photoLayer) {
		Optional<OnPhotoLayer> onPhotoLayer = onPhotoLayerRepository.findById(photoLayer);
		OnPhotoLayerVo onPhotoLayerVo = new OnPhotoLayerVo();
		if(onPhotoLayer.isPresent()) {
			entityToVo.Tranfer(onPhotoLayer.get(), onPhotoLayerVo);
		}
		return onPhotoLayerVo;
	}

	@Override
	public OnPhotoLayer update(OnPhotoLayerVo onPhotoLayerVo) {
		OnPhotoLayer onPhotoLayer = new OnPhotoLayer();
		voToentity.Tranfer(onPhotoLayerVo, onPhotoLayer);
		return onPhotoLayerRepository.save(onPhotoLayer);
	}

	@Override
	public OnPhotoLayer insert(OnPhotoLayerVo onPhotoLayerVo) {
		OnPhotoLayer onPhotoLayer = new OnPhotoLayer();
		voToentity.Tranfer(onPhotoLayerVo, onPhotoLayer);
		return onPhotoLayerRepository.save(onPhotoLayer);
	}

	@Override
	public void delete(String photoLayer) {
		
		onPhotoLayerRepository.deleteById(photoLayer);
		
	}

}
