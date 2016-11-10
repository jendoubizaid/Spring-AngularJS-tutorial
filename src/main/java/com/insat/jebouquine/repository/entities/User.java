package com.insat.jebouquine.repository.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class User {
	@Id
	private String login;
	private String nom;
	private String prenom;
	private String email;
	private String passwd;
	
	@JsonIgnore
	@OneToMany(mappedBy="user")
	private Collection<Order>orders=new ArrayList<Order>();
	
	@JsonIgnore
	@ManyToMany
	List<Role>roles=new ArrayList<Role>();
	
	
	public User() {
		super();
	}
	public User(String nom, String prenom, String email, String passwd, String login) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.passwd = passwd;
		this.login = login;
	}
	
	
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public Collection<Order> getOrders() {
		return orders;
	}
	public void setOrders(Collection<Order> orders) {
		this.orders = orders;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	
	
}
