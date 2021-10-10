package com.laptrinhjavaweb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ProductItem")
public class ProductItemEntity extends BaseEntity{
	
	
	public OrderDetailEntity getOrderDetailEntity() {
		return orderDetailEntity;
	}

	public void setOrderDetailEntity(OrderDetailEntity orderDetailEntity) {
		this.orderDetailEntity = orderDetailEntity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(Double originalPrice) {
		this.originalPrice = originalPrice;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

	public List<ProductImageEntity> getProductImages() {
		return productImages;
	}

	public void setProductImages(List<ProductImageEntity> productImages) {
		this.productImages = productImages;
	}

	@Column(name = "Name")
	private String name;
	
	@Column(name = "Detail", columnDefinition="TEXT")
	private String detail;
	
	@Column(name = "Price")
	private Double price;
	
	@Column(name = "OriginalPrice")
	private Double originalPrice;
	
	@Column(name = "Stock")
	private Integer stock;
	
	@Column(name = "Status")
	private Integer status;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Product_Id")
    private ProductEntity product;
	
	@OneToOne(mappedBy = "productItemEntity")
	private OrderDetailEntity orderDetailEntity;
	
	@OneToMany(mappedBy = "productItem")
	private List<ProductImageEntity> productImages = new ArrayList<ProductImageEntity>();
}
