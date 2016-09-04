package com.niit.MobBackEnd.dao;

import java.util.List;

import com.niit.MobBackEnd.model.Supplier;

public interface SupplierDao {
	public List<Supplier> list();
	
	public void saveOrUpdate(Supplier supplier);
	
	public Supplier get(String id);
	
	public void delete(String id);


}
