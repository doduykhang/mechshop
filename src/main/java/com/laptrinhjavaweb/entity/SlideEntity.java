package com.laptrinhjavaweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Slide")
public class SlideEntity extends BaseEntity{
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Product_Id")
    private ProductEntity product;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Caption")
	private String caption;
	
	@Column(name = "ImagePath")
	private String imagePath;
	
	@Column(name = "ImageSize")
	private Double imageSize;
	
	@Column(name = "Status")
	private Integer status;

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Double getImageSize() {
		return imageSize;
	}

	public void setImageSize(Double imageSize) {
		this.imageSize = imageSize;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
}
