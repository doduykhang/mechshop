package com.laptrinhjavaweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.dao.ICategoryDAO;
import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.service.ICategoryService;

@Service
@Transactional
public class CategorySevice extends AbstractGenericService<ICategoryDAO, CategoryEntity> implements ICategoryService{
	@Autowired
	public void setDao(ICategoryDAO daoToSet) {
		dao = daoToSet;
		dao.setClazz(CategoryEntity.class);
	}

	@Override
	public CategoryEntity findOneByCode(String code) {
		return dao.findOneByCode(code);
	}
	
}
