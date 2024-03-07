package com.ecommerce.registeruserapi.services;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.times;
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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;

@ExtendWith(MockitoExtension.class)
public class ServicesTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserProducer userProducer;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private UserService userService;

    private UserCreateRequest userCreateRequest;

    @BeforeEach
    void setUp() {
        userCreateRequest = ServicesMock.createUserModelRequest();
        userCreateRequest.setUserName("testUser");
        userCreateRequest.setPassword("password");
        userCreateRequest.setEmail("test@example.com");
    }

    @Test
    void whenCreateUser_thenSucceed() {
        when(userRepository.findByUserName(anyString())).thenReturn(Optional.empty());
        when(userRepository.findByEmail(anyString())).thenReturn(Optional.empty());
        when(passwordEncoder.encode(anyString())).thenReturn("hashedPassword");
        when(modelMapper.map(any(), eq(User.class))).thenReturn(new User());
        when(modelMapper.map(any(), eq(UserCreateResponse.class))).thenReturn(new UserCreateResponse());

        assertDoesNotThrow(() -> userService.createUser(userCreateRequest));
        verify(userRepository, times(1)).save(any(User.class));
        verify(userProducer, times(1)).publishMessageEmail(any(UserCreateRequest.class));
    }

    @Test
    void whenUserNameExists_thenThrowAlreadyExistException() {
        when(userRepository.findByUserName(anyString())).thenReturn(Optional.of(new User()));

        assertThatThrownBy(() -> userService.createUser(userCreateRequest))
                .isInstanceOf(AlreadyExistException.class)
                .hasMessage(KeyMessageException.USER_NAME_ALREADY_EXIST.getKey());
    }

    @Test
    void whenEmailExists_thenThrowAlreadyExistException() {
        when(userRepository.findByUserName(anyString())).thenReturn(Optional.empty());
        when(userRepository.findByEmail(anyString())).thenReturn(Optional.of(new User()));

        assertThatThrownBy(() -> userService.createUser(userCreateRequest))
                .isInstanceOf(AlreadyExistException.class)
                .hasMessage(KeyMessageException.EMAIL_ALREADY_EXIST.getKey());
    }

    @Test
    void whenUserBlocked_thenThrowUserBlockedException() {
        User blockedUser = new User();
        blockedUser.setStatus(false);
        when(userRepository.findByUserName(anyString())).thenReturn(Optional.of(blockedUser));

        assertThatThrownBy(() -> userService.createUser(userCreateRequest))
                .isInstanceOf(UserBlockedException.class)
                .hasMessage(KeyMessageException.USER_BLOCKED.getKey());
    }
}
