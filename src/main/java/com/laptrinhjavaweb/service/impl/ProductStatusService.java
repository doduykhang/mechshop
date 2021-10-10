package com.laptrinhjavaweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.dao.IProductDAO;
import com.laptrinhjavaweb.dao.IProductStatusDAO;
import com.laptrinhjavaweb.entity.ProductEntity;
import com.laptrinhjavaweb.entity.ProductStatusEntity;
import com.laptrinhjavaweb.service.IProductStatusService;

@Service
@Transactional
public class ProductStatusService extends AbstractGenericService<IProductStatusDAO, ProductStatusEntity> implements IProductStatusService{
	@Autowired
	public void setDao(IProductStatusDAO daoToSet) {
		dao = daoToSet;
		dao.setClazz(ProductStatusEntity.class);
	}
}
