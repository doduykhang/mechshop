package com.laptrinhjavaweb.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.dao.IProductImageDAO;
import com.laptrinhjavaweb.entity.ProductImageEntity;

@Repository(value = "productImageDAO")
@Transactional(rollbackFor = Exception.class)
public class ProductImageDAO extends AbtrasctGenericDAO<ProductImageEntity> implements IProductImageDAO{

}
