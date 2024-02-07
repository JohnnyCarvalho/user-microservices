package com.ecommerce.registeruserapi.services;

import com.ecommerce.registeruserapi.producer.UserProducer;
import com.ecommerce.registeruserapi.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ServicesTest {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserProducer producer;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    void ShouldCreateUserInDataBase() {

    }
}
