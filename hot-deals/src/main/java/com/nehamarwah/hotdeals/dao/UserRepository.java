package com.nehamarwah.hotdeals.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nehamarwah.hotdeals.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByUsername(String username);

}
