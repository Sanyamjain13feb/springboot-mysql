package com.example.springboot_mysql.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.springboot_mysql.dto.UserDto;
import com.example.springboot_mysql.entity.User;
import com.example.springboot_mysql.exception.ResourceNotFoundException;
import com.example.springboot_mysql.mapper.UserMapper;
import com.example.springboot_mysql.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {

	private final  UserRepository userRepository;
	private  final UserMapper userMapper;
	

	public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
		super();
		this.userRepository = userRepository;
		this.userMapper = userMapper;
	}



	@Override
	public UserDto createUser(UserDto userDto) {
		// TODO Auto-generated method stub
		User user =userMapper.toEntity(userDto);
		User savedUser=userRepository.save(user);
		return userMapper.toDto(savedUser);
	}


	@Override
	public UserDto getUserById(Long id) {
		// TODO Auto-generated method stub
		User user=userRepository.findById(id)
		.orElseThrow(()->new ResourceNotFoundException("User not Found with id:"+id));
		return userMapper.toDto(user);
	}



	@Override
	public List<UserDto> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll()
				.stream()
				.map(userMapper::toDto)
				.collect(Collectors.toList());
	}


	@Override
	public UserDto udateUser(Long id, UserDto userDto) {
		// TODO Auto-generated method stub
		User user=userRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("User not Found with id:"+id));
		user.setFirstName(userDto.firstName());
		user.setLastName(userDto.lastName());
		user.setEmail(userDto.email());
		user.setDateOfBirth(userDto.dateOfBirth());
		User updatedUser=userRepository.save(user);
		return userMapper.toDto(updatedUser);
	}



	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		if(!userRepository.existsById(id)) {
			throw new ResourceNotFoundException("User not Found with id: " +id);
		}
		userRepository.deleteById(id);
		
	}

}
