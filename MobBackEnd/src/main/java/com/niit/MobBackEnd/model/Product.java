package com.niit.MobBackEnd.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="PRODUCTS")
@Component

public class Product {
	
	@Id
	private String pid;
	private String pname;
	private String pcat;
	private String pprice;
	private String pstock;
	private String pdes;
	private String supplier;
	
	@Transient
	private MultipartFile img;
	
	
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	
	
	
	public String getPcat() {
		return pcat;
	}
	public void setPcat(String pcat) {
		this.pcat = pcat;
	}
	
	public String getPstock() {
		return pstock;
	}
	public void setPstock(String pstock) {
		this.pstock = pstock;
	}
	
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPdes() {
		return pdes;
	}
	public void setPdes(String pdes) {
		this.pdes = pdes;
	}
	public String getPprice() {
		return pprice;
	}
	public void setPprice(String pprice) {
		this.pprice = pprice;
	}
	public MultipartFile getImg() {
		return img;
	}
	public void setImg(MultipartFile img) {
		this.img = img;
	}

}
