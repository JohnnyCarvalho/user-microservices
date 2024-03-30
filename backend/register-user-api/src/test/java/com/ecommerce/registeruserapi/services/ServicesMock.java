package com.ecommerce.registeruserapi.services;

import com.ecommerce.registeruserapi.dto.request.UserCreateRequest;
import com.ecommerce.registeruserapi.dto.response.UserCreateResponse;
import com.ecommerce.registeruserapi.entities.User;

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

    static UserCreateRequest createUserEmailAlreadyExistModelRequest() {

        return UserCreateRequest.builder()
                .firstName("Example")
                .middleName("Example")
                .lastName("Example")
                .email("example@example.com")
                .userName("Example2.Example2")
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

    static User createUserBlockedModelRequest() {

        User user = new User();

        user.setFirstName("Example");
        user.setMiddleName("Example");
        user.setLastName("Example");
        user.setEmail("example@blocked.com");
        user.setUserName("Example.Blocked");
        user.setPhoneNumber("55996542314");
        user.setDocumentNumber("02545698532");
        user.setStreet("Street Example");
        user.setHouseNumber("123");
        user.setReferencePoint("Example");
        user.setState("EX");
        user.setCountry("USA");
        user.setZipCode("8534090");
        user.setPassword("000000");
        user.setStatus(false);

        return user;
    }

    static UserCreateRequest createUserFromBlockedModelRequest() {

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
