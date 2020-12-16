package com.nehamarwah.wishlist.model;

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
	
	User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	List<Item> getItem() {
		return item;
	}

	public void setItem(List<Item> item) {
		this.item = item;
	}

	@OneToMany
	private List<Item> item;
	
	public Wishlist() {
		
	}
}
