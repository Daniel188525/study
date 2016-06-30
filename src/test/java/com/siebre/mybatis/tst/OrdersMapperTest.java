package com.siebre.mybatis.tst;

import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.siebre.config.AppConfig;
import com.siebre.entity.Customer;
import com.siebre.entity.Orders;
import com.siebre.log4j.JUnit4ClassRunner;
import com.siebre.mapper.CustomerMapper;
import com.siebre.mapper.OrdersMapper;

@RunWith(JUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class OrdersMapperTest {

	protected final Log log = LogFactory.getLog(getClass());

	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	private SqlSession session = null;

	@Autowired
	private CustomerMapper customerMapper;

	@Autowired
	private OrdersMapper ordersMapper;

	@Before
	public void before() {
		session = sqlSessionFactory.openSession();
		log.debug("get customerMapper is " + customerMapper);
		log.debug("get ordersMapper is " + ordersMapper);
	}

//	@Test
	public void insertOrderTest() {
		Orders order = new Orders();
		String orderCode = UUID.randomUUID().toString().replaceAll("-", "");
		log.debug("orders code is" + orderCode + " and its size is "
				+ orderCode.length());
		order.setCode(orderCode);
		order.setCustomerId(1);

		ordersMapper.insertOrders(order);
		session.commit();
	}

//	@Test
	public void testInsertCustomerOneToMany() {
		Customer customer = new Customer();
		customer.setCname("Daniel");
		customer.setPostcode("518105");
		customer.setSex("男");
		customer.setAddress("北京市西城区宣武门西大街");

		customerMapper.insertCustomer(customer);
		log.debug("insert customer id is " + customer.getId());

		Orders orders1 = new Orders();
		orders1.setCode("code__5_1");
		orders1.setCustomerId(customer.getId());

		Orders orders2 = new Orders();
		orders2.setCode("code__5_2");
		orders2.setCustomerId(customer.getId());

		Orders orders3 = new Orders();
		orders3.setCode("code__5_3");
		orders3.setCustomerId(customer.getId());

		ordersMapper.insertOrders(orders1);
		ordersMapper.insertOrders(orders2);
		ordersMapper.insertOrders(orders3);

		session.commit();
	}
	
	@Test 
	public void testGetCustomerOneToMany(){ 
		Customer customer = customerMapper.getCustomer(4);
		List<Orders> orders = customer.getOrders();
		for (Orders order: orders) {
			log.debug(order);
		}
	}
	
	@After
	public void closeSession() {
		session.close();
	}
}
