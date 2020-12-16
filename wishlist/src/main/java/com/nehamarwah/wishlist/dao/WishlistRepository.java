package com.nehamarwah.wishlist.dao;

import org.springframework.data.repository.CrudRepository;

import com.nehamarwah.wishlist.model.Wishlist;

public interface WishlistRepository extends CrudRepository<Wishlist, Long>{
	
}
