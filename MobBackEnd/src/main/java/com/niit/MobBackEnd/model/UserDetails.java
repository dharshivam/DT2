package com.niit.MobBackEnd.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="USERDETAILS")
@Component
public class UserDetails {
	
	@Id
	private String user_id;
	private String name;
	private String contact_No;
	private String address;
	private String mail_id;
	private String password;
	/*@JoinColumn(name="mail_Id")
	private Users mail_Id;
	public Users getMail_Id() {
		return mail_Id;
	}
	public void setMail_Id(Users mail_Id) {
		this.mail_Id = mail_Id;
	}
	public Users getPassword() {
		return password;
	}
	public void setPassword(Users password) {
		this.password = password;
	}
	private Users password;*/
	
	
	
	public String getMail_id() {
		return mail_id;
	}
	public void setMail_id(String mail_id) {
		this.mail_id = mail_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact_No() {
		return contact_No;
	}
	public void setContact_No(String contact_No) {
		this.contact_No = contact_No;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
