package com.nehamarwah.itemsonsale.dao;

import org.springframework.data.repository.CrudRepository;

import com.nehamarwah.itemsonsale.model.Item;

public interface ItemRepository extends CrudRepository<Item, Long>{

}
