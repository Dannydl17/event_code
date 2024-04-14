package org.danielsproject.services.notification;

import jakarta.mail.Authenticator;
import jakarta.mail.PasswordAuthentication;


import static org.danielsproject.utils.Constants.*;

public class PasswordAuthenticator extends Authenticator {

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(System.getenv(AUTHENTICATOR_USERNAME), System.getenv(AUTHENTICATOR_PASSWORD));
    }
}
////        return new PasswordAuthentication(System.getenv("alaabdulmalik03@gmail.com"), System.getenv("akncjypshgzmqkms"));
