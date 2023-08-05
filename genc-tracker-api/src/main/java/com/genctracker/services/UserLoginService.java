package com.genctracker.services;

import java.util.List;
import com.genctracker.payloads.UserLoginDto;


public interface UserLoginService {
	
	UserLoginDto createUserLogin(UserLoginDto userLoginDto);
	UserLoginDto updateUserLogin(UserLoginDto userLoginDto, Integer userId);
	UserLoginDto getUserLoginById(Integer userId);
	List<UserLoginDto> getAllUserLoginDto();
	void deleteUserLogin(Integer userId);

	
}
