package com.laptrinhjavaweb.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.dao.IProductItemDAO;
import com.laptrinhjavaweb.entity.ProductItemEntity;

@Repository(value = "productItemDAO")
@Transactional(rollbackFor = Exception.class)
public class ProductItemDAO extends AbtrasctGenericDAO<ProductItemEntity> implements IProductItemDAO{

}
