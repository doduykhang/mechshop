package com.laptrinhjavaweb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.dao.IRoleDAO;
import com.laptrinhjavaweb.entity.RoleEntity;
import com.laptrinhjavaweb.entity.UserEntity;

@Repository(value = "roleDAO")
@Transactional(rollbackFor = Exception.class)
public class RoleDAO extends AbtrasctGenericDAO<RoleEntity> implements IRoleDAO{

	@Override
	public RoleEntity findByCode(String code) {
		return (RoleEntity) getCurrentSession()
				.createQuery("from RoleEntity r where r.code = :code")
				.setParameter("code", code)
				.uniqueResult();
	}

}
