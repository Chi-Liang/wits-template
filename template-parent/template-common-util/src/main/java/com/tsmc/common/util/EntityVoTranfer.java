package com.tsmc.common.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class EntityVoTranfer<U, T> {

	public T Tranfer(U u, T t) {
		BeanUtils.copyProperties(u, t);
		return t;
	}

}
