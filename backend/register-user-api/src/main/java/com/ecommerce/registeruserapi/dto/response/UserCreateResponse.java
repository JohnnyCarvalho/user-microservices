package com.ecommerce.registeruserapi.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserCreateResponse {

    private Long id;

    private String userName;
}
