package com.brick.order.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.brick.order.Order;
import com.brick.order.DAO.OrderDao;

@Component
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;
	
	public Order createOrder(Order order) {
		Order createdOrder=orderDao.createOrder(order);
		return createdOrder;
	}
	
	public Order getOrders(int id) {
		Order order=orderDao.getOrders(id);
		return order;
	}
	
	public List getOrders() {
		List orders=orderDao.getOrders();
		return orders;
	}
}
