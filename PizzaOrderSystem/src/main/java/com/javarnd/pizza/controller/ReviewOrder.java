package com.javarnd.pizza.controller;

import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.javarnd.pizza.model.Menu;
import com.javarnd.pizza.service.OrderServicesImpl;

/**
 * Servlet implementation class ReviewOrder
 */
@Controller
public class ReviewOrder {

	@Autowired
	OrderServicesImpl orderServicesImpl;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@RequestMapping("/reviewOrder")
	protected ModelAndView getOrderDetails(@RequestParam Map<String,String> req, RedirectAttributes redirectAttributes) {
		
		try {
			Menu pizza = orderServicesImpl.getPizzaById(req.get("selectedPizza"), req.get("size"), 
					req.get("quantity"), req.get("selectedTopping"));
			
			double totalCost = orderServicesImpl.processPizzaCost(pizza);
			ModelAndView mv = new ModelAndView("redirect:/submitOrder");
			redirectAttributes.addFlashAttribute("pizza", pizza);
			redirectAttributes.addFlashAttribute("totalCost", totalCost);
			redirectAttributes.addFlashAttribute("quantity", req.get("quantity"));
			return mv;
			
		} catch (SQLException e) {
			System.err.println("Exception in doPost of ReviewOrder");
			e.printStackTrace();
		}
		return null;
	}

}
