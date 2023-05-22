package com.bikkadit.curdopration.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bikkadit.curdopration.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByuserEmail(String userEmail);
}
