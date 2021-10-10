package com.laptrinhjavaweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.dao.IProductImageDAO;
import com.laptrinhjavaweb.entity.ProductImageEntity;
import com.laptrinhjavaweb.service.IProductImageService;

@Service
@Transactional
public class ProductImageService extends AbstractGenericService<IProductImageDAO, ProductImageEntity> implements IProductImageService{
	@Autowired
	public void setDao(IProductImageDAO daoToSet) {
		dao = daoToSet;
		dao.setClazz(ProductImageEntity.class);
	}
	
}
