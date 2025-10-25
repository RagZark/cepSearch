package com.cepvalidation.exception;

public class ConversionErrorException extends RuntimeException {
    private final String message;

    public ConversionErrorException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage(){ return this.message; }
}
