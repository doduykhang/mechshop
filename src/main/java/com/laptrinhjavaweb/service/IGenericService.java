package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.dao.IGenericDAO;
import com.laptrinhjavaweb.entity.BaseEntity;


public interface IGenericService<T extends BaseEntity> {
	public List<T> findAll();

	public T findById(final String id);
	
	public List<T> listByPage(int page, int size, String orderBy);

	public void save(final T entity);

	public void update(final T entity);

	public void delete(final T entity);
}
