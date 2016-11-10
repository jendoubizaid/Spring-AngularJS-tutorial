package com.insat.jebouquine.repository.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Role {
	@Id
	String role;
	
	

	public Role() {
		super();
	}

	public Role(String role) {
		super();
		this.role = role;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	

}
