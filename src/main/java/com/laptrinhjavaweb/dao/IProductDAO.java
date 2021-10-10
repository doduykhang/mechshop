package com.laptrinhjavaweb.dao;

import java.util.List;

import com.laptrinhjavaweb.entity.ProductEntity;

public interface IProductDAO extends IGenericDAO<ProductEntity>{
	public List<ProductEntity> getListFeatureProduct();
}
