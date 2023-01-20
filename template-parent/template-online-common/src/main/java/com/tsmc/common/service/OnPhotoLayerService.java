package com.tsmc.common.service;

import java.util.List;

import com.tsmc.common.entity.OnPhotoLayer;
import com.tsmc.common.vo.OnPhotoLayerVo;


public interface OnPhotoLayerService {
	
	public List<OnPhotoLayerVo> findAll();
	
	public OnPhotoLayerVo findById(String photoLayer);
	
	public OnPhotoLayer update(OnPhotoLayerVo onPhotoLayerVo);
	
	public OnPhotoLayer insert(OnPhotoLayerVo onPhotoLayerVo);
	
	public void delete(String photoLayer);
	
	
	
}
