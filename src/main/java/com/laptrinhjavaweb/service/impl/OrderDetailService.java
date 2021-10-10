package com.laptrinhjavaweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.dao.IOrderDetailDAO;
import com.laptrinhjavaweb.entity.OrderDetailEntity;
import com.laptrinhjavaweb.service.IOrderDetailService;

@Service
@Transactional
public class OrderDetailService extends AbstractGenericService<IOrderDetailDAO,OrderDetailEntity> implements IOrderDetailService{
	@Autowired
	public void setDao(IOrderDetailDAO daoToSet) {
		dao = daoToSet;
		dao.setClazz(OrderDetailEntity.class);
	}
}
