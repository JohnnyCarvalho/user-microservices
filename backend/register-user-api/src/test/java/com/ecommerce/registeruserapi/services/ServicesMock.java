package com.ecommerce.registeruserapi.services;

import com.ecommerce.registeruserapi.dto.request.UserCreateRequest;

public interface ServicesMock {

    static UserCreateRequest createUserModel() {

        return UserCreateRequest.builder()
                .firstName("Example")
                .middleName("Example")
                .lastName("Example")
                .email("example@example.com")
                .userName("Example.Example")
                .phoneNumber("55996542314")
                .documentNumber("02545698532")

                .build();
    }
}
