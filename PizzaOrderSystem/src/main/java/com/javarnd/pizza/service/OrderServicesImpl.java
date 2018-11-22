package com.javarnd.pizza.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javarnd.pizza.dao.PizzaOperationDaoImpl;
import com.javarnd.pizza.model.Menu;
import com.javarnd.pizza.model.Topping;

@Component
public class OrderServicesImpl implements OrderServices {

	@Autowired
	PizzaOperationDaoImpl pizzaOperationDaoImpl;

	@Override
	public List<Menu> getMenu() throws SQLException {

		return pizzaOperationDaoImpl.getMenu();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.javarnd.pizza.service.OrderServices#getPizzaById(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public Menu getPizzaById(String pizzaId, String size, String quantity, String toppingId) throws SQLException {

		Menu pizza = pizzaOperationDaoImpl.getPizzaById(pizzaId);

		return this.processPizzaDetails(pizza, size, quantity, toppingId);
	}

	/**
	 * @param pizza
	 * @param resultSet
	 * @throws SQLException
	 */
	private Menu processPizzaDetails(Menu pizza, String size, String quantity, String toppingId) throws SQLException {

		Menu orderedPizza = new Menu();
		int qunat = Integer.parseInt(quantity);
		double toppingCost = 0;
		
		if (toppingId != null) {
			int topId = Integer.parseInt(toppingId);
			Topping topping = this.getToppingById(topId);
			toppingCost = topping.getToppingPrize();
		}

		orderedPizza.setPizzaName(pizza.getPizzaName());
		orderedPizza.setPizzaid(pizza.getPizzaid());
		if (size.equalsIgnoreCase("small")) {
			orderedPizza.setSmallPrize((pizza.getMediumPrize() * qunat) + (qunat * toppingCost));
		} else if (size.equalsIgnoreCase("medium")) {
			orderedPizza.setMediumPrize((pizza.getMediumPrize() * qunat) + (qunat * toppingCost));
		} else {
			orderedPizza.setLargePrize((pizza.getLargePrize() * qunat) + (qunat * toppingCost));
		}

		return orderedPizza;
	}

	/**
	 * @param pizza
	 * @return
	 */
	public double processPizzaCost(Menu pizza) {

		double cost = 0;

		if (pizza.getSmallPrize() != 0) {
			cost = pizza.getSmallPrize();
		} else if (pizza.getMediumPrize() != 0) {
			cost = pizza.getMediumPrize();
		} else {
			cost = pizza.getLargePrize();
		}
		return cost;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.javarnd.pizza.service.OrderServices#getToppingById(int)
	 */
	@Override
	public Topping getToppingById(int toppingId) throws SQLException {
		
		return pizzaOperationDaoImpl.getToppingById(toppingId);
	}

	@Override
	public List<Topping> getTopping() throws SQLException {

		return pizzaOperationDaoImpl.getToppingsMenu();
	}
}
