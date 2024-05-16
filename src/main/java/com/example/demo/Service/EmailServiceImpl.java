package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl  implements EmailService {

    private MailSender mailSender;

    @Autowired
    public EmailServiceImpl(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public EmailServiceImpl() {
    }

    @Async
    public void sendMailDog(String message){
        final SimpleMailMessage simpleMail = new SimpleMailMessage();
        simpleMail.setFrom("Luk-2004@mail.ru");
        simpleMail.setTo("Luk-2004@mail.ru");
        simpleMail.setSubject("New Dogs");
        simpleMail.setText("New Dog has been created");
        this.mailSender.send(simpleMail);
        System.out.println(message);
    }

    @Async
    public void sendMailUser(String message){
        final SimpleMailMessage simpleMail = new SimpleMailMessage();
        simpleMail.setFrom("Luk-2004@mail.ru");
        simpleMail.setTo("Luk-2004@mail.ru");
        simpleMail.setSubject("New Users");
        simpleMail.setText("New Users has been created");
        this.mailSender.send(simpleMail);
        System.out.println(message);
    }
}
