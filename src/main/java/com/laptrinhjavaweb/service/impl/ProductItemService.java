package com.laptrinhjavaweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.dao.IProductItemDAO;
import com.laptrinhjavaweb.entity.ProductItemEntity;
import com.laptrinhjavaweb.service.IProductItemService;

@Service
@Transactional
public class ProductItemService extends AbstractGenericService<IProductItemDAO, ProductItemEntity> implements IProductItemService{
	@Autowired
	public void setDao(IProductItemDAO daoToSet) {
		dao = daoToSet;
		dao.setClazz(ProductItemEntity.class);
	}
}
