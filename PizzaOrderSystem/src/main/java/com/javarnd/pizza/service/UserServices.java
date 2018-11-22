package com.javarnd.pizza.service;

import java.sql.SQLException;

import com.javarnd.pizza.model.Order;
import com.javarnd.pizza.model.User;

public interface UserServices {
	
	public int registerUser(User user) throws SQLException; 
	
	public User authenticateUser(String userName, String password) throws SQLException;
	
	public int deleteUser(String phoneNumber) throws SQLException;
	
	public int blockUser(String phoneNumber) throws SQLException;
	
	public int submitOrder(Order order) throws SQLException;

}
