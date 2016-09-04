package com.niit.MobBackEnd.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="USERINFO")
@Component
public class Users {
	
	@Id
	private String userid;
	private String username;
	private String password;
	private String urole;
	
	public Users(){}
	public Users(String userid, String username, String password, String urole) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.urole = urole;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUrole() {
		return urole;
	}
	public void setUrole(String urole) {
		this.urole = urole;
	}
	
	
	
	
	
	

}
