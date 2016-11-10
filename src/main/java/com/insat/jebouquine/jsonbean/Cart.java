package com.insat.jebouquine.jsonbean;


import java.util.HashMap;
import java.util.Map;

import com.insat.jebouquine.repository.entities.Book;
import com.insat.jebouquine.repository.entities.CommandLine;


public class Cart {

	private Map<String, CommandLine> items = new HashMap<String, CommandLine>();

	public void addItem(Book b, int quantite) {
		CommandLine cl = items.get(b.getIsbn());
		if (cl == null) {
			CommandLine art = new CommandLine();
			art.setBook(b);;
			art.setQuantite(quantite);
			art.setPrix(b.getPrice()*quantite);
			items.put(b.getIsbn(), art);
		} else {
			cl.setQuantite(cl.getQuantite() + quantite);
		}
	}
	

	public Map<String, CommandLine> getItems() {
		return items;
	}


	public void setItems(Map<String, CommandLine> items) {
		this.items = items;
	}


	public int getSize() {
		return items.size();
	}

	public float getTotal() {
		float total = 0;
		for (CommandLine cl : items.values()) {
			total += cl.getPrix();
		}
		System.out.println("total: "+total);
		return total;
	}

	public void deleteItem(String ISBN) {
		items.remove(ISBN);
	}
	public void deleteAllItem(){
		items.clear();
	}

}
