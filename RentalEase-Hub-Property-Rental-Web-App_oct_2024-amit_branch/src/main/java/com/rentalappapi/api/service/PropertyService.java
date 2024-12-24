package com.rentalappapi.api.service;

import com.rentalappapi.api.entity.PropertyEntity;
import com.rentalappapi.api.model.PropertyIdRequest;
import com.rentalappapi.api.model.PropertyRequestBody; 
import com.rentalappapi.api.repositories.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

@Service
public class PropertyService  {

	@Autowired
	private PropertyRepository PropertyRepository;

	public PropertyEntity createProperty(PropertyRequestBody propertyRequestBodyObj) {

		PropertyEntity newProperty = new PropertyEntity();
		newProperty.setOwnerId(propertyRequestBodyObj.getOwnerId());
		newProperty.setTitle(propertyRequestBodyObj.getTitle());
		newProperty.setDescription(propertyRequestBodyObj.getDescription());
		newProperty.setAddress(propertyRequestBodyObj.getAddress());
		newProperty.setCity(propertyRequestBodyObj.getCity());
		newProperty.setState(propertyRequestBodyObj.getState());
		newProperty.setCountry(propertyRequestBodyObj.getCountry());
		newProperty.setPostalCode(propertyRequestBodyObj.getPostalCode());
		newProperty.setPricePerNight(propertyRequestBodyObj.getPricePerNight());
		newProperty.setMaxGuests(propertyRequestBodyObj.getMaxGuests());
		newProperty.setPropertyType(propertyRequestBodyObj.getPropertyType());
		return PropertyRepository.save(newProperty);
	}

	public PropertyEntity updateProperty(PropertyRequestBody propertyRequestBodyObj) {
		PropertyEntity newProperty = new PropertyEntity();
		newProperty.setPropertyId(propertyRequestBodyObj.getPropertyId() );
		newProperty.setOwnerId(propertyRequestBodyObj.getOwnerId());
		newProperty.setTitle(propertyRequestBodyObj.getTitle());
		newProperty.setDescription(propertyRequestBodyObj.getDescription());
		newProperty.setAddress(propertyRequestBodyObj.getAddress());
		newProperty.setCity(propertyRequestBodyObj.getCity());
		newProperty.setState(propertyRequestBodyObj.getState());
		newProperty.setCountry(propertyRequestBodyObj.getCountry());
		newProperty.setPostalCode(propertyRequestBodyObj.getPostalCode());
		newProperty.setPricePerNight(propertyRequestBodyObj.getPricePerNight());
		newProperty.setMaxGuests(propertyRequestBodyObj.getMaxGuests());
		newProperty.setPropertyType(propertyRequestBodyObj.getPropertyType());
		return PropertyRepository.save(newProperty);		 
	}

	public Page<PropertyEntity> listAllPropertiesFromDB(int pageNumber, int size) {
		Pageable pageable = PageRequest.of(pageNumber, size);
		return PropertyRepository.listAllPropertiesFromDB(pageable);
	}
 
	public String deleteProperty(PropertyIdRequest user) {
		int PropertyId= user.getPropertyId();
		PropertyRepository.deleteById(PropertyId);
		return "Property Deleted";
	}

	public String countNumberOfProperties() {

		return PropertyRepository.countNumberOfProperties();
	}

}
