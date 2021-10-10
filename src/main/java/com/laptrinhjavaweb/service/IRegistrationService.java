package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.RegistrationRequest;

public interface IRegistrationService {
    public String resgister(RegistrationRequest request);
    public String activateUser(String jwt);
}