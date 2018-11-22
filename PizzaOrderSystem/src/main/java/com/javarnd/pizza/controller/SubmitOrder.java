package com.javarnd.pizza.controller;

import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.javarnd.pizza.model.Menu;
import com.javarnd.pizza.model.Order;
import com.javarnd.pizza.model.User;
import com.javarnd.pizza.service.UserServicesImpl;

/**
 * Servlet implementation class SubmitOrder
 */
@Controller
public class SubmitOrder {

	@Autowired
	UserServicesImpl userServicesImpl;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@GetMapping("/submitOrder")
	protected ModelAndView submitOrder(HttpServletRequest request, HttpServletResponse response) {

		User user = (User) request.getSession(false).getAttribute("user");
		Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
		Menu pizza = (Menu) flashMap.get("pizza");
		String quant = (String) flashMap.get("quantity");
		double totalCost = (double) flashMap.get("totalCost");
		
		System.out.println("User Id :" + user.getUserId() + " " + pizza.getPizzaid() + " " + quant + " " + totalCost);
		
		Order order = new Order();
		order.setPizzaId(pizza.getPizzaid());
		order.setUserId(user.getUserId());
		order.setQuantity(Integer.parseInt(quant));
		order.setTotalCost(totalCost);

		try {
			int result = userServicesImpl.submitOrder(order);
			if (result > 1) {
				ModelAndView mv = new ModelAndView("order/submit_order");
				mv.addObject("orderId", result);
				mv.addObject("totalCost", order.getTotalCost());
				mv.addObject("pizzaName", pizza.getPizzaName());
				return mv;
			} else {
				return new ModelAndView("order/order_failure");
			}

		} catch (SQLException e) {
			System.out.println("Exception in doPost of SubmitOrder");
			e.printStackTrace();
		}
		return null;

	}

}
