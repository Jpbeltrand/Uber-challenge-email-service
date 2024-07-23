package com.beltrand.email_service.adapter;

public interface SendEmailGateway {
    //Contrato para interagir com o serviços de fora(API)
    void sendEmail(String to, String subject,String body);
}
