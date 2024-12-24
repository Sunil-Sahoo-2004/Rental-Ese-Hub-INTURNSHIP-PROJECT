package com.rentalappapi.api.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "amit_properties")
public class PropertyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "property_id", nullable = false)
    private int propertyId;
//    private Integer propertyId;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "owner_id")
//    private PropertyEntity owner;
    @Column(name = "owner_id")
    private int ownerId;

    @Column(name = "title")
    private String title;

//    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "address")
    private String address;

    @Column(name = "city", length = 100)
    private String city;

    @Column(name = "state", length = 100)
    private String state;

    @Column(name = "country", length = 100)
    private String country;

    @Column(name = "postal_code", length = 10)
    private String postalCode;

    @Column(name = "price_per_night", precision = 10, scale = 2)
    private BigDecimal pricePerNight;

    @Column(name = "max_guests")
    private Integer maxGuests;

//    @Lob
    @Column(name = "property_type")
    private String propertyType;

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    @Setter(AccessLevel.NONE)
    private Instant createdAt;

}