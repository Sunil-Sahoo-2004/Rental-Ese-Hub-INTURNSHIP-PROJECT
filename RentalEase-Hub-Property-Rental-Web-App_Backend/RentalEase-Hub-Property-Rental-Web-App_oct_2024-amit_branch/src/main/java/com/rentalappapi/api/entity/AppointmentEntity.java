package com.rentalappapi.api.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "amit_appointments")
public class AppointmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "appointment_id")
    private int appointmentId;

//    @ManyToOne
//    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
//    private UserEntity user;
    @Column(name = "user_id")
    private int userId;

//    @ManyToOne
//    @JoinColumn(name = "owner_id", referencedColumnName = "user_id")
//    private UserEntity owner;
    @Column(name = "owner_id")
    private int ownerId;

    @Column(name = "property_id")
    private int propertyId;

    @Column(name = "appointment_date")
    private LocalDate appointmentDate;

    @Column(name = "appointment_time")
    private LocalTime appointmentTime;

    @Column(name = "appointment_status")
    private String appointmentStatus;

    @Column(name = "reason_for_visit")
    private String reasonForVisit;

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    @Setter(AccessLevel.NONE)
    private Instant createdAt;
}
