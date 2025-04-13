package com.decode.decode.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailServiceTest {

    @Autowired
    EmailService emailService;

    @Test
    public void sendEmail(){
        emailService.sendSimpleMail("mohit1pandey15@gmail.com","Job mail","You will get a job bro!");
    }

}
