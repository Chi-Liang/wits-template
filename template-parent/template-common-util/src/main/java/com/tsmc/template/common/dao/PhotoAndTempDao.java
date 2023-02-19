package com.tsmc.template.common.dao;

import java.util.List;

import com.tsmc.template.common.dto.PhotoAndTempDto;

public interface PhotoAndTempDao {
	
	public List<PhotoAndTempDto> getPhotoAndConfigType();
	
}
