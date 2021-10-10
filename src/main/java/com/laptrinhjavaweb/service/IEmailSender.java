package com.laptrinhjavaweb.service;

public interface IEmailSender {
    public void send(String to, String subject, String email);
}
