package com.nehamarwah.orderslist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nehamarwah.orderslist.model.Item;
import com.nehamarwah.orderslist.service.OrderService;


@RestController
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@RequestMapping(value = "/orders/{userId}")
    public List<Item> getUserOrdersList(@PathVariable Long userId) {
        return orderService.getUserOrdersList(userId);
    }
}
