package com.laptrinhjavaweb.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "OrderBill")
public class OrderEntity extends BaseEntity{
	
	@Column(name = "OrderDate")
	private Date orderDate;
	
	@Column(name = "ShipAddess")
	private String shipAddess;
	
	@Column(name = "ShipMailAddess")
	private String shipMailAddess;
	
	@Column(name = "ShipPhoneNumber")
	private String ShipPhoneNumber;
	
	@OneToMany(mappedBy = "order")
	private List<OrderDetailEntity> orderDetails = new ArrayList<OrderDetailEntity>();
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Order_Status_Id")
    private OrderStatusEntity orderStatus;

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getShipAddess() {
		return shipAddess;
	}

	public void setShipAddess(String shipAddess) {
		this.shipAddess = shipAddess;
	}

	public String getShipMailAddess() {
		return shipMailAddess;
	}

	public void setShipMailAddess(String shipMailAddess) {
		this.shipMailAddess = shipMailAddess;
	}

	public String getShipPhoneNumber() {
		return ShipPhoneNumber;
	}

	public void setShipPhoneNumber(String shipPhoneNumber) {
		ShipPhoneNumber = shipPhoneNumber;
	}

	public List<OrderDetailEntity> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetailEntity> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public OrderStatusEntity getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatusEntity orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	
}
