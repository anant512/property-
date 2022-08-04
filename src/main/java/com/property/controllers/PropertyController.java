package com.property.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.property.models.PropertyDetails;
import com.property.payload.ApiResponse;
import com.property.payload.PropertyDto;
import com.property.services.PropertyService;

import net.bytebuddy.implementation.bytecode.constant.IntegerConstant;

@RestController
@RequestMapping("/api/properties")
public class PropertyController {
	
	
	@Autowired
	private PropertyService propertyService;
	
	//POST-create property
	@PostMapping("/")
	public ResponseEntity <PropertyDto> createProperty(@RequestBody PropertyDto propertyDto){
		
		PropertyDto createPropertyDto= this.propertyService.createProperty(propertyDto);
		return  new ResponseEntity<>(createPropertyDto,HttpStatus.CREATED);
	}
	
	
	//PUT-update property
	
	@PutMapping("/{Id}")
	  public ResponseEntity<PropertyDto> updateProperty(@RequestBody PropertyDto propertyDto, @PathVariable("Id") Integer Id ){
		  
		 PropertyDto updatedProperty= this.propertyService.updateProperty(propertyDto, Id);
		  
		return ResponseEntity.ok(updatedProperty);
		  
	  }
	
	
	// DELETE-delete property
	
	@DeleteMapping("{Id}")
	public ResponseEntity<ApiResponse> deleteProperty(@PathVariable("Id") Integer Id){
		this.propertyService.deleteProperty(Id);
		return new  ResponseEntity<ApiResponse>(new ApiResponse("Property Deleted Successfully",true),HttpStatus.OK);
	}
	
	// GET-property get
	
	@GetMapping("/")
	public ResponseEntity<List<PropertyDto>> getAllProperties(){
		return ResponseEntity.ok(this.propertyService.getAllPropeties());
	}
	
	// GET-property get
	@GetMapping("/{Id}")
		public ResponseEntity<PropertyDto> getSingleProperty(@PathVariable Integer Id){
			return ResponseEntity.ok(this.propertyService.getPropertyById(Id));
		}

}
