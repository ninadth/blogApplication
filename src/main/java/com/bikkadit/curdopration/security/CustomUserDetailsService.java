package com.bikkadit.curdopration.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.bikkadit.curdopration.dao.UserRepository;
import com.bikkadit.curdopration.exceptionhandling.ResourceNotFoundException;
import com.bikkadit.curdopration.model.User;

@Component
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// loading user from database by using username
		User user = this.userRepo.findByuserEmail(username)
				.orElseThrow(() -> new ResourceNotFoundException("User", "userEmail :" +username, 0));
		return user;
	}

}