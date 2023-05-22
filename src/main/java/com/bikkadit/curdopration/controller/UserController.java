package com.bikkadit.curdopration.controller;

import java.util.List;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.bikkadit.curdopration.payload.UserDto;
import com.bikkadit.curdopration.service.UserServiceI;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/UserCo")
@Slf4j
public class UserController{
	
	Logger logger=LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserServiceI userServiceI;
	
	/**
	 * @author Ninad
	 * @apiNote This API is used to create User
	 * @param userdto
	 * @return
	 */
	
	@PostMapping("User")
	public ResponseEntity<UserDto> saveUser(@Valid @RequestBody UserDto userdto)
	{
		logger.info("Initiated request for create user Details");
		UserDto saveUser = userServiceI.saveUser(userdto);
		logger.info("completed request for create user details");
		return new ResponseEntity<UserDto>(saveUser,HttpStatus.CREATED);
		
	}
	
	/**
	 * 
	 * @apiNote This API is used to getSingleUser 
	 * @param userId
	 * @return
	 */
	
	@GetMapping("/User/{userId}")
	public ResponseEntity<UserDto> getSingleUser(@PathVariable Long userId) 
	{
		logger.info("Initiated request for Getting single user with userId:{}",userId);
		UserDto singleUser = userServiceI.getSingleUser(userId);
		logger.info("Completed request for Getting single user with userId:{}",userId);
		return new ResponseEntity<UserDto>(singleUser,HttpStatus.OK);
	}
	/**
	 * @apiNote This API is used to getAllUser
	 * @return
	 */

	@GetMapping("/Users")
	public ResponseEntity<List<UserDto>> getAllUser() 
	{
		logger.info("Initiated request for Getting all user");
		List<UserDto> allUser = userServiceI.getAllUser();
		logger.info("Completed request for Getting all user");
		return new ResponseEntity<List<UserDto>>(allUser,HttpStatus.OK);
	}
	/**
	 *  @apiNote This API is used to updateUser
	 * @param userdto
	 * @param userId
	 * @return
	 */

	@PutMapping("/updateUser/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userdto,@PathVariable Long userId)
    {

		logger.info("Initiated request for Update the User details with userId:{}",userId);
		UserDto updateUser = userServiceI.updateUser(userdto, userId);
		logger.info("Completed request for user details with userId:{}",userId);
		return new ResponseEntity<UserDto>(updateUser,HttpStatus.CREATED);
	
	}
	/**
	 *  @apiNote This API is used to deleteUser
	 * @param userId
	 * @return
	 */

	@DeleteMapping("/deleteUser/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable Long userId)
	{
		logger.info("Initiated request for delete a user");
		userServiceI.deleteUser(userId);
		logger.info("Completed request for delete a user");
		return new ResponseEntity<String>("Delete successfully",HttpStatus.OK);
	}

}
	
