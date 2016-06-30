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
        user.setName("�û�xdp03");
        user.setAge(20);
        int add = userService.addUser(user);
        log.debug("add user result " + add);
    }
    
    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(new Long(3));
        user.setName("�°�����_xdp");
        user.setAge(26);
        //ִ���޸Ĳ���
        int retResult = userService.updateUser(user);
        log.debug("update user result " + retResult);
    }
    
    @Test
    public void testDelete(){
        //ִ��ɾ������
        int retResult = userService.deleteUserById(7);
        log.debug("delete user result " + retResult);
    }
    
    @Test
    public void testGetUser(){
        //ִ�в�ѯ����������ѯ����Զ���װ��User����
        User user = userService.getUserById(8);
        log.debug("get user result " + user);
    }
    
    @Test
    public void testGetAll(){
        //ִ�в�ѯ����������ѯ����Զ���װ��List<User>����
        List<User> lstUsers = userService.getAllUsers();
        log.debug("get all users " + lstUsers);
    }
}
