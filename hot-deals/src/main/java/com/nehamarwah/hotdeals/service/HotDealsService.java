package com.nehamarwah.hotdeals.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nehamarwah.hotdeals.dao.ItemRepository;
import com.nehamarwah.hotdeals.model.Item;

@Service
public class HotDealsService {

	@Autowired
	ItemRepository itemRepository;

	public List<Item> getHotDeals(Long userId) {
		List<Item> hotdealsList = itemRepository.findItemsHotDeals(userId);
		return hotdealsList;
	}
}
