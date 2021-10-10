package com.laptrinhjavaweb.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.dao.IOrderDAO;
import com.laptrinhjavaweb.entity.OrderEntity;

@Repository(value = "orderDAO")
@Transactional(rollbackFor = Exception.class)
public class OrderDAO extends AbtrasctGenericDAO<OrderEntity> implements IOrderDAO{

}
