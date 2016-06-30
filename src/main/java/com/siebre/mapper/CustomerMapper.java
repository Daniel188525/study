package com.siebre.mapper;

import com.siebre.entity.Customer;

public interface CustomerMapper {
	public void insertCustomer(Customer customer); 
	public Customer getCustomer(int id); 
}
