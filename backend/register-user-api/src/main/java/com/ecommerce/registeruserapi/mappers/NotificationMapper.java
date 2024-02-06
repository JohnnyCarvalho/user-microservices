package com.ecommerce.registeruserapi.mappers;

import com.ecommerce.registeruserapi.dto.request.UserCreateRequest;
import com.ecommerce.registeruserapi.dto.response.EmailResponse;

public interface NotificationMapper {

    static EmailResponse toEmailREsponse(UserCreateRequest request) {
        return EmailResponse.builder()
                .userName(request.getUserName())
                .emailTo(request.getEmail())
                .subject("Registration Successfully Completed!")
                .text("Welcome to the user registration system sr " + request.getFirstName() + "!")
                .build();
    }
}
