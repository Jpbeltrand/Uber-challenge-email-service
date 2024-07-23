package com.beltrand.email_service.controllers;

import com.beltrand.email_service.application.SendEmailService;
import com.beltrand.email_service.core.EmailRequest;
import com.beltrand.email_service.core.exception.EmailServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
public class SendEmailController {
    private final SendEmailService sendEmailService;

    @Autowired
    public SendEmailController(SendEmailService sendEmailService){
        this.sendEmailService = sendEmailService;
    }

    @PostMapping
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest request){
        try{
            this.sendEmailService.sendEmail(request.to(), request.subject(), request.body());
            return ResponseEntity.ok("email enviado com sucesso");
        }catch(EmailServiceException exception){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("erro ao enviar email");
        }
    }
}
