package com.laptrinhjavaweb.controller.admin;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.dao.ICategoryDAO;
import com.laptrinhjavaweb.dto.MyUser;
import com.laptrinhjavaweb.entity.RoleEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.security.PassowrdEncoder;
import com.laptrinhjavaweb.service.IRoleService;
import com.laptrinhjavaweb.service.IUserService;
import com.laptrinhjavaweb.service.impl.RoleService;
import com.laptrinhjavaweb.service.impl.UserService;

@Controller(value = "userControllerOfAdmin")
@RequestMapping("/quan-tri/")
public class UserController {
	
	@Autowired
	IUserService userService;
	
	@Autowired
	IRoleService roleService;
	
	@Autowired
	PassowrdEncoder passwordEncoder;
	
	@RequestMapping(value = "nguoi-dung", method = RequestMethod.GET)
	public ModelAndView pageListCategory(HttpServletRequest request) {
		return userService.findAllUser(request);
	}
	
	@RequestMapping(value = "nguoi-dung/tao-moi", method = RequestMethod.GET)
	public ModelAndView pageListProduct() {
		ModelAndView mav = new ModelAndView("admin/user/create");
		return mav;
	}
	
	@RequestMapping(value = "nguoi-dung/tao-moi", method = RequestMethod.POST)
	public ModelAndView createUser(@ModelAttribute("user") UserEntity user) {
		return userService.createUser(user);
	}
	
	@RequestMapping(value = "nguoi-dung/chinh-sua-thong-tin-ca-nhan", method = RequestMethod.GET)
	public ModelAndView getEditInfoPage(@RequestParam("id") String id, Authentication authentication) {
		MyUser myUser = (MyUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(!myUser.getId().equals(id))
			return new ModelAndView("redirect:/quan-tri/nguoi-dung");
		return userService.getEditInfoPage(id);
	}
	
	@RequestMapping(value = "nguoi-dung/chinh-sua-thong-tin-ca-nhan", method = RequestMethod.POST)
	public ModelAndView editUserInfo(@ModelAttribute("user") UserEntity user) {
		String s = user.getId();
		s = s.substring(s.lastIndexOf(',')+1);
		MyUser myUser = (MyUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(!myUser.getId().equals(s))
			return new ModelAndView("redirect:/quan-tri/nguoi-dung");
		return userService.editInfoUser(user);
	}
	
	@RequestMapping(value = "nguoi-dung/chinh-sua", method = RequestMethod.GET)
	public ModelAndView getEditPage(@RequestParam("id") String id, Authentication authentication) {
		return userService.getEditPage(id);
	}
	
	@RequestMapping(value = "nguoi-dung/chinh-sua", method = RequestMethod.POST)
	public ModelAndView editUser(@ModelAttribute("user") UserEntity user) {
		return userService.editUser(user);
	}
	
	@RequestMapping(value = "nguoi-dung/xoa", method = RequestMethod.GET)
	public ModelAndView getDeletePage(@RequestParam("id") String id, Authentication authentication) {
		return userService.geDeletePage(id);
	}
	
	@RequestMapping(value = "nguoi-dung/xoa", method = RequestMethod.POST)
	public ModelAndView deleteUser(@ModelAttribute("user") UserEntity user) {
		return userService.deleteUser(user);
	}
	
	@RequestMapping(value = "nguoi-dung/quan-tri", method = RequestMethod.GET)
	public ModelAndView pageListSlide(HttpServletRequest request) {
		return userService.findAllAdminUser(request);
	}
	
	@Autowired
	ICategoryDAO catagoryDao;
	
	@RequestMapping(value = "test", method = RequestMethod.GET)
	public ModelAndView test() {
		catagoryDao.findOneByCode("");
		return new ModelAndView("login");
	}
}
