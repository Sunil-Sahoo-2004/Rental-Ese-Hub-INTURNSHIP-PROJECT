package com.rentalappapi.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rentalappapi.api.model.PropertyIdRequest;
import com.rentalappapi.api.model.PropertyRequestBody;
import com.rentalappapi.api.service.PropertyService;
 
  
@RestController
@CrossOrigin
public class PropertyController {
	
	@Autowired
	private PropertyService PropertyService;	
	
	@RequestMapping(value = "/createProperty", method = RequestMethod.POST)
	public ResponseEntity<?> createProperty(@RequestBody PropertyRequestBody PropertyReqBody) throws Exception {
		return ResponseEntity.ok(PropertyService.createProperty(PropertyReqBody));
	}
	
	@RequestMapping(value = "/updateProperty", method = RequestMethod.PUT)
	public ResponseEntity<?> updateProperty(@RequestBody PropertyRequestBody PropertyReqBody) throws Exception {
		return ResponseEntity.ok(PropertyService.updateProperty(PropertyReqBody));
	}		
	
	@RequestMapping(value = "/listAllProperties", method = RequestMethod.GET)
	public ResponseEntity<?> listAllProperties(@RequestParam(defaultValue = "0") final Integer pageNumber,
			@RequestParam(defaultValue = "10") final Integer size) throws Exception {
		return ResponseEntity.ok(PropertyService.listAllPropertiesFromDB(pageNumber, size));
	}		
	
	@RequestMapping(value = "/deleteProperty", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteProperty(@RequestBody PropertyIdRequest user) throws Exception {
		return ResponseEntity.ok(PropertyService.deleteProperty(user));
	}		
	
	@RequestMapping(value = "/propertiesCount", method = RequestMethod.GET)
	public ResponseEntity<?> countNumberOfProperties() throws Exception {
		return ResponseEntity.ok((PropertyService.countNumberOfProperties()));
	}
	
}
