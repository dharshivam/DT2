package com.niit.MobFrontEnd;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

public class fcontrol {
	@Controller
	public class HomeController {

		@RequestMapping("/")
		public String gohome(){
			return "index";
		}
		
		@RequestMapping("/login")
		public String gologin(){
			return "login";
		}
		
		@RequestMapping("/logout")
		public String gologout(){
			return "logout";
		}
		
		public String doProcess(){
			return "success";
		}
	}

}
