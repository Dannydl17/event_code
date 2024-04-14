package org.danielsproject.services.notification;

import org.danielsproject.dtos.response.NotificationResponse;

public interface MailService {

    NotificationResponse sendRegistrationSuccessfulMail(String email, String mailPath, String subject);
}
