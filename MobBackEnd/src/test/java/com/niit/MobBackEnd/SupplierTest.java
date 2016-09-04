package com.niit.MobBackEnd;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.MobBackEnd.dao.SupplierDao;
import com.niit.MobBackEnd.model.Supplier;

public class SupplierTest {
	public static void main(String[] args) {
		
	
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	context.scan("com.niit.*");
	context.refresh();
	SupplierDao sup=(SupplierDao) context.getBean("supplierDao");
	Supplier s=(Supplier) context.getBean("supplier");
	s.setId("co1");
	s.setName("Olay");
	s.setAddress("bangalore");
	
	sup.saveOrUpdate(s);
	
	List<Supplier>  list =    sup.list();
	
	for(Supplier cat : list)
	{
		System.out.println(cat.getId()  + ":" +  cat.getName() + ":" + cat.getAddress());
	}
	}
}
