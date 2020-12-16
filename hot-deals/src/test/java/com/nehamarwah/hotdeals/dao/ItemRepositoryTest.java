package com.nehamarwah.hotdeals.dao;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.nehamarwah.hotdeals.model.Item;
import com.nehamarwah.hotdeals.model.Review;
import com.nehamarwah.hotdeals.model.User;

public class ItemRepositoryTest {

	    @Autowired
	    private ItemRepository itemRepository;
	    @Autowired
	    private UserRepository userRepository;

	    @Test
	    public void shouldReturnItemsWithHotDeals() {
	    	prepareData();
	        assertThat(itemRepository.findItemsHotDeals(1L)).hasSize(10);
	    }

	    public void prepareData() {
	        User user = new User("test");
	        user.setId(2l);
	        userRepository.save(user);
	        for (int i = 0; i < 15; i++) {
	            Item item = new Item("title " + i, "description");
	            item.addReview(new Review(Math.min(i, 10), "Review " + i + "/1", user));
	            item.addReview(new Review(i < 10 ? i + 1 : 10, "Review " + i + "/2", user));
	            itemRepository.save(item);
	        }
	    }
}
