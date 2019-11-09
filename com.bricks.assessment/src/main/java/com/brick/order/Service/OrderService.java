package com.brick.order.Service;

import java.util.List;

import com.brick.order.Order;

public interface OrderService {
	public Order createOrder(Order order);
	public Order getOrders(int id);
	public List getOrders();
}
