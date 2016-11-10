package com.insat.jebouquine.repository.facade;
import com.insat.jebouquine.jsonbean.Cart;
import com.insat.jebouquine.repository.entities.Order;
import com.insat.jebouquine.repository.entities.User;



public interface IOrderRepository {
	public Order saveOrder(Cart cart, User c,String deliveryAdress);

}
