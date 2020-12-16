package com.nehamarwah.hotdeals.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Wishlist {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	private User user;
	
	@OneToMany
	private List<Item> item;
	
	public Wishlist() {
		
	}
}
