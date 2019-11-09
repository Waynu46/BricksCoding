package com.brick.order;

import java.util.List;

public interface OrderService {
	public Order createOrder(Order order);
	public Order getOrders(int id);
	public List getOrders();
}
