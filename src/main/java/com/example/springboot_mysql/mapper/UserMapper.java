package com.example.springboot_mysql.mapper;

import org.springframework.stereotype.Component;

import com.example.springboot_mysql.dto.UserDto;
import com.example.springboot_mysql.entity.User;

@Component
public class UserMapper {
	
	public UserDto toDto(User user) {
		return new UserDto(
				user.getId(),
				user.getFirstName(),
				user.getLastName(),
				user.getEmail(),
				user.getDateOfBirth()
				);
	}
	
	public User toEntity(UserDto userDto) {
		User user=new User();
		user.setId(userDto.id());
		user.setFirstName(userDto.firstName());
		user.setLastName(userDto.lastName());
		user.setEmail(userDto.email());
		user.setDateOfBirth(userDto.dateOfBirth());
		
		return user;
	}

}
