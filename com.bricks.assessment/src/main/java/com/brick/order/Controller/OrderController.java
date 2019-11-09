package com.brick.order.Controller;

import java.net.URI;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.brick.order.Order;
import com.brick.order.Exception.OrderNotFoundException;
import com.brick.order.Service.OrderService;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@Value("${custom.message}")
	private String message;
	
	/*
	 * Creating the Orders with Order object as provided
	 * Returning path of the created order ID using Components builder
	 * Validating number of bricks(refer Order.java) and sending appropriate message on failure
	 */
	
	@PostMapping("/createOrder")
	public ResponseEntity<Object> addUser(@Valid @RequestBody Order order) {
		Order createOrder= orderService.createOrder(order);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(createOrder.getOrder_id()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	/*
	 * Fetching Order Details based on the Order ID provided
	 * RequestParam(Query Param from URI, can also do with path Variable)
	 * Used customised Exception handler with respective Response status
	 */
	
	@GetMapping("/getOrder")
	public Order getOrder(@RequestParam int id) {
		Order order=orderService.getOrders(id);
		if(order==null) {
			throw new OrderNotFoundException(message+" with provided order ID:"+id+" ,Please verify with appropriate Order ID");
		}
		return order;
	}
	
	/*
	 * Fetching all the available order Details
	 */
	@GetMapping("/getOrders")
	public List getOrders() {
		List orders= orderService.getOrders();
		if(orders==null) {
			throw new OrderNotFoundException(message);
		}
		return orders;
	}
}
