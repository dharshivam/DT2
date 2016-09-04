package com.niit.MobBackEnd;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.MobBackEnd.dao.UserDao;
import com.niit.MobBackEnd.model.Users;

public class UserTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.MobBackEnd");
		context.refresh();
//		UserDao userDao=(UserDao) context.getBean("userDao");
//		Users user=(Users) context.getBean("users");
//		System.out.println("hello");
//		user.setUser_id("nmit");
//		user.setPassword("nmit");
//		user.setUrole("admin");
//		
//		userDao.saveOrUpdate(user);
		/*user=userDao.getValidate("nmit");
		System.out.println(user.getUrole());
		System.out.println(userDao.list().size());*/
		
		
	}

}
