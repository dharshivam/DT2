package com.niit.MobBackEnd.dao;

import java.util.List;

import com.niit.MobBackEnd.model.Product;

public interface ProductDao {
	
	public List<Product> list();
    
	public Product getPro(String id);

	public void saveOrUpdate(Product product);

	public void delete(String id);

}
