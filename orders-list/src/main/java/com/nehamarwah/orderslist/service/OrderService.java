package com.nehamarwah.orderslist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nehamarwah.orderslist.dao.ItemRepository;
import com.nehamarwah.orderslist.model.Item;

@Service
public class OrderService {

	@Autowired
	ItemRepository itemRepository;

	public List<Item> getUserOrdersList(Long userId) {
		List<Item> ordersList = itemRepository.findUserOrderList(userId);
		return ordersList;
	}

}
