package com.bitwise.cart;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewProductDetails {
	
	
	@RequestMapping(value = "/details", method = RequestMethod.GET)
	public ModelAndView save(@ModelAttribute("productDetails") ProductDetails productDetails,@RequestParam String id) {
		//System.out.println(contactForm);
		//System.out.println(contactForm.getContacts());
		String products = productDetails.getProduct_Name();
//		
//		if(products.contains(id))
//		{
//			System.out.println("present");
//		}
		
//		if(products.equalsIgnoreCase(id))
//		{
//			System.out.print(productDetails.product_Name);
//		}
//		else
//		{
//			System.out.println("not present");
//		}
		//ProductDetails str=productList.get
		System.out.println("hello");
		System.out.println(id);
		return new ModelAndView("details", "productDetails", productDetails);
		}

}
