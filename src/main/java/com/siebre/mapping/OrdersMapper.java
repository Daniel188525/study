package com.siebre.mapping;

import java.util.List;

import com.siebre.entity.Orders;

public interface OrdersMapper {
	public void insertOrders(Orders orders); 
	public List<Orders> getOrders(int id); //根据order id
	public List<Orders> getOrdersById(int customerId); //根据customerId获得N多个对象
}
