package com.laptrinhjavaweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "ProductImage")
public class ProductImageEntity extends BaseEntity {
	
	@Column(name = "Name")
	private String name;

	@Column(name = "ImagePath")
	private String imagePath;
	
	@Column(name = "ImageSize")
	private Long imageSize;
	
	@Column(name = "Caption")
	private String caption;
	
	@Column(name = "IsDefault")
	private Integer isDefault;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Product_Item_Id")
    private ProductItemEntity productItem;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Long getImageSize() {
		return imageSize;
	}

	public void setImageSize(Long imageSize) {
		this.imageSize = imageSize;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public Integer getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}

	public ProductItemEntity getProductItem() {
		return productItem;
	}

	public void setProductItem(ProductItemEntity productItem) {
		this.productItem = productItem;
	}
}
