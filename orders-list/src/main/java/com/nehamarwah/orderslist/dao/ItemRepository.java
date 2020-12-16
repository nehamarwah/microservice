package com.nehamarwah.orderslist.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.nehamarwah.orderslist.model.Item;

public interface ItemRepository extends CrudRepository<Item, Long> {

	@Query("select item from Item item join item.reviews r where r.author.id= :userId order by r.rating desc")
	List<Item> findUserOrderList(Long userId);
}
