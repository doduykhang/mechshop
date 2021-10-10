package com.laptrinhjavaweb.dao;

import com.laptrinhjavaweb.entity.RoleEntity;

public interface IRoleDAO extends IGenericDAO<RoleEntity>{
	public RoleEntity findByCode(String code);
}
