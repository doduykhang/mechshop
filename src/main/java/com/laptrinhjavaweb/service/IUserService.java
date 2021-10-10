package com.laptrinhjavaweb.service;

import java.util.List;

import javax.persistence.RollbackException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.entity.UserEntity;

public interface IUserService extends IGenericService<UserEntity>{
	//public List<UserEntity> findAllAdminUser();
	public ModelAndView findAllAdminUser(HttpServletRequest request);
	public ModelAndView findAllUser(HttpServletRequest request);
	public ModelAndView createUser(UserEntity user);
	public ModelAndView editUser(UserEntity user);
	public ModelAndView getEditPage(String id);
	public ModelAndView getEditInfoPage(String id);
	public ModelAndView editInfoUser(UserEntity user);
	public ModelAndView geDeletePage(String id);
	public ModelAndView deleteUser(UserEntity user);
}
