package com.nehamarwah.wishlist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nehamarwah.wishlist.model.Item;
import com.nehamarwah.wishlist.service.WishlistService;

@RestController
public class WishlistController {

	@Autowired
	WishlistService wishlistService;
	
	@RequestMapping(value = "/wishlist/{userId}")
    public List<Item> getUserWishlist(@PathVariable Long userId) {
        return wishlistService.getUserWishlist(userId);
    }
}
