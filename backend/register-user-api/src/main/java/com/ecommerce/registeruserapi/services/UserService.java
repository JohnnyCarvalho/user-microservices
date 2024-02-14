package com.ecommerce.registeruserapi.services;

import static com.ecommerce.registeruserapi.exception.KeyMessageException.EMAIL_ALREADY_EXIST;
import static com.ecommerce.registeruserapi.exception.KeyMessageException.USER_BLOCKED;
import static com.ecommerce.registeruserapi.exception.KeyMessageException.USER_NAME_ALREADY_EXIST;

import com.ecommerce.registeruserapi.dto.request.UserCreateRequest;
import com.ecommerce.registeruserapi.dto.response.UserCreateResponse;
import com.ecommerce.registeruserapi.entities.User;
import com.ecommerce.registeruserapi.exception.AlreadyExistException;
import com.ecommerce.registeruserapi.exception.UserBlockedException;
import com.ecommerce.registeruserapi.producer.UserProducer;
import com.ecommerce.registeruserapi.repositories.UserRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    private final UserProducer userProducer;

    private final PasswordEncoder passwordEncoder;

    private final ModelMapper modelMapper;

    public UserCreateResponse createUser(UserCreateRequest userCreate) {

        User userEntity = modelMapper.map(userCreate, User.class);

        verifyUserNameAlreadyExist(userCreate);

        String hashedPassword = passwordEncoder.encode(userCreate.getPassword());

        userCreate.setPassword(hashedPassword);

        final User newUser = modelMapper.map(userCreate, User.class);

        userRepository.save(newUser);

        sendNotification(userCreate);

        return modelMapper.map(newUser, UserCreateResponse.class);
    }

    private void verifyUserNameAlreadyExist(UserCreateRequest userCreate) {
        userRepository.findByUserName(userCreate.getUserName())
                .ifPresent(existingUser -> {
                    throw new AlreadyExistException(USER_NAME_ALREADY_EXIST.getKey());
                });

        verifyEmailAlreadyExist(userCreate);
    }


    private void verifyEmailAlreadyExist(UserCreateRequest userCreate) {
        userRepository.findByEmail(userCreate.getEmail())
                .ifPresent(existingUserEmail -> {
                    throw new AlreadyExistException(EMAIL_ALREADY_EXIST.getKey());
                });

        verifyUserStatus(userCreate);
    }

    private void verifyUserStatus(UserCreateRequest userCreate) {
        Optional<User> userStatus = userRepository.findByUserName(userCreate.getUserName());

        if (userStatus.isPresent() && userStatus.get().getStatus().equals(false)) {
            throw new UserBlockedException(USER_BLOCKED.getKey());
        }
    }

    private void sendNotification(UserCreateRequest userCreate) {
        userProducer.publishMessageEmail(userCreate);
    }
}
