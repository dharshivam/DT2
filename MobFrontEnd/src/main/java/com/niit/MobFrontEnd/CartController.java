package com.niit.MobFrontEnd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import com.niit.MobBackEnd.dao.CartDao;
import com.niit.MobBackEnd.dao.ProductDao;
import com.niit.MobBackEnd.model.Cart;
import com.niit.MobBackEnd.model.Product;
import com.niit.MobBackEnd.model.Shipping;
import com.niit.MobBackEnd.model.Users;


@org.springframework.stereotype.Controller
public class CartController {
	
	@Autowired
	   Product product;
	
	@Autowired
	   ProductDao productDao;
	
	@Autowired
		Cart cart;
	
	@Autowired
		CartDao cartDao;
	
	@Autowired
		Users user;
	
	
	 @RequestMapping("/cart")
     public ModelAndView edit(@ModelAttribute("pro")Product product,@RequestParam(value="id", required=true) String id) {
        
        product=productDao.getPro(id);
        System.out.println("Done Here 1");
        ModelAndView mv=new ModelAndView("Cart","prod",product);
        System.out.println("Done Here 2");
       
         return mv;
}

	 @RequestMapping("/GsonC")
		public @ResponseBody String listUsers() {
		 String pro="";
					
			
			Product prod=null;
			Gson gson=null;
			prod = productDao.getPro(pro);
				
				gson=new Gson();
				pro=gson.toJson(prod);
				  System.out.println(pro);
		 
		    return pro;
		    
		  
		
	}
	 
	 /*@RequestMapping("/userview")
		public String getUserview(){
			return "User";
		}*/
	 
	 @RequestMapping(value="/userview")
	    public ModelAndView list() {
	        List<Product> itemList = productDao.list();
	        ModelAndView model = new ModelAndView("User");
	        model.addObject("itemList", itemList);
	        return model;
	    }
	 
	 @RequestMapping(value="usr/cart/add")
     public ModelAndView edit(@RequestParam(value="id") String id,@RequestParam(value="nam") String nam) {
        
		 ModelAndView model = new ModelAndView("User");
		 List<Product> itemList = productDao.list();
	        model.addObject("itemList", itemList);
        System.out.println(id+" ooooooooooo "+nam);
        
        product=productDao.getPro(id);
//        cart.setCart_id(product.getPid());
        cart.setPname(product.getPname());
        cart.setPrice(product.getPprice());
        cart.setUser_id(nam);
        cart.setStat("open");
       cartDao.SaveOrUpdate(cart);
       
       return model;
}
	 @RequestMapping("/cart-table")
	 public ModelAndView display(@RequestParam(value="nam")String nam)
	 {
		 ModelAndView model = new ModelAndView("Cart");
		 List<Cart> itemList=cartDao.list();
		 model.addObject("itemList", itemList);
		 System.out.println("displaying cart table");
		 return model;
	 }
	 @RequestMapping("user/back")
	 public String goBack()
	 {
		 return "User";
	 }
	 @RequestMapping("/header")
		public String gethead(){
			return "header";
	 }
			 @RequestMapping(value="/continue",method=RequestMethod.GET)
			 public ModelAndView getshform(@ModelAttribute("order")Shipping shipping,@RequestParam(value="id")String id,@RequestParam(value="pid") String pid,@RequestParam(value="pprice") int pprice){
				ModelAndView m=new ModelAndView("Cart_shipAdd","order",shipping) ;
				System.out.println("product name = " + pid);
				shipping.setProduct_name(pid);
				shipping.setProduct_price(pprice);
				
				 return m;
			 }
		
}
