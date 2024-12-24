package com.rentalappapi.api.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Getter
@Setter
public class OwnerRequestBody {
    private int ownerId;

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;

    @Setter(AccessLevel.NONE)
    private LocalDateTime registrationDate;
}
