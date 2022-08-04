package com.property.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="property_details")
@NoArgsConstructor
@Getter
@Setter 
public class PropertyDetails {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="apartment_type")
    private String apartmenttype;
	
	@Column(name="BHK_type")
    private String bhktype;
	
	@Column(name="floor")
    private String floor ;
	
	
	@Column(name="total_floor")
    private String totalfloor;
	
	@Column(name="property_age")
    private String propertyage;
	
	@Column(name="facing")
    private String facing ;
	
	@Column(name="build_up_area")
    private int builduparea;
    
	

}
