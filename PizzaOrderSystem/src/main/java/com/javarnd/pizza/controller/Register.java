package com.javarnd.pizza.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.javarnd.pizza.model.User;
import com.javarnd.pizza.service.UserServicesImpl;

/**
 * Servlet implementation class Register
 */
@Controller
public class Register {
	
	@Autowired
	UserServicesImpl userServicesImpl;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@PostMapping("/register")
	protected ModelAndView registerUser(@ModelAttribute("user") User user, BindingResult bindingResult) {
		
		try {
			System.out.println("Inside doPost of Register");		
			user.setRole(2);
			// registering the user
			if (bindingResult.hasErrors()) {
				return new ModelAndView("login/register");
			}
			int result = userServicesImpl.registerUser(user);
			if (result > 0) {
				ModelAndView mv = new ModelAndView("login/reg_success");
				mv.addObject("userId", result);
				return mv;
			} else {
				return new ModelAndView("login/failure");
			}
		} catch (Exception e) {
			System.out.println("Exception in doPost");
		}
		return null;
	}

}
