package com.insat.jebouquine.repository.implementation;

import org.springframework.stereotype.Repository;

import com.insat.jebouquine.jsonbean.Cart;
import com.insat.jebouquine.repository.entities.CommandLine;
import com.insat.jebouquine.repository.entities.Order;
import com.insat.jebouquine.repository.entities.User;
import com.insat.jebouquine.repository.facade.GenericRepository;
import com.insat.jebouquine.repository.facade.IOrderRepository;
@Repository("orderRepository")
public class OrderRepositoryImpl extends GenericRepository<Long, Order> implements IOrderRepository{

	@Override
	public Order saveOrder(Cart cart, User c, String deliveryAdress) {
		User client = (User) getSession().get(User.class, c.getLogin());
		if (client == null) {
			getSession().save(c);
		}
		Order order = new Order();
		order.setUser(c);
		for (CommandLine lc : cart.getItems().values()) {
			lc.setOrder(order);
			getSession().save(lc);
		}
		order.setCommandeLines(cart.getItems().values());
		order.setAmount(cart.getTotal());
		order.setDeliveryAdress(deliveryAdress);
		getSession().save(order);
		return order;
	}
	
}
