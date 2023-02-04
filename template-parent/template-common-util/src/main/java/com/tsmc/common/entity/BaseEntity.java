package com.tsmc.common.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@MappedSuperclass
public class BaseEntity {
	
	@CreationTimestamp
	@Column(name = "CREATE_DT",updatable=false)
	private Date createDt;
	
	@UpdateTimestamp
	@Column(name = "UPDATE_DT")
	private Date updateDt;
	
}
