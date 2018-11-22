package com.javarnd.pizza.dao;

import java.sql.SQLException;

import com.javarnd.pizza.model.User;

public interface UserDao {

	public User authenticateUser(String loginName, String password) throws SQLException;
	
	public int insertUser(User user) throws SQLException;
	
	public int updateUser(User user) throws SQLException;
	
	public int deleteUser(User user) throws SQLException;
	
	public int blockUser(String phoneNumber) throws SQLException;
	
	public User getUserByUserByPhoneNumber(String phoneNumber) throws SQLException;
}
