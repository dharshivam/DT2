package com.niit.MobBackEnd.dao;

import java.util.List;

import com.niit.MobBackEnd.model.UserDetails;
import com.niit.MobBackEnd.model.Users;

public interface UserDao {
	
public List<Users> list();
    
	public void saveOrUpdateUsers(Users users);

	public void delete(String id);
	
	public void saveOrUpdate(UserDetails userDetails);
	
	public boolean isValidUser(String id, String pwd);
	
	Users getValidate(String s1);

}
