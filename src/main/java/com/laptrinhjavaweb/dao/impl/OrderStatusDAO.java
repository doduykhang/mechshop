package com.laptrinhjavaweb.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.dao.IOrderStatusDAO;
import com.laptrinhjavaweb.entity.OrderStatusEntity;

@Repository(value = "orderStatusDAO")
@Transactional(rollbackFor = Exception.class)
public class OrderStatusDAO extends AbtrasctGenericDAO<OrderStatusEntity> implements IOrderStatusDAO{

}
