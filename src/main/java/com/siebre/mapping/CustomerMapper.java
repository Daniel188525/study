package com.siebre.mapping;

import com.siebre.entity.Customer;

public interface CustomerMapper {
	public void insertCustomer(Customer customer); 
	public Customer getCustomer(int id); 
}
