package com.laptrinhjavaweb.dao;

import java.util.List;

import com.laptrinhjavaweb.entity.UserEntity;

public interface IUserDAO extends IGenericDAO<UserEntity>{
	public UserEntity findOneByUserNameAndStatus(String name, int status);
	public List<UserEntity> findAllAdminUser();
	public UserEntity findByEmail(String email);
	public UserEntity findByValidationToken(String validationToken);
}
