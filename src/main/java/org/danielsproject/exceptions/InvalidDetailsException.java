package org.danielsproject.exceptions;

public class InvalidDetailsException extends RuntimeException{
    public InvalidDetailsException(){
        super("invalid username or password");
    }
}
