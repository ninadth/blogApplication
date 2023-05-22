package com.bikkadit.curdopration.service;

import java.util.List;

import com.bikkadit.curdopration.payload.UserDto;

public interface UserServiceI {

	UserDto registerNewUser(UserDto userdto);
	
	public UserDto saveUser(UserDto userdto);
	
	public UserDto getSingleUser(Long userId);
	
	public List<UserDto> getAllUser();
	
	public UserDto updateUser(UserDto userdto, Long userId);
	
	public void deleteUser(Long userId);
}
