package com.ecommerce.registeruserapi.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user-data")
@Getter
@Setter
@Transactional
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @Column(unique = true)
    private String email;

    @Column(name = "user_name", unique = true)
    private String userName;

    @Column(name = "phone_number")
    private Integer phoneNumber;

    @Column(name = "document_number")
    private Integer documentNumber;

    @Column
    private String street;

    @Column(name = "house_number")
    private Integer houseNumber;

    @Column(name = "reference_point")
    private String referencePoint;

    @Column
    private String state;

    @Column
    private String country;

    @Column(name = "zip_code")
    private Integer zipCode;

    @Column
    private String password;

}
