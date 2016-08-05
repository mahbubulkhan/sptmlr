package com.stmblr.domain;

import javax.persistence.Entity;

import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class User extends AbstractDomainClass{
	
	
	
	@NotEmpty
	private String name;
	
	@NotEmpty
	@Transient
	private String password;
	
	private String encryptedPassword;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return id;
	}
	@Override
	public void setId(Integer id) {
		// TODO Auto-generated method stub
		this.id  = id;
	}
	
	public String getEncryptedPassword() {
		return encryptedPassword;
	}
	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}
	
	

}
