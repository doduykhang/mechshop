package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.entity.CategoryEntity;

public interface ICategoryService extends IGenericService<CategoryEntity>{
	public CategoryEntity findOneByCode(String code);
}
