package com.laptrinhjavaweb.dao;

import com.laptrinhjavaweb.entity.CategoryEntity;


public interface ICategoryDAO extends IGenericDAO<CategoryEntity>{
	public CategoryEntity findOneByCode(String code);
}
