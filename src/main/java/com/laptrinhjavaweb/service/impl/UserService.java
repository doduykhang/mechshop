package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.RollbackException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.dao.ICategoryDAO;
import com.laptrinhjavaweb.dao.IRoleDAO;
import com.laptrinhjavaweb.dao.IUserDAO;
import com.laptrinhjavaweb.dao.impl.UserDAO;
import com.laptrinhjavaweb.entity.RoleEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.security.PassowrdEncoder;
import com.laptrinhjavaweb.service.IRoleService;
import com.laptrinhjavaweb.service.IUserService;

@Service
@Transactional
public class UserService extends AbstractGenericService<IUserDAO, UserEntity> implements IUserService{
	
	@Autowired
	IUserService userService;
	
	@Autowired
	IRoleDAO roleDAO;
	
	@Autowired
	PassowrdEncoder passwordEncoder;
	
	
	
	@Autowired
	public void setDao(IUserDAO daoToSet) {
		dao = daoToSet;
		dao.setClazz(UserEntity.class);
	}

	@Override
	public ModelAndView findAllUser(HttpServletRequest request) {
		List<UserEntity> userList = dao.findAll();
		PagedListHolder pagedListHolder = new PagedListHolder<>(userList);
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setMaxLinkedPages(5);
		pagedListHolder.setPageSize(5);
		ModelAndView mav = new ModelAndView("admin/user/index");
		mav.addObject("pagedListHolder",pagedListHolder);
		return mav;
	}

	@Override
	@Transactional
	public ModelAndView editInfoUser(UserEntity user) {
		
		
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    	Validator validator = factory.getValidator();
    	Set<ConstraintViolation<UserEntity>> violation = validator.validate(user);
    	if(violation.size() > 0) {
    		ModelAndView mav = new ModelAndView("admin/user/editPersonalInfo");
    		mav.addObject("user", user);
    		mav.addObject("errorMessage", violation);
    		return mav;
    	}
    	String s = user.getId();
		user.setId(s.substring(s.lastIndexOf(',')+1));
		UserEntity updatedUser = dao.findOne(user.getId());
		updatedUser.setFullName(user.getFullName());
		updatedUser.setUserName(user.getUserName());
		if(!updatedUser.getPassword().equals(user.getPassword()))
			updatedUser.setPassword(passwordEncoder.bCryptPasswordEncoder().encode(user.getPassword()));
		updatedUser.setEmail(user.getEmail());
		try {
			dao.update(updatedUser);
			
			
			return new ModelAndView("admin/user/editPersonalInfo").addObject("user", user).
														addObject("message", "Sửa thành công");
		}
		catch(Exception ex)
		{
			return new ModelAndView("admin/user/editPersonalInfo").addObject("user", user)
														.addObject("message", "Sửa không thành công");
		}
		
	}
	
	@Override
	@Transactional
	public ModelAndView getEditInfoPage(String id) {
		UserEntity user = dao.findOne(id);
		if(user != null)
			return new ModelAndView("admin/user/editPersonalInfo").addObject("user", user);
		else 
			return new ModelAndView("redirect:/quan-tri/nguoi-dung").addObject("message", "Người dùng không tồn tại");
	}

	@Override
	@Transactional
	public ModelAndView editUser(UserEntity user) {
		String s = user.getId();
		user.setId(s.substring(s.lastIndexOf(',')+1));
		
		UserEntity updatedUser = dao.findOne(user.getId());
		updatedUser.setStatus(user.getStatus());
		try {
			dao.update(updatedUser);
			
			return new ModelAndView("admin/user/edit").addObject("user", user).
														addObject("message", "Sửa thành công");
		}
		catch(Exception ex)
		{
			return new ModelAndView("admin/user/edit").addObject("user", user)
														.addObject("message", "Sửa không thành công");
		}
	}

	@Override
	public ModelAndView getEditPage(String id) {
		UserEntity user = dao.findOne(id);
		if(user != null)
			return new ModelAndView("admin/user/edit").addObject("user", user);
		else 
			return new ModelAndView("redirect:/quan-tri/nguoi-dung").addObject("message", "Người dùng không tồn tại");
	}

	@Override
	public ModelAndView geDeletePage(String id) {
		UserEntity user = dao.findOne(id);
		if(user != null)
			return new ModelAndView("admin/user/delete").addObject("user", user);
		else 
			return new ModelAndView("redirect:/quan-tri/nguoi-dung").addObject("message", "Người dùng không tồn tại");
	}

	@Override
	@Transactional
	public ModelAndView deleteUser(UserEntity user) {
		String s = user.getId();
		user.setId(s.substring(s.lastIndexOf(',')+1));
		try {
			dao.delete(user);
			return new ModelAndView("redirect:/quan-tri/nguoi-dung").addObject("user", user).
														addObject("message", "Xóa thành công");
		}
		catch(Exception ex)
		{
			return new ModelAndView("admin/user/delete").addObject("user", user)
														.addObject("message", "Xóa không thành công");
		}
	}

	@Override
	public ModelAndView findAllAdminUser(HttpServletRequest request) {
		List<UserEntity> userList = dao.findAllAdminUser();
		PagedListHolder pagedListHolder = new PagedListHolder<>(userList);
		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setMaxLinkedPages(5);
		pagedListHolder.setPageSize(5);
		ModelAndView mav = new ModelAndView("admin/user/user-admin");
		mav.addObject("pagedListHolder",pagedListHolder);
		return mav;
	}

	@Override
	@Transactional
	public ModelAndView createUser(UserEntity user) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    	Validator validator = factory.getValidator();
    	Set<ConstraintViolation<UserEntity>> violation = validator.validate(user);
    	if(violation.size() > 0) {
    		ModelAndView mav = new ModelAndView("admin/user/create");
    		mav.addObject("user", user);
    		mav.addObject("errorMessage", violation);
    		return mav;
    	}
        	
		try {
			ModelAndView mav = new ModelAndView("admin/user/user-admin");
			//set enable
			user.setStatus(1);
			//add role
			List<RoleEntity> roles = new ArrayList<>();
			RoleEntity role = roleDAO.findByCode("ADMIN");
			roles.add(role);
			//endcode password
			String encodedPassword = passwordEncoder.bCryptPasswordEncoder().encode(user.getPassword());
			user.setPassword(encodedPassword);
			user.setRoles(roles);
			//save
			userService.save(user);
			return new ModelAndView("redirect:/quan-tri/nguoi-dung").addObject("message", "Thêm thành công");
		}
		catch(Exception ex)
		{
			ModelAndView mav = new ModelAndView("redirect:/quan-tri/nguoi-dung/tao-moi").addObject("message", "Thêm không thành công");
			return mav;
		}
	}
	
	
	
}
