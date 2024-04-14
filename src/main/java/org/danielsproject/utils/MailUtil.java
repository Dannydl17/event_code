package org.danielsproject.utils;

import jakarta.mail.*;
import jakarta.mail.internet.*;
import org.danielsproject.services.notification.PasswordAuthenticator;

import java.util.Properties;

public class MailUtil {

    public static Properties getMailSessionProperties(){
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        return properties;
    }

    public static Session getMailSession(){
        return Session.getDefaultInstance(getMailSessionProperties(), new PasswordAuthenticator());
    }

    public static String send(String email, String htmlContent, String subject) {
        try {
            Address[] addresses = new InternetAddress[]{new InternetAddress(email)};

            Transport.send(composeMessage(subject, htmlContent), addresses);
            return "Message Successfully Sent To %s".formatted(email);
        } catch (MessagingException exception) {
            return "An Error Occurred While Sending Mail To %s (%s)".formatted(email, exception.getMessage());
        }
    }

    private static BodyPart messageBody(String htmlContent) throws MessagingException {
        BodyPart messageBody = new MimeBodyPart();
        messageBody.setContent(htmlContent, "text/html");
        return messageBody;
    }

    private static Multipart mailMultipart(String htmlContext) throws MessagingException {
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBody(htmlContext));
        return multipart;
    }

    public static Message composeMessage(String mailSubject, String htmlContext) throws MessagingException {
        Message message = new MimeMessage(getMailSession());
        message.setContent(mailMultipart(htmlContext));
        message.setSubject(mailSubject);
        return message;
    }
}
