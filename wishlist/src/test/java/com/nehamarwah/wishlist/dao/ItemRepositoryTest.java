package com.nehamarwah.wishlist.dao;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.nehamarwah.wishlist.model.Item;
import com.nehamarwah.wishlist.model.Review;
import com.nehamarwah.wishlist.model.User;
import com.nehamarwah.wishlist.model.Wishlist;

@Transactional
@SpringBootTest
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private WishlistRepository wishlistRepository;
    @Test
    public void shouldReturnWishlistItems() {
    	prepareData();
        assertThat(itemRepository.findUsersWishList(1L)).hasSize(15);
    }

    public void prepareData() {
        User user = new User("test");
        Wishlist wishlist = new Wishlist();
        user.setId(1l);
        userRepository.save(user);
        wishlist.setUser(user);
        List<Item> items = new ArrayList<Item>();
        for (int i = 0; i < 15; i++) {
            Item item = new Item("title " + i, "description");
            item.addReview(new Review(Math.min(i, 10), "Review " + i + "/1", user));
            itemRepository.save(item);
            items.add(item);
        } 
        wishlist.setItem(items);
        wishlistRepository.save(wishlist);
    }
}