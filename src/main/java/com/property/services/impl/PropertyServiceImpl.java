package com.property.services.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.property.exceptions.ResourceNotFoundException;
import com.property.models.PropertyDetails;
import com.property.payload.PropertyDto;
import com.property.repository.PropertyRepo;
import com.property.services.PropertyService;
@Service
public class PropertyServiceImpl implements PropertyService {
	
	@Autowired
	private PropertyRepo propertyRepo;
	
	@Autowired
	private ModelMapper modelmapper;
	
	
	// adding the properties

	@Override
	public PropertyDto createProperty(PropertyDto propertyDto) {
		 PropertyDetails property = this.dtoToProperty(propertyDto);
		 PropertyDetails saveProperty =this.propertyRepo.save(property);
		
		return this.propertyToDto(saveProperty);
	}

	// updating the property
	@Override
	public PropertyDto updateProperty(PropertyDto propertyDto, Integer id) {
		PropertyDetails property =this.propertyRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("PropertyDetails","propertyId",id));
		
		
		property.setApartmenttype(propertyDto.getApartmenttype());
		property.setBhktype(propertyDto.getBhktype());
		property.setPropertyage(propertyDto.getPropertyage());
		property.setFloor(propertyDto.getFloor());
		property.setTotalfloor(propertyDto.getTotalfloor());
		property.setFacing(propertyDto.getFacing());
		property.setBuilduparea(propertyDto.getBuilduparea());
		
		
		PropertyDetails updatedProperty= this.propertyRepo.save(property);
		
		PropertyDto propertyDto1= this.propertyToDto(updatedProperty);
		
	      
		
		return propertyDto1;
	}

	// 
	@Override
	public PropertyDto getPropertyById(Integer propertyId) {
		
		PropertyDetails property= this.propertyRepo.findById(propertyId).orElseThrow(()-> new ResourceNotFoundException("PropertyDetails","propertyId", propertyId));
		
		return this.propertyToDto(property);
	}

	@Override
	public List<PropertyDto> getAllPropeties() {
		List<PropertyDetails> properties= this.propertyRepo.findAll();
		
	
		List<PropertyDto> propertyDtos= properties.stream().map(property -> this.propertyToDto(property)).collect(Collectors.toList());
		return propertyDtos; 
	}

	@Override
	public void deleteProperty(Integer propertyId) {
		
		PropertyDetails property= this.propertyRepo.findById(propertyId).orElseThrow(()-> new ResourceNotFoundException("PropertyDetails","propertyId", propertyId));
		
        this.propertyRepo.delete(property);
	}
	
	private PropertyDetails dtoToProperty(PropertyDto propertyDto) {
		PropertyDetails property= new PropertyDetails();
		property.setId(propertyDto.getId());
		property.setApartmenttype(propertyDto.getApartmenttype());
		property.setBhktype(propertyDto.getBhktype());
		property.setPropertyage(propertyDto.getPropertyage());
		property.setFloor(propertyDto.getFloor());
		property.setTotalfloor(propertyDto.getTotalfloor());
		property.setFacing(propertyDto.getFacing());
		property.setBuilduparea(propertyDto.getBuilduparea());
		
		return property;
	}
	
	
	public PropertyDto propertyToDto(PropertyDetails property) {
		
		PropertyDto propertyDto=new PropertyDto();
		propertyDto.setId(property.getId());
		propertyDto.setApartmenttype(property.getApartmenttype());
		propertyDto.setBhktype(property.getBhktype());
		propertyDto.setPropertyage(property.getPropertyage());
		propertyDto.setFloor(property.getFloor());
		propertyDto.setTotalfloor(property.getTotalfloor());
		propertyDto.setFacing(property.getFacing());
		propertyDto.setBuilduparea(property.getBuilduparea());
		return propertyDto;
		
	}

}
