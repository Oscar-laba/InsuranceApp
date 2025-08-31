package com.insurance.exceptions;

public class PersonNotAccepetedException extends RuntimeException{
    public PersonNotAccepetedException(String message) {
        super(message);
    }
}
