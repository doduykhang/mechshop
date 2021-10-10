package com.laptrinhjavaweb.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.dao.IGenericDAO;
import com.laptrinhjavaweb.entity.BaseEntity;
import com.laptrinhjavaweb.entity.UserEntity;

@Service
@Transactional
public abstract class AbstractGenericService<T extends IGenericDAO<U>,U extends BaseEntity> {
	
	T dao;
	
	public List<U> findAll() {
		return dao.findAll();
	}

	public U findById(final String id) {
		return dao.findOne(id);
	}
	
	public List<U> listByPage(int page, int size, String orderBy){
		return dao.listByPage(page, size, orderBy);
	}

	public void save(final U entity){
		dao.create(entity);
	}

	public void update(final U entity) {
		dao.update(entity);
	}

	public void delete(final U entity) {		
		dao.delete(entity);
	}

}
