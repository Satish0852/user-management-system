package com.example.onlinelms.usermanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "ROLES")
public class UserRoles {
	private long id;
	private String name;
	public UserRoles() {

	}
	public UserRoles(long id, String name) {
		this.id = id;
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "UserRoles [id=" + id + ", name=" + name + "]";
	}
	
}
