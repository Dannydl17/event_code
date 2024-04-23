package org.danielsproject.exceptions;

public class EventCreationFailedException  extends Exception{
    public EventCreationFailedException(String message, Throwable cause){
        super(message, cause);
    }
}
