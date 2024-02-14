package com.ecommerce.registeruserapi.services;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.ecommerce.registeruserapi.dto.request.UserCreateRequest;
import com.ecommerce.registeruserapi.dto.response.UserCreateResponse;
import com.ecommerce.registeruserapi.entities.User;
import com.ecommerce.registeruserapi.exception.AlreadyExistException;
import com.ecommerce.registeruserapi.exception.KeyMessageException;
import com.ecommerce.registeruserapi.exception.UserBlockedException;
import com.ecommerce.registeruserapi.producer.UserProducer;
import com.ecommerce.registeruserapi.repositories.UserRepository;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ServicesTest {

    @MockBean
    private UserProducer producer;

    @Spy
    private UserRepository repository;

    @Autowired
    private UserService service;

    @Autowired
    private ModelMapper modelMapper;

    @Test
    public void shouldCreateUserInDataBase() {
        UserCreateRequest request = ServicesMock.createUserModelRequest();
        UserCreateResponse responseExpect = ServicesMock.createUserModelResponse();

        doNothing().when(producer).publishMessageEmail(request);
        when(repository.findByUserName(eq(request.getUserName()))).thenReturn(Optional.empty());
        when(repository.findByEmail(eq(request.getEmail()))).thenReturn(Optional.empty());

        UserCreateResponse response = service.createUser(request);
        Optional<User> userAlready = repository.findByUserName(request.getUserName());
        Optional<User> emailAlready = repository.findByEmail(request.getEmail());

        assertEquals(responseExpect.getUserName(), response.getUserName());
        assertEquals(responseExpect.getStatus(), response.getStatus());
        assertFalse(userAlready.isPresent());
        assertFalse(emailAlready.isPresent());
        assertNotNull(response);
        assertNotNull(userAlready);
        assertNotNull(emailAlready);
        verify(repository).findByUserName(eq(request.getUserName()));
        verify(repository).findByEmail(eq(request.getEmail()));
        verify(producer).publishMessageEmail(request);
    }

    @Test
    public void shouldReturnOneAlreadyExistExceptionWithMessageUserNameAlreadyExist() {
        UserCreateRequest request = ServicesMock.createUserModelRequest();

        when(repository.findByUserName(eq(request.getUserName()))).thenReturn(Optional.of(new User()));

        assertThatThrownBy(() -> service.createUser(request))
                .isInstanceOf(AlreadyExistException.class)
                .hasMessage(KeyMessageException.USER_NAME_ALREADY_EXIST.getKey());

        verify(repository).findByUserName(eq(request.getUserName()));
    }

    @Test
    public void shouldReturnOneAlreadyExistExceptionWithMessageEmailAlreadyExist() {
        UserCreateRequest request = ServicesMock.createUserModelRequest();

        when(repository.findByEmail(eq(request.getEmail()))).thenReturn(Optional.of(new User()));

        assertThatThrownBy(() -> service.createUser(request))
                .isInstanceOf(AlreadyExistException.class)
                .hasMessage(KeyMessageException.EMAIL_ALREADY_EXIST.getKey());

        verify(repository).findByEmail(eq(request.getEmail()));

    }

    @Test
    public void shouldReturnOneUserBlockedExceptionWithMessageUserBlocked() {

        //TODO PAREI AQUI, TENTANDO TESTAR O MÉTODO USUÁRIO BLOQUEADO

        //Arrange
        UserCreateRequest requestBefore = ServicesMock.createUserBlockedModelRequest();
        User request = modelMapper.map(requestBefore, User.class);
        request.setStatus(false);

        when(repository.findByUserName(request.getUserName())).thenReturn(Optional.empty());

        //Act
        repository.save(request);

        assertThatThrownBy(() -> repository.save(request))
                .isInstanceOf(UserBlockedException.class)
                        .hasMessage(KeyMessageException.USER_BLOCKED.getKey());

        //Assert
        verify(repository).findByUserName(request.getEmail());
    }
}
