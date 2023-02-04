package com.tsmc.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
@Entity
@Table(name = "ON_PHOTO_LAYER",schema = "DBO")
public class OnPhotoLayer extends BaseEntity {

	@Id
	@Column(name = "PHOTO_LAYER")
	private String photoLayer;

	@Column(name = "PHOTO_LAYER_NAME")
	private String photoLayerName;
	
	@Column(name = "CONFIG_TYPE")
	private String configType;

}
