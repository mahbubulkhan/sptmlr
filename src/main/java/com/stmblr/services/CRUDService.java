package com.stmblr.services;

import java.util.List;



public interface CRUDService<T> {
	
	List<?> listAll();

	public T getById(Integer id);

	public T saveOrUpdate(T domainObject);

	public void delete(Integer id);

}
