package com.property.payload;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
 
public class PropertyDto {

	
	private int id;
	@NotNull
	private String apartmenttype;
	
	@NotNull
	private String bhktype; 
	
	@NotNull
	private String floor ;
	
	@NotNull
	private String totalfloor;
	
	@NotNull
	  private String propertyage;
	@NotNull
	  private String facing ;
	@NotNull
	  private int builduparea;
}
