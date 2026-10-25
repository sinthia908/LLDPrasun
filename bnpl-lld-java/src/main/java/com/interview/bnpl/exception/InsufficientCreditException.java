package com.interview.bnpl.exception;
public class InsufficientCreditException extends RuntimeException {
    public InsufficientCreditException(String message) { super(message); }
}
