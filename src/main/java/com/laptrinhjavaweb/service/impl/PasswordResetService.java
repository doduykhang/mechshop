package com.laptrinhjavaweb.service.impl;


import java.util.NoSuchElementException;
import java.util.Set;
import java.util.UUID;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.dao.IUserDAO;
import com.laptrinhjavaweb.dao.impl.UserDAO;
import com.laptrinhjavaweb.dto.NewPasswordRequest;
import com.laptrinhjavaweb.dto.PasswordResetRequest;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.exception.InvalidTokenException;
import com.laptrinhjavaweb.security.JwtUtil;
import com.laptrinhjavaweb.service.IEmailSender;
import com.laptrinhjavaweb.service.IPasswordResetService;

@Service("PasswordResetServiceImpl")
public class PasswordResetService implements IPasswordResetService{

    @Autowired
    IUserDAO userDAO;

    @Autowired
    IEmailSender emailSender;
    
    @Autowired
    JwtUtil jwtUtil;
    
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public String passwordReset(PasswordResetRequest passwordResetRequest) {
        UserEntity user = userDAO.findByEmail(passwordResetRequest.getEmail());
        if(user == null) 
        	throw new RuntimeException("Invalid email");
        
        user.setValidationToken(UUID.randomUUID().toString());
        userDAO.update(user);
        emailSender.send(
            user.getEmail(), 
            "reset your password",
            "http://localhost:8080/mechshop/mat-khau-moi?token="+jwtUtil.generateToken(user)
        );
        return "email has been sent";
    }

    @Override
    @Transactional
    public String newPassword(NewPasswordRequest newPasswordRequest) {
        String validationToken = jwtUtil.extractValidationToken(newPasswordRequest.getValidationToken());
        UserEntity user = userDAO.findByValidationToken(validationToken);
        if(user == null)
        	throw new InvalidTokenException("Invalid token");
        if(jwtUtil.validateToken(newPasswordRequest.getValidationToken(), user)){
        	user.setPassword(newPasswordRequest.getPassword());
        	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        	Validator validator = factory.getValidator();
        	Set<ConstraintViolation<UserEntity>> violation = validator.validate(user);
        	if(violation.size() > 0) 
            	throw new ConstraintViolationException(violation);
            user.setPassword(passwordEncoder.encode(newPasswordRequest.getPassword()));
            userDAO.update(user);
        }
        else
             throw new InvalidTokenException("invalid token");
        return "password reseted";       
    }
    
    public boolean validateToken(String jwt) {
    	String validationToken = jwtUtil.extractValidationToken(jwt);
        UserEntity user = userDAO.findByValidationToken(validationToken);
        if(user != null && jwtUtil.validateToken(jwt, user))
        	return true;
        
        return false;
    }
}
