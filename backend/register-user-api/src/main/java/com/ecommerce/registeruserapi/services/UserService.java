package com.ecommerce.registeruserapi.services;

import static com.ecommerce.registeruserapi.exception.KeyMessageException.EMAIL_ALREADY_EXIST;
import static com.ecommerce.registeruserapi.exception.KeyMessageException.USER_BLOCKED;
import static com.ecommerce.registeruserapi.exception.KeyMessageException.USER_NAME_ALREADY_EXIST;

import com.ecommerce.registeruserapi.dto.request.UserCreateRequest;
import com.ecommerce.registeruserapi.dto.response.UserCreateResponse;
import com.ecommerce.registeruserapi.entities.User;
import com.ecommerce.registeruserapi.exception.AlreadyExistException;
import com.ecommerce.registeruserapi.exception.UserBlockedException;
import com.ecommerce.registeruserapi.mappers.UserCreateMapper;
import com.ecommerce.registeruserapi.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserCreateResponse createUser(UserCreateRequest userCreate) {

        verifyUserNameAlreadyExist(userCreate);

        verifyEmailAlreadyExist(userCreate);

        verifyUserStatus(userCreate);

        final User newUser = UserCreateMapper.toCreateModel(userCreate);

        userRepository.save(newUser);

        return UserCreateMapper.toCreateResponseModel(newUser);
    }

    private void verifyUserNameAlreadyExist(UserCreateRequest userCreate) {
        userRepository.findByUserName(userCreate.getUserName())
                .ifPresent(existingUser -> {
                    throw new AlreadyExistException(USER_NAME_ALREADY_EXIST.getKey());
                });
    }


    private void verifyEmailAlreadyExist(UserCreateRequest userCreate) {
        userRepository.findByEmail(userCreate.getEmail())
                .ifPresent(existingUserEmail -> {
                    throw new AlreadyExistException(EMAIL_ALREADY_EXIST.getKey());
                });
    }

    private void verifyUserStatus(UserCreateRequest userCreate) {
        User userStatus = userRepository.findUserByUserName(userCreate.getUserName());

        if (userStatus != null && Boolean.FALSE.equals(userStatus.getStatus())) {
            throw new UserBlockedException(USER_BLOCKED.getKey());
        }
    }
}
