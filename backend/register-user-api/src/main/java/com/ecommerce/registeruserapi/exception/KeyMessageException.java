package com.ecommerce.registeruserapi.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum KeyMessageException {

    EMAIL_ALREADY_EXIST("email.already.exist"),

    USER_ALREADY_EXIST("user.already.exist"),

    USER_BLOCKED("user.blocked"),

    USER_NAME_ALREADY_EXIST("user.name.already.exist");

    private final String key;
}
