package com.example.springboot_mysql.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public record UserDto(
		Long id,
		String firstName,
		String lastName,
		String email,
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
		LocalDate dateOfBirth
	
		) {

}
