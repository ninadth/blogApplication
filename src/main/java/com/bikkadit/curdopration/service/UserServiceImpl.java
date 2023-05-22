package com.bikkadit.curdopration.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bikkadit.curdopration.dao.RoleRepo;
import com.bikkadit.curdopration.dao.UserRepository;
import com.bikkadit.curdopration.exceptionhandling.UserNotFoundException;
import com.bikkadit.curdopration.helper.AppConstant;
import com.bikkadit.curdopration.model.Role;
import com.bikkadit.curdopration.model.User;
import com.bikkadit.curdopration.payload.UserDto;

@Service
public class UserServiceImpl implements UserServiceI {
	
	Logger logger=LoggerFactory.getLogger(UserServiceImpl.class);
	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private RoleRepo roleRepo;

	@Override
	public UserDto saveUser(UserDto UserDto) {
		
		User newuser = this.modelMapper.map(UserDto,User.class);
		
		User user1 = this.userRepository.save(newuser);
		
		UserDto updateUser = this.modelMapper.map(newuser,UserDto.class);
		
		return updateUser;
	}

	@Override
	public  List<UserDto> getAllUser() {
		
		List<User> alluser = this.userRepository.findAll();
	  
	 List<UserDto> collect = alluser.stream().map((list)->this.modelMapper.map(alluser,UserDto.class)).collect(Collectors.toList());
	 
		return collect;
	}

	@Override
	public UserDto getSingleUser(Long UserID) {
		 User orElseThrow = this.userRepository.findById(UserID).orElseThrow(() ->new UserNotFoundException("User", "UserID", UserID));
		 
		 UserDto userDto = this.modelMapper.map(orElseThrow,UserDto.class);
		return userDto;
	}

	@Override
	public void deleteUser(Long UserId) {
		
		User newuser = this.userRepository.findById(UserId).orElseThrow(() ->new UserNotFoundException(AppConstant.USER_DELETE, "UserId", UserId));
		this.userRepository.delete(newuser);
	}

	@Override
	public UserDto updateUser(UserDto userDto,Long id) {
		
		 User user2 = this.userRepository.findById(id).orElseThrow(() ->new UserNotFoundException(AppConstant.INVALID, "id", id)); 
		
		String firstName = user2.getUserFirstName();
		String lastName = user2.getUserLastName();
		String email = user2.getUserEmail();
		String password = user2.getPassword();
		String about = user2.getAbout();
		
		
		this.userRepository.save(user2);
		
		UserDto userDto2 = this.modelMapper.map(user2, UserDto.class);
		
		return userDto2;
		
}

	@Override
	public UserDto registerNewUser(UserDto userdto) {
		User user = this.modelMapper.map(userdto, User.class);

		// password incode
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));

		// getting role
	   Role role = this.roleRepo.findById(AppConstant.USER_NORMAL).get();
	 
		user.getRoles().add(role);
		User user2 = this.userRepository.save(user);
		return this.modelMapper.map(user2, UserDto.class);
	}
	

}
