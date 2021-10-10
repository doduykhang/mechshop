package com.laptrinhjavaweb.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.dao.IUserDAO;
import com.laptrinhjavaweb.entity.RoleEntity;
import com.laptrinhjavaweb.entity.UserEntity;

@Repository(value = "userDAO")
@Transactional(rollbackFor = Exception.class)
public class UserDAO extends AbtrasctGenericDAO<UserEntity> implements IUserDAO{
	public UserEntity findOneByUserNameAndStatus(String name, int status) {
		return (UserEntity) getCurrentSession()
		.createQuery("from UserEntity where userName = :name and status = :status")
		.setParameter("name", name)
		.setParameter("status", status)
		.uniqueResult();
	}

	@Override
	public List<UserEntity> findAllAdminUser() {
		return (List<UserEntity>) getCurrentSession()
				.createQuery("select distinct u from UserEntity u left join u.roles r where r.id = :id")
				.setParameter("id", "1")
				.list();
	}

	public UserEntity findByEmail(String email) {
		return (UserEntity) getCurrentSession()
				.createQuery("from UserEntity where email = :email")
				.setParameter("email", email)
				.uniqueResult();
	}

	@Override
	public UserEntity findByValidationToken(String validationToken) {
		return (UserEntity) getCurrentSession()
				.createQuery("from UserEntity where validationToken = :token")
				.setParameter("token", validationToken)
				.uniqueResult();
	}
}
