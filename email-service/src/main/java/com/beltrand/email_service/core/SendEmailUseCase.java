package com.beltrand.email_service.core;

public interface SendEmailUseCase {
    //Regra de negocio que define o comportanmento da aplicação(Alto Nivel)
    //
    void sendEmail(String to,String subject,String body);
}
