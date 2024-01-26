package com.ecommerce.registeruserapi.mappers;

import com.ecommerce.registeruserapi.dto.request.UserCreateRequest;
import com.ecommerce.registeruserapi.dto.response.UserCreateResponse;
import com.ecommerce.registeruserapi.entities.User;

public interface UserCreateMapper {

    static User toCreateModel(final UserCreateRequest request) {
        final User user = new User();

        user.setFirstName(request.getFirstName());
        user.setMiddleName(request.getMiddleName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setUserName(request.getUserName());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setDocumentNumber(request.getDocumentNumber());
        user.setStreet(request.getStreet());
        user.setHouseNumber(request.getHouseNumber());
        user.setReferencePoint(request.getReferencePoint());
        user.setState(request.getState());
        user.setCountry(request.getCountry());
        user.setZipCode(request.getZipCode());
        user.setPassword(request.getPassword());

        return user;
    }

    static UserCreateResponse toCreateResponseModel(final User request) {
        return UserCreateResponse.builder()
                .id(request.getId())
                .userName(request.getUserName())
                .build();
    }
}
