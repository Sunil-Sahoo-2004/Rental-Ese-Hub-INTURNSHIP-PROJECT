package com.rentalappapi.api.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "amit_users")
@Getter
@Setter
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private int userId;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "password_hash", nullable = false)
    private String password;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "user_type")
    private int userType;

    @Column(name = "registration_date", updatable = false)
    @CreationTimestamp
    @Setter(AccessLevel.NONE)
    private Instant registrationDate;
//    private LocalDateTime registrationDate;

//    @OneToMany(mappedBy = "user")
//    private Set<AppointmentEntity> appointments;

//    public int getUserId() {
//        return userId;
//    }
//
//    public void setUserId(int userId) {
//        this.userId = userId;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
//
//    public int getUserType() {
//        return userType;
//    }
//
//    public void setUserType(int userType) {
//        this.userType = userType;
//    }
//
//    public LocalDateTime getRegistrationDate() {
//        return registrationDate;
//    }
//
//    public void setRegistrationDate(LocalDateTime registrationDate) {
//        this.registrationDate = registrationDate;
//    }
}
