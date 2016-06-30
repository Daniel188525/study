package com.siebre.mapper;

import java.util.List;

import com.siebre.entity.User;

/**
 * mybatis mapperInterface
 * @author daniel.zhao
 *
 */
public interface UserMapper {

	public int addUser(User user);
	
	public int deleteUserById(int id);
	
	public int updateUser(User user);
	
	public User getUserById(int id);
	
	public List<User> getAllUsers();
}
