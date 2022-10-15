package com.familiasantanalopes.comerciovirtual.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender javaMailSender;
    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Value("${spring.mail.username}")
    private String remetente;

    public String enviarEmailTexto(String destinatario, String titulo, String mansagem){

        try {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(remetente);
        simpleMailMessage.setTo(destinatario);
        simpleMailMessage.setSubject(titulo);
        simpleMailMessage.setTo(mansagem);
        javaMailSender.send(simpleMailMessage);
        return "Email enviado com sucesso!";

        }catch (Exception ex){
            return "Error! Email não enviado.";

        }
    }
}
