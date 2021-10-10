package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.entity.ProductEntity;

public interface IProductService extends IGenericService<ProductEntity>{
	public List<ProductEntity> getListFeatureProduct();
}
