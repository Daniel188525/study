package com.siebre.mybatis.tst;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.siebre.config.AppConfig;
import com.siebre.entity.User;
import com.siebre.log4j.JUnit4ClassRunner;
import com.siebre.service.UserService;

@RunWith(JUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class TestCRUDByAnnotationMapper {

	protected final Log log = LogFactory.getLog(getClass());
	
	@Autowired
	private UserService userService;
	
	@Test
    public void testAdd(){
        User user = new User();
        user.setName("用户xdp03");
        user.setAge(20);
        int add = userService.addUser(user);
        log.debug("add user result " + add);
    }
    
    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(new Long(3));
        user.setName("孤傲苍狼_xdp");
        user.setAge(26);
        //执行修改操作
        int retResult = userService.updateUser(user);
        log.debug("update user result " + retResult);
    }
    
    @Test
    public void testDelete(){
        //执行删除操作
        int retResult = userService.deleteUserById(7);
        log.debug("delete user result " + retResult);
    }
    
    @Test
    public void testGetUser(){
        //执行查询操作，将查询结果自动封装成User返回
        User user = userService.getUserById(8);
        log.debug("get user result " + user);
    }
    
    @Test
    public void testGetAll(){
        //执行查询操作，将查询结果自动封装成List<User>返回
        List<User> lstUsers = userService.getAllUsers();
        log.debug("get all users " + lstUsers);
    }
}
