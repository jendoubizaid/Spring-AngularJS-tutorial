package com.insat.jebouquine.service.facade;

import com.insat.jebouquine.jsonbean.Cart;
import com.insat.jebouquine.repository.entities.Order;
import com.insat.jebouquine.repository.entities.User;

public interface IOrderService {
	public Order saveOrder(Cart cart, User c,String deliveryAdress);
}
