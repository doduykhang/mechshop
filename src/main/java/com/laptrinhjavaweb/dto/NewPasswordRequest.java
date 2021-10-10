package com.laptrinhjavaweb.dto;


public class NewPasswordRequest {
    private String password;
    private String validationToken;

    public NewPasswordRequest() {
    }

    public NewPasswordRequest(String password, String validationToken) {
        this.password = password;
        this.validationToken = validationToken;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getValidationToken() {
        return this.validationToken;
    }

    public void setValidationToken(String validationToken) {
        this.validationToken = validationToken;
    }

}
