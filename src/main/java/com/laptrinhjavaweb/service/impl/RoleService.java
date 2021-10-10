package com.laptrinhjavaweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.dao.IRoleDAO;
import com.laptrinhjavaweb.dao.IUserDAO;
import com.laptrinhjavaweb.entity.RoleEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.service.IRoleService;
import com.laptrinhjavaweb.service.IUserService;

@Service
@Transactional
public class RoleService extends AbstractGenericService<IRoleDAO, RoleEntity> implements IRoleService{
	@Autowired
	public void setDao(IRoleDAO daoToSet) {
		dao = daoToSet;
		dao.setClazz(RoleEntity.class);
	}

	@Override
	public RoleEntity findByCode(String code) {
		return dao.findByCode(code);
		
	}	
}
