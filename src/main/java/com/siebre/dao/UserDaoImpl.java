package com.siebre.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.siebre.entity.User;
import com.siebre.mapping.UserMapper;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private UserMapper userMapper;
	
	public int addUser(User user) {
		return userMapper.addUser(user);
	}
	
	public int deleteUserById(int id) {
		return userMapper.deleteUserById(id);
	}
	
	public int updateUser(User user) {
		return userMapper.updateUser(user);
	}
	
	public User getUserById(int id) {
		return userMapper.getUserById(id);
	}
	
	public List<User> getAllUsers() {
		return userMapper.getAllUsers();
	}
}
