package com.siebre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.siebre.dao.UserDao;
import com.siebre.entity.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;

	@Override
	public int addUser(User user) {
		return dao.addUser(user);
	}

	@Override
	public int deleteUserById(int id) {
		return dao.deleteUserById(id);
	}

	@Override
	public int updateUser(User user) {
		return dao.updateUser(user);
	}

	@Override
	@Transactional(readOnly = true)
	public User getUserById(int id) {
		return dao.getUserById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<User> getAllUsers() {
		return dao.getAllUsers();
	}
	
}
