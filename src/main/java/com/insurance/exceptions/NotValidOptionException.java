package com.insurance.exceptions;

public class NotValidOptionException extends RuntimeException{
    public NotValidOptionException(String message){
        super(message);
    }
}
