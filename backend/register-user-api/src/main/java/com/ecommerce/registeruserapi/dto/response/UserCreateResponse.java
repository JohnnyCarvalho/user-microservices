package com.ecommerce.registeruserapi.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class UserCreateResponse {

    private Long id;

    private String userName;

    private String email;

    private Boolean status;
}
