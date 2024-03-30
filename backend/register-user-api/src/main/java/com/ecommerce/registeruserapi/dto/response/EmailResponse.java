package com.ecommerce.registeruserapi.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EmailResponse {

    private String userName;

    private String emailTo;

    private String subject = "Registration Successfully Completed!";

    private String text;
}
