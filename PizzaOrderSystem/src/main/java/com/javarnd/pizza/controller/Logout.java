package com.javarnd.pizza.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Servlet implementation class Logout
 */
@Controller
public class Logout {

	/**
	 * @param request
	 * @return
	 */
	@GetMapping("/logout")
	protected ModelAndView logout(HttpServletRequest request)  {
		
		HttpSession httpSession = request.getSession();
		httpSession.invalidate();
		return new ModelAndView("login");
	}

}
