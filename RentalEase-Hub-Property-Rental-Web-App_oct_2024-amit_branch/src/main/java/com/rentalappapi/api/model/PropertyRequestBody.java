package com.rentalappapi.api.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Data
public class PropertyRequestBody {
	private int propertyId;

	private int ownerId;
	private String title;
	private String description;
	private String address;
	private String city;
	private String state;
	private String country;
	private String postalCode;
	private BigDecimal pricePerNight;
	private Integer maxGuests;
	private String propertyType;

	@Setter(AccessLevel.NONE)
	private Instant createdAt;
}
