package com.tsmc.template.online.common.service;

import java.util.List;

public interface CrudCommonService<T> {

	public List<T> findAll();
	
	public T findById(T t);
	
	public T saveOrUpdate(T t);
	
	public void deleteById(T t);
	
}
