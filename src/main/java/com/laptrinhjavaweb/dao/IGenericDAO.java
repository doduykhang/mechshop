package com.laptrinhjavaweb.dao;

import java.util.List;

import com.laptrinhjavaweb.entity.BaseEntity;


public interface IGenericDAO<T extends BaseEntity> {
	public void setClazz(Class<T> clazzToSet);
	
	public T findOne(String id);

    public List<T> findAll();

    public T create(T entity);

    public void update(T entity);

    public void delete(T entity);

    public void deleteById(String entityId);	
    
    public List<T> listByPage(int page, int size, String orderBy);
}
