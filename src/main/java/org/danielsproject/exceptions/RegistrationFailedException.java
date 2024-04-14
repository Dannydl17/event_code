package org.danielsproject.exceptions;

public class RegistrationFailedException extends Exception {


    public RegistrationFailedException(String message, Throwable cause){
        super(message, cause);
    }

    public RegistrationFailedException(String message){
        super(message);
    }
}
