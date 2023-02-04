package com.tsmc.common.service;

import java.util.List;

public interface CrudCommonService<T> {

	public List<T> findAll();
	
	public T findById(T t);
	
	public T insertOrUpdate(T t);
	
	public void deleteById(T t);
	
}
