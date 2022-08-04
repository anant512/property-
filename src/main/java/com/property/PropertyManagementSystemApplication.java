package com.property;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PropertyManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(PropertyManagementSystemApplication.class, args);
		System.out.println("server started on port 9090");
	}
	
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
