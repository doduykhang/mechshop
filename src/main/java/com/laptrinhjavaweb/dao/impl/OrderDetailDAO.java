package com.laptrinhjavaweb.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.dao.IOrderDetailDAO;
import com.laptrinhjavaweb.entity.OrderDetailEntity;

@Repository(value = "orderDetailDAO")
@Transactional(rollbackFor = Exception.class)
public class OrderDetailDAO extends AbtrasctGenericDAO<OrderDetailEntity> implements IOrderDetailDAO{

}
