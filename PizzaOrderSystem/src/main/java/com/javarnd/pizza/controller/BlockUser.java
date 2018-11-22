package com.javarnd.pizza.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.javarnd.pizza.service.UserServicesImpl;

/**
 * Servlet implementation class BlockUser
 */
@Controller
public class BlockUser {

	@Autowired
	UserServicesImpl userServicesImpl;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@RequestMapping("/blockUser")
	protected ModelAndView blockUser(@RequestParam("mobileNumber") String mobileNumber) {

		try {
			int message = userServicesImpl.blockUser(mobileNumber);

			if (message == 1) {
				return new ModelAndView("login/block_success");
			} else {
				return new ModelAndView("login/failure");
			}			
		} catch (Exception e) {
			System.out.println("Exception in doPost of deleteUser");
		}
		return new ModelAndView("login/failure");
	}

}
