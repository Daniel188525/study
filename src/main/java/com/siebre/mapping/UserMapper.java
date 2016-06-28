package com.siebre.mapping;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.siebre.entity.User;

public interface UserMapper {

	@Insert(value = "insert into users(name, age) values(#{name}, #{age})")
	public int addUser(User user);
	
	@Delete(value = "delete from users where id=#{id}")
	public int deleteUserById(int id);
	
	@Update(value = "update users set name=#{name}, age=#{age} where id=#{id}")
	public int updateUser(User user);
	
	@Select(value = "select * from users where id=#{id}")
	public User getUserById(int id);
	
	@Select(value = "select * from users")
	public List<User> getAllUsers();
}
