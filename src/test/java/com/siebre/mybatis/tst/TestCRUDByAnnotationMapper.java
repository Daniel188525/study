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
        //得到UserMapper接口的实现类对象，UserMapper接口的实现类对象由sqlSession.getMapper(UserMapper.class)动态构建出来
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setName("用户xdp");
        user.setAge(20);
        int add = mapper.addUser(user);
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        System.out.println(add);
    }
    
    //@Test
    public void testUpdate(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
        //得到UserMapper接口的实现类对象，UserMapper接口的实现类对象由sqlSession.getMapper(UserMapper.class)动态构建出来
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(new Long(3));
        user.setName("孤傲苍狼_xdp");
        user.setAge(26);
        //执行修改操作
        int retResult = mapper.updateUser(user);
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        System.out.println(retResult);
    }
    
    //@Test
    public void testDelete(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
        //得到UserMapperI接口的实现类对象，UserMapperI接口的实现类对象由sqlSession.getMapper(UserMapper.class)动态构建出来
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //执行删除操作
        int retResult = mapper.deleteUserById(7);
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        System.out.println(retResult);
    }
    
    //@Test
    public void testGetUser(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        //得到UserMapperI接口的实现类对象，UserMapperI接口的实现类对象由sqlSession.getMapper(UserMapper.class)动态构建出来
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //执行查询操作，将查询结果自动封装成User返回
        User user = mapper.getUserById(8);
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        System.out.println(user);
    }
    
    //@Test
    public void testGetAll(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        //得到UserMapperI接口的实现类对象，UserMapperI接口的实现类对象由sqlSession.getMapper(UserMapper.class)动态构建出来
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //执行查询操作，将查询结果自动封装成List<User>返回
        List<User> lstUsers = mapper.getAllUsers();
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        System.out.println(lstUsers);
    }
}
