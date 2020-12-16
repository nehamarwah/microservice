package com.nehamarwah.itemsonsale.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nehamarwah.itemsonsale.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByUsername(String username);

}
