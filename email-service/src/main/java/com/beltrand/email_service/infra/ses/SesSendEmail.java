package com.beltrand.email_service.infra.ses;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;
import com.beltrand.email_service.adapter.SendEmailGateway;
import com.beltrand.email_service.core.exception.EmailServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SesSendEmail implements SendEmailGateway {

    private final AmazonSimpleEmailService amazonSimpleEmailService;

    @Autowired
    public SesSendEmail(AmazonSimpleEmailService amazonSimpleEmailService){
        this.amazonSimpleEmailService = amazonSimpleEmailService;
    }

    @Override
    public void sendEmail(String to, String subject, String body) {
        SendEmailRequest request = new SendEmailRequest()//request enviada a AWS
                .withSource("jpbeltrand23@gmail.com")//Quem envia(origem)
                .withDestination(new Destination().withToAddresses(to))//destino
                .withMessage(new Message() //mensagem do email
                        .withSubject(new Content(subject))//assunto da mensagem
                        .withBody(new Body().withText(new Content(body)))//corpo da mensagem
                );
        try{
            this.amazonSimpleEmailService.sendEmail(request);
        }catch(AmazonServiceException exception){
           throw new EmailServiceException("Falha ao enviar email",exception);
        }
    }
}
