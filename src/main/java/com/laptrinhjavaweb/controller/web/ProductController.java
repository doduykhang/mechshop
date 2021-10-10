package com.laptrinhjavaweb.controller.web;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.entity.ProductEntity;
import com.laptrinhjavaweb.entity.ProductItemEntity;
import com.laptrinhjavaweb.service.ICategoryService;
import com.laptrinhjavaweb.service.IProductService;
import com.laptrinhjavaweb.service.ISlideService;

@Controller(value = "productControllerOfWeb")
public class ProductController {
	@Autowired
	ICategoryService category;
	
	@Autowired
	IProductService product;
	
	@Autowired
	ISlideService slide;
	
	@Autowired
	ServletContext context;
	
	@RequestMapping(value = "/san-pham/chi-tiet", method = RequestMethod.GET)
	public ModelAndView productDetail(@RequestParam(value = "id", required=true)String id) {
		ModelAndView mav = new ModelAndView("web/product/ProductDetail");
		List<ProductItemEntity> entities = product.findById(id).getProductItems();
		mav.addObject("entities", entities);
		return mav;
	}
	
	@RequestMapping(value = "/danh-sach/san-pham", method = RequestMethod.GET)
	public ModelAndView listProduct() {
		ModelAndView mav = new ModelAndView("web/product/Index");
		List<ProductEntity> list = product.findAll();
		
		mav.addObject("product", list);
		return mav;
	}
}	
