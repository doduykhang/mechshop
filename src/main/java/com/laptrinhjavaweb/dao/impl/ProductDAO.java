package com.laptrinhjavaweb.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.dao.IProductDAO;
import com.laptrinhjavaweb.entity.ProductEntity;

@Repository(value = "productDAO")
@Transactional(rollbackFor = Exception.class)
public class ProductDAO extends AbtrasctGenericDAO<ProductEntity> implements IProductDAO{
	
	@Override
	public List<ProductEntity> getListFeatureProduct() {
		String hql = "from ProductEntity P where P.IsFeatured = 1";
		
		Query query = super.getCurrentSession().createQuery(hql);
		List<ProductEntity> results = query.list();
		return results;
	}
	
}
