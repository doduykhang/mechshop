package com.laptrinhjavaweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.dao.IOrderDAO;
import com.laptrinhjavaweb.entity.OrderEntity;
import com.laptrinhjavaweb.service.IOrderService;

@Service
@Transactional
public class OrderService extends AbstractGenericService<IOrderDAO, OrderEntity> implements IOrderService{
	@Autowired
	public void setDao(IOrderDAO daoToSet) {
		dao = daoToSet;
		dao.setClazz(OrderEntity.class);
	}
}
