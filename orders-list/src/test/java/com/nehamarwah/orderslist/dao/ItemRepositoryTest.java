package com.nehamarwah.orderslist.dao;

import static org.assertj.core.api.Assertions.assertThat;

import org.aspectj.lang.annotation.Before;
import org.assertj.core.internal.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.nehamarwah.orderslist.model.Item;
import com.nehamarwah.orderslist.model.Review;
import com.nehamarwah.orderslist.model.User;

@Transactional
@SpringBootTest
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void shouldReturnOrderListItems() {
    	prepareData();
        assertThat(itemRepository.findUserOrderList(1L)).hasSize(15);
    }

    public void prepareData() {
        User user = new User("test");
        user.setId(1l);
        userRepository.save(user);
        for (int i = 0; i < 15; i++) {
            Item item = new Item("title " + i, "description");
            item.addReview(new Review(Math.min(i, 10), "Review " + i + "/1", user));
            itemRepository.save(item);
        }
    }
}