package com.siebre.entity;

import java.io.Serializable;

public class Orders implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8754141863074696149L;
	
	private int id;
	
	private String code;
	
	private int customerId;
	
	private Customer customer; // 多个Orders对应一个Customer

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	@Override
	public String toString() {
		return "order[id= " + id + ", code=" + code + ", customerId=" + customerId + "]";
	}
}
