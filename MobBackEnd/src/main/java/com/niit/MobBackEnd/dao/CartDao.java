package com.niit.MobBackEnd.dao;

import java.util.List;

import com.niit.MobBackEnd.model.Cart;

public interface CartDao {

	public void SaveOrUpdate(Cart cart);
	
	public List<Cart> list();
	
	public void delete(String id);

	public Cart getCart(String id);

}
