package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.NewPasswordRequest;
import com.laptrinhjavaweb.dto.PasswordResetRequest;

public interface IPasswordResetService {
    public String passwordReset(PasswordResetRequest passwordResetRequest);
    public String newPassword(NewPasswordRequest passwordRequest);
    public boolean validateToken(String jwt);
}
