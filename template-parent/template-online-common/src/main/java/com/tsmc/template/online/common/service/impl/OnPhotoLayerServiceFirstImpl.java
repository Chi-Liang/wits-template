package com.tsmc.template.online.common.service.impl;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import com.tsmc.template.common.config.ConfigValue;
import com.tsmc.template.common.constant.MsgConstant;
import com.tsmc.template.common.dao.PhotoAndTempDao;
import com.tsmc.template.common.entity.OnPhotoLayer;
import com.tsmc.template.common.repository.OnPhotoLayerRepository;
import com.tsmc.template.common.util.EntityVoTranfer;
import com.tsmc.template.common.util.MessageSourceUtil;
import com.tsmc.template.common.vo.OnPhotoLayerVo;
import com.tsmc.template.online.common.service.OnPhotoLayerService;
import com.tsmc.template.service.ApiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("onPhotoLayerServiceFirst")
@RequiredArgsConstructor
public class OnPhotoLayerServiceFirstImpl implements OnPhotoLayerService {
	
	private final OnPhotoLayerRepository onPhotoLayerRepository;
	private final EntityVoTranfer<OnPhotoLayer,OnPhotoLayerVo> entityToVo;
	private final EntityVoTranfer<OnPhotoLayerVo,OnPhotoLayer> voToentity;
	private final MessageSourceUtil messageSourceUtil;
	private final ConfigValue configValue;
	private final PhotoAndTempDao photoAndTempDao;
	private final ApiService apiService;
	
	@Override
	public List<OnPhotoLayerVo> findAll() {
		
		log.info(messageSourceUtil.getMessage(MsgConstant.OnlineMessage.demo_message_args, "aa","bb"));
		log.info(configValue.getBatchSize());
		photoAndTempDao.getPhotoAndConfigType().stream().forEach( p -> log.info(p.toString()));
		apiService.opentdb();
		
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
