package com.ecommerce.registeruserapi.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class UserCreateResponse {

    private Long id;

    private String userName;

    private Boolean status;
}
