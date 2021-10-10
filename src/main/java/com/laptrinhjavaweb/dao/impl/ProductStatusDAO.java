package com.laptrinhjavaweb.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.dao.IProductStatusDAO;
import com.laptrinhjavaweb.entity.ProductStatusEntity;

@Repository(value = "productStatusDAO")
@Transactional(rollbackFor = Exception.class)
public class ProductStatusDAO extends AbtrasctGenericDAO<ProductStatusEntity> implements IProductStatusDAO{

}
