package com.nehamarwah.itemsonsale.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.google.common.collect.Iterables;
import com.nehamarwah.itemsonsale.model.Item;
import com.nehamarwah.itemsonsale.service.DealsInfoService;
import com.nehamarwah.itemsonsale.service.ItemService;
import com.nehamarwah.itemsonsale.service.OrdersInfoService;
import com.nehamarwah.itemsonsale.service.WishlistInfoService;

@RestController
public class ItemController {

	@Autowired
	ItemService itemService;

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	OrdersInfoService ordersInfoService;

	@Autowired
	WishlistInfoService wishlistInfoService;

	@Autowired
	DealsInfoService dealsInfoService;

	@RequestMapping(value = "/recommendations/{userId}")
	public List<Item> getRecommendedItemsOnSale(@PathVariable Long userId) {
		List<Item> ordersList = ordersInfoService.getOrdersList(userId);
		List<Item> wishList = wishlistInfoService.getUserWishlist(userId);
		List<Item> dealsList = dealsInfoService.getHotDeals(userId);
		List<Item> result = removeDuplicateItems(ordersList, wishList, dealsList);
		return result;
	}

	/**
	 * This method removes the duplcate items which already appear in the previous list .
	 * @param ordersList
	 * @param wishList
	 * @param dealsList
	 * @return
	 */
	private List<Item> removeDuplicateItems(List<Item> ordersList, List<Item> wishList, List<Item> dealsList) {
		List<Item> intersection = new ArrayList<Item>(ordersList);
		intersection.retainAll(wishList);
		wishList.removeAll(intersection);

		List<Item> union = new ArrayList<Item>(ordersList);
		union.addAll(wishList);
		List<Item> intersectionDeals = new ArrayList<Item>(dealsList);
		intersectionDeals.retainAll(union);
		dealsList.removeAll(intersectionDeals);
		Iterable<Item> combinedIterables = Iterables
				.unmodifiableIterable(Iterables.concat(ordersList, wishList, dealsList));
		List<Item> result = StreamSupport.stream(combinedIterables.spliterator(), false).collect(Collectors.toList());
		return result;
	}
}
