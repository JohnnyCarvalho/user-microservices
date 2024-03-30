package com.ecommerce.registeruserapi.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.ecommerce.registeruserapi.controllers.UserController;
import com.ecommerce.registeruserapi.dto.request.UserCreateRequest;
import com.ecommerce.registeruserapi.entities.User;
import com.ecommerce.registeruserapi.repositories.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.cbor.MappingJackson2CborHttpMessageConverter;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class UserControllerTest {

    private final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private String json;

    private UserCreateRequest userCreateRequest;

    private final String URL = "/register-user";

    @InjectMocks
    private UserController userController;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setup() throws JsonProcessingException {
        mockMvc = MockMvcBuilders
                .standaloneSetup(userController)
                .alwaysDo(print())
                .setMessageConverters(new MappingJackson2CborHttpMessageConverter(OBJECT_MAPPER))
                .build();

        OBJECT_MAPPER.registerModule(new JavaTimeModule());
        OBJECT_MAPPER.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        userCreateRequest = ControllerMock.createUserModelRequest();
        User USER = ControllerMock.createUserEntityModel();
        userRepository.save(USER);
        json = OBJECT_MAPPER.writeValueAsString(userCreateRequest);
        userController.createUser(userCreateRequest);
    }

    @AfterEach
    void down() {
        userRepository.deleteAll();
    }

    @Test
    void shouldAccessRouteUrlAndSaveANewUserSuccessfully() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post(URL)
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .accept(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

}
