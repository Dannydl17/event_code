package org.danielsproject.exceptions;

public class DuplicateModelException extends Exception {

    public DuplicateModelException(String message, Throwable throwable){
        super(message, throwable);
    }

    public DuplicateModelException(String message){
        super(message);
    }
}
