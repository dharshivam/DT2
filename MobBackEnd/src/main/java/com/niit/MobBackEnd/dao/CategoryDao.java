package com.niit.MobBackEnd.dao;

import java.util.List;

import com.niit.MobBackEnd.model.Category;
import com.niit.MobBackEnd.model.Product;

public interface CategoryDao {

	public List<Category> list();
	
	public Category get(String id);

	public void saveOrUpdate(Category category);

	public void delete(String id);

}
