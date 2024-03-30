package com.ecommerce.registeruserapi.controllers;

import com.ecommerce.registeruserapi.dto.request.UserCreateRequest;
import com.ecommerce.registeruserapi.dto.response.UserCreateResponse;
import com.ecommerce.registeruserapi.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/register-user")
@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserCreateResponse> createUser(@RequestBody @Valid UserCreateRequest userCreate) {

        final UserCreateResponse response = userService.createUser(userCreate);
        return ResponseEntity.ok(response);
    }
}
