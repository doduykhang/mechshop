package com.laptrinhjavaweb.controller.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.entity.ProductEntity;
import com.laptrinhjavaweb.service.IProductService;

@Controller(value = "homeControllerOfWeb")
public class HomeController {
	@Autowired
	IProductService product;
	
	@RequestMapping(value = "/dang-nhap", method = RequestMethod.GET)
	public ModelAndView loginPage() {
		ModelAndView mav = new ModelAndView("login");
		
		return mav;
	}
	
	@RequestMapping(value = "/nguoi-dung", method = RequestMethod.GET)
	public ModelAndView userDetailPage() {
		ModelAndView mav = new ModelAndView("web/User");
		
		return mav;
	}
	
	@RequestMapping(value = "/nguoi-dung/ban-hang", method = RequestMethod.GET)
	public ModelAndView userSalePage() {
		ModelAndView mav = new ModelAndView("web/CreateProduct");
		
		return mav;
	}
	
	@RequestMapping(value = "/nguoi-dung/danh-sach/san-pham", method = RequestMethod.GET)
	public ModelAndView listUserProduct() {
		ModelAndView mav = new ModelAndView("web/ListProductOfUser");
		
		return mav;
	}
	
	@RequestMapping(value = "/danh-sach/san-pham/chi-tiet", method = RequestMethod.GET)
	public ModelAndView listUserProductDetail() {
		ModelAndView mav = new ModelAndView("web/UserProductDetail");
		
		return mav;
	}
	
	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("web/home/Index");
		List<ProductEntity> list = product.findAll();
		
		mav.addObject("product", list);
		return mav;
	}
	
	
	@RequestMapping(value = "/thoat", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return new ModelAndView("redirect:/trang-chu");
	}
	
	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public ModelAndView accessDenied() {
		return new ModelAndView("redirect:/dang-nhap?accessDenied");
	}
}
