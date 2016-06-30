package com.siebre.mybatis.tst;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.siebre.config.DatabaseConfig;
import com.siebre.config.MyBatisXmlConfig;
import com.siebre.config.PropertySourceConfig;
import com.siebre.entity.Customer;
import com.siebre.log4j.JUnit4ClassRunner;
import com.siebre.mapper.CustomerMapper;
import com.siebre.mapper.OrdersMapper;

@RunWith(JUnit4ClassRunner.class)
@ContextConfiguration(classes = { 
		PropertySourceConfig.class, 
		DatabaseConfig.class, 
		MyBatisXmlConfig.class 
		}
)
public class TestCRUDByXMLMapper {

	protected final Log log = LogFactory.getLog(getClass());
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	private SqlSession session=null; 
	
	private CustomerMapper customerMapper = null;
	
	private OrdersMapper ordersMapper = null;
	
	/**
	 * init mapper
	 */
	@Before
	public void before() {
		session = sqlSessionFactory.openSession();
		
		// 注册mapper
//		sqlSessionFactory.getConfiguration().addMapper(CustomerMapper.class);
//		sqlSessionFactory.getConfiguration().addMapper(OrdersMapper.class);
		
		//获取mapper
		customerMapper = session.getMapper(CustomerMapper.class);
		ordersMapper = session.getMapper(OrdersMapper.class);
		
		log.debug("get customerMapper is " + customerMapper);
		log.debug("get ordersMapper is " + ordersMapper);
	}
	
	@Test
    public void testAdd(){
		Customer customer = new Customer();
		customer.setPostcode("100000");
		customer.setAddress("长椿街");
		customer.setSex("M");
		customer.setCname("赵日天");
		
		customerMapper.insertCustomer(customer);
		session.commit();
    }
    
    //@Test
    public void testUpdate(){
    }
    
    //@Test
    public void testDelete(){
    }
    
    //@Test
    public void testGetUser(){
    }
    
    //@Test
    public void testGetAll(){
    }
}
