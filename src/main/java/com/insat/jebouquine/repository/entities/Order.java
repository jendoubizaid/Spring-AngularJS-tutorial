package com.insat.jebouquine.repository.entities;

import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "Command")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long numOrder;
	private String deliveryAdress;
	private double amount;
	@JsonIgnore
	@ManyToOne
	private User user;
	@JsonIgnore
	@OneToMany(mappedBy="order")
	private Collection<CommandLine>commandeLines;
	
	public Collection<CommandLine> getCommandeLines() {
		return commandeLines;
	}
	public void setCommandeLines(Collection<CommandLine> commandeLines) {
		this.commandeLines = commandeLines;
	}
	public Long getNumOrder() {
		return numOrder;
	}
	public void setNumOrder(Long numOrder) {
		this.numOrder = numOrder;
	}
	public String getDeliveryAdress() {
		return deliveryAdress;
	}
	public void setDeliveryAdress(String deliveryAdress) {
		this.deliveryAdress = deliveryAdress;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
