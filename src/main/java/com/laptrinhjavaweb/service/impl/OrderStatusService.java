package com.laptrinhjavaweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.laptrinhjavaweb.dao.IOrderStatusDAO;
import com.laptrinhjavaweb.entity.OrderStatusEntity;
import com.laptrinhjavaweb.service.IOrderStatusService;

@Service
@Transactional
public class OrderStatusService extends AbstractGenericService<IOrderStatusDAO, OrderStatusEntity> implements IOrderStatusService{
	@Autowired
	public void setDao(IOrderStatusDAO daoToSet) {
		dao = daoToSet;
		dao.setClazz(OrderStatusEntity.class);
	}
}
