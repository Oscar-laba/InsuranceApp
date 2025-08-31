package com.insurance.exceptions;

public class ContractNotFinishedException extends RuntimeException{
    public ContractNotFinishedException(String message) {
        super(message);
    }
}
