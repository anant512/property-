package com.property.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.property.models.PropertyDetails;

public interface PropertyRepo extends JpaRepository<PropertyDetails,Integer>{

	
	
}
