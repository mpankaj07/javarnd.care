package com.javarnd.pizza.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.javarnd.pizza.model.Menu;
import com.javarnd.pizza.model.Order;
import com.javarnd.pizza.model.Topping;

/**
 * @author Developer
 *
 */
public interface PizzaOperationDao {

	public List<Menu> getMenu() throws SQLException;
	
	public List<Topping> getToppingsMenu() throws SQLException;
	
	public Menu getPizzaById(String pizzaId) throws SQLException;
	
	public Topping getToppingById(int pizzaId) throws SQLException;
	
	public int submitOrder(Order order) throws SQLException;
	
	public ResultSet getOrderByID() throws SQLException;
}
