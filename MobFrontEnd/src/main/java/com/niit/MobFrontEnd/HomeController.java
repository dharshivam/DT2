package com.niit.MobFrontEnd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.niit.MobBackEnd.dao.ProductDao;
import com.niit.MobBackEnd.dao.UserDao;
import com.niit.MobBackEnd.model.Product;
import com.niit.MobBackEnd.model.UserDetails;
import com.niit.MobBackEnd.model.Users;



   @org.springframework.stereotype.Controller
  
public class HomeController {
	   
	   @Autowired
	   Product product;
	   
	   @Autowired
	   UserDao userDao;
	   
	   @Autowired
	   ProductDao productDao;
	   
	   @Autowired
	   Users users;
	   
	  @Autowired
	  UserDetails userDetails;
	   
	   
	   
@RequestMapping(value="/signin" , method=RequestMethod.GET)
public String getsignin(Model model){
	//Users users = new Users();
	model.addAttribute("users", users);
	return "SignIn";
}

	



@RequestMapping("/admin")
public String getadmin(){
	return "admin";
}





@RequestMapping(value="/register",method=RequestMethod.GET)
	public ModelAndView getRegister(@ModelAttribute("userd") Users users){
	ModelAndView mv=new ModelAndView("Register","userd",users);
	return mv;
}

@RequestMapping("/supplier")
public String getSupplier(){
	return "Supplier-Product";
}	   
@RequestMapping("/admin/info")
public String getAdmin(){
	return "admin";
}
@RequestMapping("/asf")
	public ModelAndView getHomepage()
	{
		ModelAndView mv=new ModelAndView("index");
		return mv;
	
		}
	
	//SHO ADD FORM
		@RequestMapping(value="/apro",method=RequestMethod.GET)
		public ModelAndView addPro(@ModelAttribute("prod")Product product)
		{
			System.out.println("addingPro1");
			ModelAndView mv=new ModelAndView("addProd","prod",product);
			return mv;
		}
		
		//?AFTER ADD SUBMIT
		@RequestMapping(value="addingPro")
		public String addProd(@ModelAttribute("prod") Product product, final RedirectAttributes redirectAttributes)
		{
			redirectAttributes.addFlashAttribute("message", "true");
			redirectAttributes.addFlashAttribute("prod", product);
			productDao.saveOrUpdate(product);
			
		return "redirect:/supplier";
			
		}
		
		@RequestMapping("table")
		public String getTable(){
			return "ProductTable";
		}
		
		/*@RequestMapping("/userview")
		public String getUserview(){
			return "User";
		}*/
		
		
		
		@RequestMapping("/GsonCon")
		public @ResponseBody String listUsers() {
		 String pro="";
					
			
			Product prod=null;
			Gson gson=null;
			List<Product> listPro = productDao.list();
				
				gson=new Gson();
				pro=gson.toJson(listPro);
				  System.out.println(pro);
		 
		    return pro;
		    
		  
		
	}
		@RequestMapping("sdel")
		public String getsdel(@ModelAttribute("prod")Product product,@RequestParam(value="val", required=false,defaultValue="")String id){
			
			productDao.delete(id);
			System.out.println("deleted "+id);
			
			return "redirect:/supplier";
			
		}
		
		 @RequestMapping("/edit")
	     public ModelAndView edit(@ModelAttribute("prod")Product product,@RequestParam(value="id", required=true) String id) {
	        
	        product=productDao.getPro(id);
	       // System.out.println("Done Here 1");
	        ModelAndView mv=new ModelAndView("addProd","prod",product);
	        System.out.println("Done Here 2");
	       
	         return mv;
	}
		 @RequestMapping("/brief")
		 public ModelAndView breif(@ModelAttribute("prod")Product product,@RequestParam(value="id", required=true) String id) {
		        
		        product=productDao.getPro(id);
		       // System.out.println("Done Here 1");
		        ModelAndView mv=new ModelAndView("brief","prod",product);
		        //System.out.println("Done Here 2");
		       
		         return mv;
		}
		 
		 @RequestMapping(value="addinguser")
			public String addProd(@ModelAttribute("userd") Users users, final RedirectAttributes redirectAttributes)
			{
				redirectAttributes.addFlashAttribute("message", "true");
				redirectAttributes.addFlashAttribute("userd",users);
				users.setUrole("ROLE_USER");
				userDao.saveOrUpdateUsers(users);;
				
				
			return "redirect:/signin";
				
			}
		 
//		 @RequestMapping(value="addinguser")
//			public String addProd(@ModelAttribute("userd") Users users, final RedirectAttributes redirectAttributes)
//			{
//				redirectAttributes.addFlashAttribute("message", "true");
//				redirectAttributes.addFlashAttribute("userd",users);
//				users.setUrole("ROLE_USER");
//				userDao.saveOrUpdateUsers(users);
//				return "redirect:/signin";
//				
//			}
		 
		 
   }
		