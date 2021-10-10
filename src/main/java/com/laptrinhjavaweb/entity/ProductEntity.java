package com.laptrinhjavaweb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class ProductEntity extends BaseEntity {

	@Column(name = "Name")
	private String name;

	@Column(name = "Description", columnDefinition = "TEXT")
	private String description;

	@Column(name = "ViewCount")
	private Long viewCount;

	@Column(name = "IsFeatured")
	private Integer isFeatured;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Product_Status_Id")
	private ProductStatusEntity productStatus;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "Product_In_Category", joinColumns = @JoinColumn(name = "productId"), inverseJoinColumns = @JoinColumn(name = "categoryId"))
	private List<CategoryEntity> categories = new ArrayList<CategoryEntity>();

	@OneToMany(mappedBy = "product")
	private List<ProductItemEntity> productItems = new ArrayList<ProductItemEntity>();

	@OneToMany(mappedBy = "product")
	private List<SlideEntity> slides = new ArrayList<SlideEntity>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getViewCount() {
		return viewCount;
	}

	public void setViewCount(Long viewCount) {
		this.viewCount = viewCount;
	}


	public Integer getIsFeatured() {
		return isFeatured;
	}

	public void setIsFeatured(Integer isFeatured) {
		this.isFeatured = isFeatured;
	}

	public ProductStatusEntity getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(ProductStatusEntity productStatus) {
		this.productStatus = productStatus;
	}

	public List<CategoryEntity> getCategories() {
		return categories;
	}

	public void setCategories(List<CategoryEntity> categories) {
		this.categories = categories;
	}

	public List<ProductItemEntity> getProductItems() {
		return productItems;
	}

	public void setProductItems(List<ProductItemEntity> productItems) {
		this.productItems = productItems;
	}

	public List<SlideEntity> getSlides() {
		return slides;
	}

	public void setSlides(List<SlideEntity> slides) {
		this.slides = slides;
	}

}
