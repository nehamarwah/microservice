package com.nehamarwah.itemsonsale.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class RatedItems {

	private List<Item> items;

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
}
