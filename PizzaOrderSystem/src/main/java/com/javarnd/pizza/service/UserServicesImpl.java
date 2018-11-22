package com.javarnd.pizza.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javarnd.pizza.dao.PizzaOperationDaoImpl;
import com.javarnd.pizza.dao.UserDaoImpl;
import com.javarnd.pizza.model.Order;
import com.javarnd.pizza.model.User;

/**
 * @author Developer Services for the user insert
 *
 */
@Service
public class UserServicesImpl implements UserServices {

	@Autowired
	UserDaoImpl userDaoImpl;
	@Autowired
	PizzaOperationDaoImpl pizzaOperationDaoImpl;
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.javarnd.pizza.service.UserServices#registerUser(com.javarnd.pizza.model.
	 * User)
	 */
	@Override
	public int registerUser(User user) throws SQLException {
		return userDaoImpl.insertUser(user);

	}

	/* (non-Javadoc)
	 * @see com.javarnd.pizza.service.UserServices#authenticateUser(java.lang.String, java.lang.String)
	 */
	@Override
	public User authenticateUser(String userName, String password) throws SQLException {

		return userDaoImpl.authenticateUser(userName, password);
	}

	/* (non-Javadoc)
	 * @see com.javarnd.pizza.service.UserServices#deleteUser(java.lang.String)
	 */
	@Override
	public int deleteUser(String phoneNumber) throws SQLException {
		
		User user = userDaoImpl.getUserByUserByPhoneNumber(phoneNumber);
		return userDaoImpl.deleteUser(user);
	}

	/* (non-Javadoc)
	 * @see com.javarnd.pizza.service.UserServices#blockUser(java.lang.String)
	 */
	@Override
	public int blockUser(String phoneNumber) throws SQLException {
		
		return userDaoImpl.blockUser(phoneNumber);
	}

	@Override
	public int submitOrder(Order order) throws SQLException {
		
		return pizzaOperationDaoImpl.submitOrder(order);
	}

}
