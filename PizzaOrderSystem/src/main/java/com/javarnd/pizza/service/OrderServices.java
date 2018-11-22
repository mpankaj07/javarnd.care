package com.javarnd.pizza.service;

import java.sql.SQLException;
import java.util.List;

import com.javarnd.pizza.model.Menu;
import com.javarnd.pizza.model.Topping;

public interface OrderServices {

	public List<Menu> getMenu() throws SQLException;
	
	public List<Topping> getTopping() throws SQLException;
	
	public Menu getPizzaById(String pizzaId, String size, String quantity, String toppingId) throws SQLException;
	
	public Topping getToppingById(int toppingId) throws SQLException;
}
