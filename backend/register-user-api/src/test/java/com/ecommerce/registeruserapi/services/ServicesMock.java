package com.ecommerce.registeruserapi.services;

import com.ecommerce.registeruserapi.dto.request.UserCreateRequest;
import com.ecommerce.registeruserapi.dto.response.UserCreateResponse;

public interface ServicesMock {

    static UserCreateRequest createUserModelRequest() {

        return UserCreateRequest.builder()
                .firstName("Example")
                .middleName("Example")
                .lastName("Example")
                .email("example@example.com")
                .userName("Example.Example")
                .phoneNumber("55996542314")
                .documentNumber("02545698532")
                .street("Street Example")
                .houseNumber("123")
                .referencePoint("Example")
                .state("EX")
                .country("USA")
                .zipCode("8534090")
                .password("000000")
                .build();
    }

    static UserCreateRequest createUserBlockedModelRequest() {

        return UserCreateRequest.builder()
                .firstName("Example")
                .middleName("Example")
                .lastName("Example")
                .email("example@blocked.com")
                .userName("Example.Blocked")
                .phoneNumber("55996542314")
                .documentNumber("02545698532")
                .street("Street Example")
                .houseNumber("123")
                .referencePoint("Example")
                .state("EX")
                .country("USA")
                .zipCode("8534090")
                .password("000000")
                .build();
    }

    static UserCreateResponse createUserModelResponse() {

        UserCreateResponse response = new UserCreateResponse();

        response.setId(1L);
        response.setUserName("Example.Example");
        response.setStatus(true);

        return response;
    }
}
