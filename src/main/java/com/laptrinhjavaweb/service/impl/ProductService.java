package com.laptrinhjavaweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.dao.IProductDAO;
import com.laptrinhjavaweb.entity.ProductEntity;
import com.laptrinhjavaweb.service.IProductService;

@Service
@Transactional
public class ProductService extends AbstractGenericService<IProductDAO, ProductEntity> implements IProductService{
	@Autowired
	public void setDao(IProductDAO daoToSet) {
		dao = daoToSet;
		dao.setClazz(ProductEntity.class);
	}
	public List<ProductEntity> getListFeatureProduct(){
		return dao.getListFeatureProduct();
	}
}
