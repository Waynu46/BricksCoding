package com.brick.order;

import java.math.BigDecimal;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Value;

public class Order {

	private Integer order_id;
	@Range(min=1,message="Value should be greater than 0")
	private Integer bricks_count ;
	
    public Order() {
		
	}
	public Order(Integer order_id, Integer bricks_count) {
		super();
		this.order_id = order_id;
		this.bricks_count = bricks_count;
	}
	
	public Integer getBricks_count() {
		return bricks_count;
	}
	public void setBricks_count(Integer bricks_count) {
		this.bricks_count = bricks_count;
	}
	public Integer getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}
}
