package com.example.springboot_mysql.service;

import java.util.List;

import com.example.springboot_mysql.dto.UserDto;

public interface UserService {
	
	UserDto createUser(UserDto userDto);
	UserDto getUserById(Long id);
	List<UserDto> getAllUsers();
	UserDto udateUser(Long id,UserDto userDto);
	void deleteUser(Long id);
	

}
