package com.nehamarwah.itemsonsale.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nehamarwah.itemsonsale.model.Item;
import com.nehamarwah.itemsonsale.model.RatedItems;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class DealsInfoService {

	@Autowired
	RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "getFallbackHotDeals", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000") })

	public List<Item> getHotDeals(Long userId) {
		RatedItems hotDeals = restTemplate.getForObject("https://hotdeals-service/hotdeals/" + userId,
				RatedItems.class);
		return hotDeals.getItems();
	}

	public List<Item> getFallbackHotDeals(Long userId) {
		return Arrays.asList(new Item("Item 3 Title", "Item 3 Description"));
	}
}
