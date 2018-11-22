package com.javarnd.pizza.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.javarnd.pizza.model.User;
import com.javarnd.pizza.service.UserServicesImpl;

/**
 * Servlet implementation class Login
 */
@Controller
public class LoginController {

	@Autowired
	UserServicesImpl userServicesImpl;

	@GetMapping("/welcome")
	public ModelAndView welcome() {
		return new ModelAndView("login/login");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@PostMapping("/login")
	public ModelAndView login(@RequestParam("loginName") String loginName, @RequestParam("password") String password,
			HttpServletRequest request) {

		HttpSession session = request.getSession(true);
		try {
			User user = userServicesImpl.authenticateUser(loginName, password);
			session.setAttribute("user", user);
			if (user != null) {
				System.out.println("user not null");
				if (user.getRole() == 1) {
					System.out.println("Admin");
					return new ModelAndView("admin_home");
				} else if (user.getRole() == 2) {
					System.out.println("User");
					return new ModelAndView("user_home");
				} else {
					System.out.println("Login Failed");
					ModelAndView mv = new ModelAndView("login/login_failure");
					mv.addObject("error", "Login failed due to invalid crdenttials");
					return mv;
				}
			}
			return new ModelAndView("login");
		} catch (Exception e) {
			System.err.println("Exception in doPost of Login");
			e.printStackTrace();
		}
		return null;
	}
}
