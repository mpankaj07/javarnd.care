package com.javarnd.pizza.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.javarnd.pizza.model.Menu;
import com.javarnd.pizza.model.Topping;
import com.javarnd.pizza.service.OrderServicesImpl;

/**
 * Servlet implementation class OrderPlace
 */
@Controller
public class PizzaMenu {

	@Autowired
	OrderServicesImpl orderServicesImpl;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@RequestMapping("/pizzamenu")
	protected ModelAndView displayMenu(HttpServletRequest request) {
		
		List<Menu> pizzaList;
		List<Topping> toppingList;
		try {
			pizzaList = orderServicesImpl.getMenu();
			toppingList = orderServicesImpl.getTopping();
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("menu", pizzaList);
			httpSession.setAttribute("toppingList", toppingList);
			return new ModelAndView("order/display_menu");
		} catch (SQLException e) {
			System.out.println("Exception in doPost");
			e.printStackTrace();
		}
		return null;
	}
	

}
