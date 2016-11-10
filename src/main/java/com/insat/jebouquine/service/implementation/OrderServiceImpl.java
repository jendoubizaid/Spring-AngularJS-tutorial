package com.insat.jebouquine.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.insat.jebouquine.jsonbean.Cart;
import com.insat.jebouquine.repository.entities.Order;
import com.insat.jebouquine.repository.entities.User;
import com.insat.jebouquine.repository.facade.IOrderRepository;
import com.insat.jebouquine.service.facade.IOrderService;
@Service("orderService")
@Transactional
public class OrderServiceImpl implements IOrderService{

	@Autowired
	IOrderRepository orderDao;
	@Override
	public Order saveOrder(Cart cart, User c, String deliveryAdress) {
		return orderDao.saveOrder(cart, c, deliveryAdress);
	}
}
