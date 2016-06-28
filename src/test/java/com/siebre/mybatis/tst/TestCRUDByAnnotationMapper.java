package com.siebre.mybatis.tst;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.siebre.entity.User;
import com.siebre.mapping.UserMapper;
import com.siebre.util.MyBatisUtil;

public class TestCRUDByAnnotationMapper {

	@Test
    public void testAdd(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
        //�õ�UserMapper�ӿڵ�ʵ�������UserMapper�ӿڵ�ʵ���������sqlSession.getMapper(UserMapper.class)��̬��������
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setName("�û�xdp");
        user.setAge(20);
        int add = mapper.addUser(user);
        //ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
        sqlSession.close();
        System.out.println(add);
    }
    
    //@Test
    public void testUpdate(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
        //�õ�UserMapper�ӿڵ�ʵ�������UserMapper�ӿڵ�ʵ���������sqlSession.getMapper(UserMapper.class)��̬��������
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(new Long(3));
        user.setName("�°�����_xdp");
        user.setAge(26);
        //ִ���޸Ĳ���
        int retResult = mapper.updateUser(user);
        //ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
        sqlSession.close();
        System.out.println(retResult);
    }
    
    //@Test
    public void testDelete(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
        //�õ�UserMapperI�ӿڵ�ʵ�������UserMapperI�ӿڵ�ʵ���������sqlSession.getMapper(UserMapper.class)��̬��������
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //ִ��ɾ������
        int retResult = mapper.deleteUserById(7);
        //ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
        sqlSession.close();
        System.out.println(retResult);
    }
    
    //@Test
    public void testGetUser(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        //�õ�UserMapperI�ӿڵ�ʵ�������UserMapperI�ӿڵ�ʵ���������sqlSession.getMapper(UserMapper.class)��̬��������
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //ִ�в�ѯ����������ѯ����Զ���װ��User����
        User user = mapper.getUserById(8);
        //ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
        sqlSession.close();
        System.out.println(user);
    }
    
    //@Test
    public void testGetAll(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        //�õ�UserMapperI�ӿڵ�ʵ�������UserMapperI�ӿڵ�ʵ���������sqlSession.getMapper(UserMapper.class)��̬��������
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //ִ�в�ѯ����������ѯ����Զ���װ��List<User>����
        List<User> lstUsers = mapper.getAllUsers();
        //ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
        sqlSession.close();
        System.out.println(lstUsers);
    }
}
