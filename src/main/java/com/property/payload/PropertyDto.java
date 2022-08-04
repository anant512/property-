package com.property.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

public class PropertyDto {

	
	private int id;
	private String apartmenttype;
	private String bhktype;  
	private String floor ;
	private String totalfloor;
	  private String propertyage;
	  private String facing ;
	  private int builduparea;
}
