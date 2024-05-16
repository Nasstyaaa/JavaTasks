package com.example.demo.Test;

import com.example.demo.Service.EmailServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class EmailServiceImplTest {

    @MockBean
    private MailSender mailSender;

    @Autowired
    private EmailServiceImpl emailService;

    @Test
    void sendMailDog() {
        emailService.sendMailDog("Test message");
        verify(mailSender).send(any(SimpleMailMessage.class));
    }

    @Test
    void sendMailUser() {
        emailService.sendMailUser("Test message");
        verify(mailSender).send(any(SimpleMailMessage.class));
    }
}
