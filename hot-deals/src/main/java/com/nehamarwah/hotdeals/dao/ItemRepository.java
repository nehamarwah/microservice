package com.nehamarwah.hotdeals.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.nehamarwah.hotdeals.model.Item;

public interface ItemRepository extends CrudRepository<Item, Long>{

	@Query("select distinct(item) from Item item join item.reviews r where r.author.id != :userId group by item.id order by AVG(Coalesce(r.rating, 0))")
    List<Item> findItemsHotDeals(Long userId);
}
