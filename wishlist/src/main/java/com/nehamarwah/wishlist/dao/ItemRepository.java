package com.nehamarwah.wishlist.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.nehamarwah.wishlist.model.Item;

public interface ItemRepository extends CrudRepository<Item, Long>{
	
	@Query("select item from Wishlist w where w.user.id = :userId")
	List<Item> findUsersWishList(Long userId);
	
}
