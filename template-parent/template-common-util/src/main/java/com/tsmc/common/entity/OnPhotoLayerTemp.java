package com.tsmc.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ON_PHOTO_LAYER_TEMP",schema = "DBO")
public class OnPhotoLayerTemp {

	@Id
	@Column(name = "PHOTO_LAYER")
	private String photoLayer;

	@Column(name = "PHOTO_LAYER_NAME")
	private String photoLayerName;
	
	@Column(name = "CONFIG_TYPE")
	private String configType;

}
