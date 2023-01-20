package com.tsmc.common.vo;

import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class ReturnOnPhotoLayerVo extends BaseVo {

	public ReturnOnPhotoLayerVo(boolean isSuccess, String msg,List<OnPhotoLayerVo> onPhotoLayerVoList) {
		super(isSuccess, msg);
		this.onPhotoLayerVoList = onPhotoLayerVoList;
	}
	
	private List<OnPhotoLayerVo> onPhotoLayerVoList;

}
