package com.laptrinhjavaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhjavaweb.entity.UserEntity;

public interface UserRepository {
	UserEntity findOneByUserNameAndStatus(String name, int status);
}
