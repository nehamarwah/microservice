package com.nehamarwah.wishlist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nehamarwah.wishlist.dao.ItemRepository;
import com.nehamarwah.wishlist.model.Item;

@Service
public class WishlistService {

	@Autowired
	ItemRepository itemRepository;
	
	
	public List<Item> getUserWishlist(Long userId) {
		List<Item> wishList = itemRepository.findUsersWishList(userId);
		return wishList;
	}

}
