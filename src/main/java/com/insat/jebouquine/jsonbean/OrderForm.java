package com.insat.jebouquine.jsonbean;

import java.util.ArrayList;
import java.util.List;

public class OrderForm {
	private List<OrderRaw> orderRawList;	

	public List<OrderRaw> getOrderRawList() {
		return orderRawList;
	}

	public void setOrderRawList(List<OrderRaw> orderRawList) {
		this.orderRawList = orderRawList;
	}

	public OrderForm() {
		super();
		orderRawList=new ArrayList<OrderRaw>();
	}
	
}
