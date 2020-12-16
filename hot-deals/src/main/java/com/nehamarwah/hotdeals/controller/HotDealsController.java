package com.nehamarwah.hotdeals.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nehamarwah.hotdeals.model.Item;
import com.nehamarwah.hotdeals.service.HotDealsService;

@RestController
public class HotDealsController {

	@Autowired
	HotDealsService hotDealsService;
	
	@RequestMapping(value = "/hotdeals/{userId}")
    public List<Item> getHotDeals(@PathVariable Long userId) {
        return hotDealsService.getHotDeals(userId);
    }
}
