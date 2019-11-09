package com.brick.assessment;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.brick.order.Order;
import com.brick.order.Controller.OrderController;
import com.brick.order.Service.OrderService;
@RunWith(SpringRunner.class)
@WebMvcTest(value=OrderController.class,secure=false)
public class OrderControllerTest {
  
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private OrderService OrderService;
	
	Order order=new Order(1,20);
	Order order2=new Order(2,30);
	Order order3=new Order(3,40);
	
	List orders=new ArrayList();
	
	@Test
	public void createOrder() throws Exception{
		String content="{\"order_id\":\"1\",\"bricks_count\":\"20\"}";
		Mockito.when(OrderService.createOrder(Mockito.any(Order.class))).thenReturn(order);
		RequestBuilder reqBuild=MockMvcRequestBuilders.post("/createOrder").accept(MediaType.APPLICATION_JSON).content(content).contentType(MediaType.APPLICATION_JSON);
		MvcResult result=mockMvc.perform(reqBuild).andReturn();
		MockHttpServletResponse response=result.getResponse();
		assertEquals(HttpStatus.CREATED.value(),response.getStatus());
	}
	
	@Test
	public void getOrder() throws Exception{
		
		Mockito.when(OrderService.getOrders(Mockito.anyInt())).thenReturn(order);
		RequestBuilder reqBuild=MockMvcRequestBuilders.get("/getOrder?id=1").accept(MediaType.APPLICATION_JSON);
		MvcResult result=mockMvc.perform(reqBuild).andReturn();
		System.out.println(result.getResponse());
		String expected="{order_id:1,bricks_count:20}";
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(),false);
	}
	
	
	@Test
	public void getOrders() throws Exception{
		orders.add(order);
		orders.add(order2);
		orders.add(order3);
		Mockito.when(OrderService.getOrders()).thenReturn(orders);
		RequestBuilder reqBuild=MockMvcRequestBuilders.get("/getOrders").accept(MediaType.APPLICATION_JSON);
		MvcResult result=mockMvc.perform(reqBuild).andReturn();
		System.out.println(result.getResponse());
		String expected="[{order_id:1,bricks_count:20},{order_id:2,bricks_count:30},{order_id:3,bricks_count:40}]";
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(),false);
	}
}
