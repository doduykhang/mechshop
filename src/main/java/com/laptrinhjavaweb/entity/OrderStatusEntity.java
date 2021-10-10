package com.laptrinhjavaweb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "OrderStatus")
public class OrderStatusEntity extends BaseEntity{
	@Column(name = "Name")
	private String name;
	
	@Column(name = "OrderStatusCode")
	private String orderStatusCode;
	
	@OneToMany(mappedBy = "orderStatus")
	private List<OrderEntity> orders = new ArrayList<OrderEntity>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProductStatusCode() {
		return orderStatusCode;
	}

	public void setProductStatusCode(String orderStatusCode) {
		this.orderStatusCode = orderStatusCode;
	}

	public List<OrderEntity> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderEntity> orders) {
		this.orders = orders;
	}
	
	
}
