package com.genctracker.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genctracker.exceptions.*;
import com.genctracker.entities.UserLogin;
import com.genctracker.payloads.UserLoginDto;
import com.genctracker.repositories.UserLoginRepo;
import com.genctracker.services.UserLoginService;

@Service
public class UserLoginServiceImpl implements UserLoginService{
	
	@Autowired
	public UserLoginRepo userLoginRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserLoginDto createUserLogin(UserLoginDto userLoginDto) {
		UserLogin userLogin = this.dtoToUserLogin(userLoginDto);
		UserLogin savedUserLogin = this.userLoginRepo.save(userLogin);
		return this.userLoginDto(savedUserLogin);

	}

	@Override
	public UserLoginDto updateUserLogin(UserLoginDto userLoginDto, Integer userId) {
		
		UserLogin userLogin = this.userLoginRepo.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("UserLogin", " id ", userId));
		
		userLogin.setName(userLoginDto.getName());
		userLogin.setEmail(userLoginDto.getEmail());
		userLogin.setPassword(userLoginDto.getPassword());
		UserLogin updatedUserLogin = this.userLoginRepo.save(userLogin);
		UserLoginDto userLoginDto1 =   this.userLoginDto(updatedUserLogin);
		return userLoginDto1;
	}

	@Override
	public UserLoginDto getUserLoginById(Integer userId) {
		
		UserLogin userLogin = userLoginRepo.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("UserLogin", "Id", userId));
		return this.userLoginDto(userLogin);
	}

	@Override
	public List<UserLoginDto> getAllUserLoginDto() {
		
		List<UserLogin> userLogins = this.userLoginRepo.findAll();
		List<UserLoginDto> userLoginDtos = userLogins.stream().map(userLogin->this.userLoginDto(userLogin))
				.collect(Collectors.toList());
		
		return userLoginDtos;
	}

	@Override
	public void deleteUserLogin(Integer userId) {
		
		UserLogin userLogin = this.userLoginRepo.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("UserLogin", "Id", userId));
		this.userLoginRepo.delete(userLogin);
		
	}
	
	public UserLogin dtoToUserLogin(UserLoginDto userLoginDto) {
		
		UserLogin userLogin = this.modelMapper.map(userLoginDto, UserLogin.class);
		
//		userLogin.setId(userLoginDto.getId());
//		userLogin.setName(userLoginDto.getName());
//		userLogin.setEmail(userLoginDto.getEmail());
//		userLogin.setPassword(userLoginDto.getPassword());
		
		return userLogin;
	}
	
	public UserLoginDto userLoginDto(UserLogin userLogin) {
		UserLoginDto userLoginDto = this.modelMapper.map(userLogin, UserLoginDto.class);
	
//		userLoginDto.setId(userLogin.getId());
//		userLoginDto.setName(userLogin.getName());
//		userLoginDto.setEmail(userLogin.getEmail());
//		userLoginDto.setPassword(userLogin.getPassword());
		
		return userLoginDto;
	
	}
}