package com.bikkadit.curdopration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bikkadit.curdopration.exceptionhandling.ApiException;
import com.bikkadit.curdopration.helper.AppConstant;
import com.bikkadit.curdopration.helper.JwtAuthRequest;
import com.bikkadit.curdopration.helper.JwtAuthResponse;
import com.bikkadit.curdopration.payload.UserDto;
import com.bikkadit.curdopration.security.JwtTokenHelper;
import com.bikkadit.curdopration.service.UserServiceI;


@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
	@Autowired
	private JwtTokenHelper jwtTokenHelper;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserServiceI userServiceI;

	@PostMapping("/login")
	public ResponseEntity<JwtAuthResponse> createToken(@RequestBody JwtAuthRequest request) throws Exception {

		this.authenticate(request.getUsername(), request.getPassword());

		UserDetails userDetails = this.userDetailsService.loadUserByUsername(request.getUsername());

		String token = this.jwtTokenHelper.generateToken(userDetails);

		JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
		jwtAuthResponse.setToken(token);
		return new ResponseEntity<JwtAuthResponse>(jwtAuthResponse, HttpStatus.OK);
	}

	private void authenticate(String username, String passsword) throws Exception {

		UsernamePasswordAuthenticationToken userPasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
				username, passsword);

		try {
			this.authenticationManager.authenticate(userPasswordAuthenticationToken);
		} catch (BadCredentialsException b) {
			System.out.println(AppConstant.INVALID);
			throw new ApiException(AppConstant.DETAILS);
		}
	}

	@PostMapping("/register")
	public ResponseEntity<UserDto> registerNewUser(@RequestBody UserDto userDto) {

		UserDto newUser = this.userServiceI.registerNewUser(userDto);

		return new ResponseEntity<UserDto>(newUser, HttpStatus.CREATED);
	}
}
