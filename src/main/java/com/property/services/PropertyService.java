package com.property.services;

import java.util.List;

import com.property.payload.PropertyDto;

public interface PropertyService {
	
	
	PropertyDto  createProperty(PropertyDto property);
	PropertyDto updateProperty(PropertyDto property , Integer id);
	
	PropertyDto getPropertyById(Integer id);
	List <PropertyDto> getAllPropeties();
	
	void deleteProperty(Integer id);
	
	
	
	
	
	

}
