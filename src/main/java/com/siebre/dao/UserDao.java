package com.siebre.dao;

import java.util.List;

import com.siebre.entity.User;

public interface UserDao {

	public int addUser(User user);
	
	public int deleteUserById(int id);
	
	public int updateUser(User user);
	
	public User getUserById(int id);
	
	public List<User> getAllUsers();
}
