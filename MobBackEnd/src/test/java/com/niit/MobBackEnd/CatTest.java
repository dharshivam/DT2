package com.niit.MobBackEnd;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.MobBackEnd.dao.CartDao;
import com.niit.MobBackEnd.dao.CategoryDao;
import com.niit.MobBackEnd.dao.SupplierDao;
import com.niit.MobBackEnd.model.Cart;
import com.niit.MobBackEnd.model.Category;


public class CatTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		
		Cart cart=(Cart) ctx.getBean("cart");
		CartDao cartdao=(CartDao) ctx.getBean("cartDao");
		cart.setCart_id("101");
		cart.setPname("AAA");
		cart.setPrice("222");
		cart.setStat("Y");
		cart.setUser_id("33");
		cartdao.SaveOrUpdate(cart);
		
		
	}
	
}
