package com.rentalappapi.api.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
public class AppointmentRequestBody {
    private int appointmentId;
    private int userId;
    private int ownerId;
    private int propertyId;
    private String appointmentDate;
    private String appointmentTime;
    private String appointmentStatus;
    private String reasonForVisit;

//    private LocalDateTime createdAt;
}
