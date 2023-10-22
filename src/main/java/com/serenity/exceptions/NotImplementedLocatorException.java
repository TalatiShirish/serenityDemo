package com.serenity.exceptions;

public class NotImplementedLocatorException extends Exception{
    public NotImplementedLocatorException(String message) {

        super(message);
        printStackTrace();
    }
}
