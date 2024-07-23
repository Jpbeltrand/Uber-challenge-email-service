package com.beltrand.email_service.core.exception;

public class EmailServiceException extends RuntimeException{

    //super chama o consrutor da classe RuntimeException
    public EmailServiceException(String message){
        super(message);
    }

    public EmailServiceException(String message, Throwable cause){
        super(message, cause);
    }
}
