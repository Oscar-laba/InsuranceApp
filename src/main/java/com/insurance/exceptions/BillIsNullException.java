package com.insurance.exceptions;

public class BillIsNullException extends RuntimeException{
    public BillIsNullException(String message) {
        super(message);
    }
}
