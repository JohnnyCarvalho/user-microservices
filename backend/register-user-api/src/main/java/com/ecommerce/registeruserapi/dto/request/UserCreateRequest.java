package com.ecommerce.registeruserapi.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Setter
@Builder
@Jacksonized
public class UserCreateRequest {

    @NotBlank(message = "First name is not null!")
    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("middle_name")
    private String middleName;

    @NotBlank(message = "Last name is not null!")
    private String lastName;

    @NotBlank(message = "E-mail is not null!")
    private String email;

    @NotBlank(message = "User name is not null!")
    private String userName;

    @NotNull(message = "Phone is not null!")
    private String phoneNumber;

    @NotNull(message = "Document is not null!")
    private String documentNumber;

    @NotBlank(message = "Street is not null!")
    private String street;

    @NotNull(message = "House number is not null!")
    private String houseNumber;

    private String referencePoint;

    @NotBlank(message = "State is not null!")
    private String state;

    @NotBlank(message = "Country is not null!")
    private String country;

    @NotBlank(message = "Zip code is not null!")
    private String zipCode;

    @NotBlank(message = "Password is not null!")
    private String password;

}
