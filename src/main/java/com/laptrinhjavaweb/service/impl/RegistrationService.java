package com.laptrinhjavaweb.service.impl;



import com.laptrinhjavaweb.dao.IRoleDAO;
import com.laptrinhjavaweb.dao.IUserDAO;
import com.laptrinhjavaweb.dao.impl.UserDAO;
import com.laptrinhjavaweb.dto.RegistrationRequest;
import com.laptrinhjavaweb.entity.RoleEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.exception.InvalidTokenException;
import com.laptrinhjavaweb.security.JwtUtil;
import com.laptrinhjavaweb.security.PassowrdEncoder;
import com.laptrinhjavaweb.service.IEmailSender;
import com.laptrinhjavaweb.service.IRegistrationService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("RegistrationServiceImpl")
public class RegistrationService implements IRegistrationService{

    @Autowired
    IUserDAO userDAO;

    @Autowired
    IRoleDAO roleDAO;
    
    @Autowired
    JwtUtil validationJwtUtil;

    @Autowired
    PassowrdEncoder passowrdEncoder;

    @Autowired
    IEmailSender emailSender;

    @Override
    @Transactional
    public String resgister(RegistrationRequest registrationRequest) {
        
        if(userDAO.findByEmail(registrationRequest.getEmail()) != null) {
        	throw new RuntimeException("can not use this email");
        }

        UserEntity user = registrationRequestToUser(registrationRequest);
        
        //validate
    	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    	Validator validator = factory.getValidator();
    	Set<ConstraintViolation<UserEntity>> violation = validator.validate(user);
    	if(violation.size() > 0) 
        	throw new ConstraintViolationException(violation);
    	
    	List<RoleEntity> roles = new ArrayList<>();
		RoleEntity role = roleDAO.findByCode("USER");
		roles.add(role);
        
        user.setPassword(passowrdEncoder.bCryptPasswordEncoder().encode(user.getPassword()));
        user.setStatus(0);
        user.setRoles(roles);
    	
    	userDAO.create(user);
    	emailSender.send(user.getEmail(),"activate your account", "http://localhost:8080/mechshop/kich-hoat?token="+validationJwtUtil.generateToken(user));
        return "email has been sent";        
    }

    @Override
    @Transactional
    public String activateUser(String jwt) {
        String validationToken = validationJwtUtil.extractValidationToken(jwt);
        UserEntity user = userDAO.findByValidationToken(validationToken);
                                            
        if(user == null) {
        	throw new InvalidTokenException("invalid token");
        }
        
        if(validationJwtUtil.validateToken(jwt, user)){
        	user.setStatus(1);
        	userDAO.update(user);
        }
        else {
        	throw new InvalidTokenException("invalid token");
        }
        return "account is activated";
    }
    
    private UserEntity registrationRequestToUser(RegistrationRequest request) {
    	UserEntity user = new UserEntity();
    	user.setFullName(request.getFullName());
    	user.setUserName(request.getUserName());
    	user.setPassword(request.getPassword());
    	user.setEmail(request.getEmail());
    	user.setValidationToken(UUID.randomUUID().toString());
    	return user;
    }

}
