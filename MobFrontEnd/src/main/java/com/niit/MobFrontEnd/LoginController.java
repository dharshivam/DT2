package com.niit.MobFrontEnd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.MobBackEnd.model.Users;



@Controller

public class LoginController {
	
	@Autowired
	Users users;
	
//	@RequestMapping("/header")
//	public String gethead(){
//		return "header";
//	}
	
	 //Spring Security related******************************************************************************
	 @RequestMapping("/logins")
		public String getLog()
		{
			return "SignIn";
		}
	 @RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
		public ModelAndView defaultPage() {
		 	System.out.println("welcome");
			ModelAndView model = new ModelAndView("index");
			System.out.println("Sir");
			return model;

		}
	 @RequestMapping(value = "/login", method = RequestMethod.GET)
		public ModelAndView getLogin(@RequestParam(value = "error", required = false) String error,
				@RequestParam(value = "logout", required = false) String logout) {
		 		System.out.println("login page");
			ModelAndView model = new ModelAndView();
			if (error != null) {
				model.addObject("error", "Invalid username and password!");
				System.out.println("Error");
				model.setViewName("SignIn");
			}

			else if (logout != null) {
				model.addObject("msg", "you have loggedout duccessfully");
				System.out.println("LogOut");
				model.setViewName("index");
			}
			else
			{
				System.out.println("some error");
			model.setViewName("user-table");
			}
			return model;

		}


}
