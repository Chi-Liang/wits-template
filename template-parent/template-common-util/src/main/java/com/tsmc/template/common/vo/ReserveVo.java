package com.tsmc.template.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReserveVo {
	private Long id;
	private String title;
	private String start;
	private String end;
	
}
