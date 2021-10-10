package com.laptrinhjavaweb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ProductStatus")
public class ProductStatusEntity extends BaseEntity {
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "ProductStatusCode")
	private String productStatusCode;
	
	@OneToMany(mappedBy = "productStatus")
    private List<ProductEntity> products = new ArrayList<ProductEntity>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProductStatusCode() {
		return productStatusCode;
	}

	public void setProductStatusCode(String productStatusCode) {
		this.productStatusCode = productStatusCode;
	}

	public List<ProductEntity> getProducts() {
		return products;
	}

	public void setProducts(List<ProductEntity> products) {
		this.products = products;
	}
	
	
}
