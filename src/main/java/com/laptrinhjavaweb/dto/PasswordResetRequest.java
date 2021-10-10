package com.laptrinhjavaweb.dto;

public class PasswordResetRequest {
    
    public String email;

    public PasswordResetRequest() {
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PasswordResetRequest(String email) {
        this.email = email;
    }

}
