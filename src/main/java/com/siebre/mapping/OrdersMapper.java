package com.siebre.mapping;

import java.util.List;

import com.siebre.entity.Orders;

public interface OrdersMapper {
	public void insertOrders(Orders orders); 
	public List<Orders> getOrders(int id); //����order id
	public List<Orders> getOrdersById(int customerId); //����customerId���N�������
}
