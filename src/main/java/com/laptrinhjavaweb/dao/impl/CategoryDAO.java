package com.laptrinhjavaweb.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.dao.ICategoryDAO;
import com.laptrinhjavaweb.entity.CategoryEntity;

@Repository(value = "catagoryDAO")
@Transactional(rollbackFor = Exception.class)
public class CategoryDAO extends AbtrasctGenericDAO<CategoryEntity> implements ICategoryDAO{

	@Override
	public CategoryEntity findOneByCode(String code) {
		String hql = "from CategoryEntity c where c.categoryCode = :category_code";
		
		Query query = super.getCurrentSession().createQuery(hql);
		query.setParameter("category_code", code);
		List<CategoryEntity> results = query.list();
		CategoryEntity entity = results.get(0);
		
		return entity;
	}
	
//	@Override
//	public CategoryEntity findOneByCode(String code) {
//		String sql = "CAll SP_GetProductsWithSort (:maxPrice,:minPrice,:keyWord,:catagoryId)";
//		
//		Query query = super.getCurrentSession().createSQLQuery(sql)
//												.setParameter("maxPrice", 100)
//												.setParameter("minPrice", 100)
//												.setParameter("keyWord", "t")
//												.setParameter("catagoryId", "1");
//		
//		List<Object[]> results = query.list();
//		
//		System.out.println(results.size());
//		return new CategoryEntity();
//	}
}
