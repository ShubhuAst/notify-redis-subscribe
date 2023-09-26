package com.smtp.notify.service;

public interface EmailService {

    public void sendSimpleEmail(String toEmail, String body, String subject);

}
