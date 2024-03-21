package com.cursomc.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.cursomc.cursomc.domain.Pedido;

public interface EmailService {
    
    void sendOrderConfirmationEmail(Pedido obj);

    void sendEmail(SimpleMailMessage msg);
}
