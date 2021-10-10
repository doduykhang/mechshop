package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.entity.RoleEntity;

public interface IRoleService extends IGenericService<RoleEntity>{
	public RoleEntity findByCode(String code);
}
