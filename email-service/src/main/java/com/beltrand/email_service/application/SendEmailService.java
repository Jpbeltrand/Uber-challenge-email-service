package com.beltrand.email_service.application;

import com.beltrand.email_service.adapter.SendEmailGateway;
import com.beltrand.email_service.core.SendEmailUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SendEmailService implements SendEmailUseCase {
    //porta de entrada, injeta a interface adapater,para a aplicação nao depender da Api.
    //intancia a AWS,pois o SES(API) implementa o gateaway
    private final SendEmailGateway sendEmailGateway;

    @Autowired
    public SendEmailService(SendEmailGateway sendEmailGateway){
        this.sendEmailGateway = sendEmailGateway;
    }
    @Override
    public void sendEmail(String to, String subject, String body) {
        this.sendEmailGateway.sendEmail(to,subject,body);
    }
}
