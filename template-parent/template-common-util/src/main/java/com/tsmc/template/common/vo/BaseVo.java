package com.tsmc.template.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BaseVo {
	
	protected boolean isSuccess;
	protected String msg;	

	
}
