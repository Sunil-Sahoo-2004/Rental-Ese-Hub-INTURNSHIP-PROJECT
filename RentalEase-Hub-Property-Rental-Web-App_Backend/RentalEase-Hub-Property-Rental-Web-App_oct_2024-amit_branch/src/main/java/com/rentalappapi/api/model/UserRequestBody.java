package com.rentalappapi.api.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
public class UserRequestBody {

    private int userId;

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private int userType;

    @Setter(AccessLevel.NONE)
    private LocalDateTime registrationDate;

}
