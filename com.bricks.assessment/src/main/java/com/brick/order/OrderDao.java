package com.brick.order;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDao {
	/*
	 * Since not connecting to DataBase,declared static orders list and respective count (Class level Variables)
	 */
	
	private static List<Order> orders = new ArrayList<Order>();
	public static int ordercount=3;
	static {
		orders.add(new Order(1, 143));
		orders.add(new Order(2, 243));
		orders.add(new Order(3, 343));
	}
	
	/*
	 * Generating Unique order ID based on the available count and returning created order with respective details
	 */
	
	public Order createOrder(Order order) {
			if(order.getOrder_id()==null) {
				order.setOrder_id(++ordercount);
			}
				orders.add(order);
		 return order;
	}
	
	/*
	 * Retrieving orders details based on the order id provided,if nothing found returning null and handling custom exception in Controller
	 */
	
	public Order getOrders(int id) {
		for(Order order :orders) {
			if(id==order.getOrder_id()) return order;
		}
		return null;
	}
	
	/*
	 * Retrieving all the available orders details,if nothing found returning null and handling custom exception in Controller
	 */
	
	public List getOrders() {
		return orders;
	}
}
