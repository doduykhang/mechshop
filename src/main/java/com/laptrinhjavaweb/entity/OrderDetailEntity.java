package com.laptrinhjavaweb.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "OrderDetail")
public class OrderDetailEntity extends BaseEntity {

	@Column(name = "Quantity")
	private Integer quantity;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "productItem_id", referencedColumnName = "id")
	private ProductItemEntity productItemEntity;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Order_Id")
    private OrderEntity order;

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public ProductItemEntity getProductItemEntity() {
		return productItemEntity;
	}

	public void setProductItemEntity(ProductItemEntity productItemEntity) {
		this.productItemEntity = productItemEntity;
	}

	public OrderEntity getOrder() {
		return order;
	}

	public void setOrder(OrderEntity order) {
		this.order = order;
	}
	
	
}
