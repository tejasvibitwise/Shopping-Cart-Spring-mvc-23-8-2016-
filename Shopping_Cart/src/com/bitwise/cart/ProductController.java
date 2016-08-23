package com.bitwise.cart;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bitwise.exceptions.OutOfStockException;

@Controller
public class ProductController {

	@Autowired
	CountProduct countProduct;
	
@Autowired

ProductList productList;

@Autowired
CartItems cartItems;


	
	@RequestMapping(value = "/success", method = RequestMethod.GET)
	public ModelAndView save() {
		
		return new ModelAndView("success", "productList", productList);
		
		}
	
	@RequestMapping(value = "/count", method = RequestMethod.GET)
	public ModelAndView addProduct(Model model,HttpServletRequest request,@RequestParam String id) {
	
		
		
		
		ProductDetails product=productList.findProduct(id);
		if(product.stock>=1)
			countProduct.incrementCount();
		int c=countProduct.getCount();
		HttpSession session=request.getSession(false);
		cartItems=(CartItems) session.getAttribute("cart");
		cartItems.additem(product);
		session.setAttribute("cart", cartItems);
		model.addAttribute("count", c);
		
		return new ModelAndView("success", "productList", productList);
	
		}
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public ModelAndView viewProduct(Model model,HttpServletRequest request) {
	
		HttpSession session=request.getSession(false);
		cartItems=(CartItems) session.getAttribute("cart");
		int c=countProduct.getCount();
		model.addAttribute("count", c);
		return new ModelAndView("viewcart", "cartItems", cartItems);
	
		}

	
	@RequestMapping(value = "/remove", method = RequestMethod.GET)
	public ModelAndView removeProduct(Model model,HttpServletRequest request,@RequestParam String id) {
	
		HttpSession session=request.getSession(false);
		cartItems=(CartItems) session.getAttribute("cart");
		cartItems.removeProduct(id);
		countProduct.decrementCount();
		int c=countProduct.getCount();
		session.setAttribute("cart", cartItems);
		model.addAttribute("count", c);
		return new ModelAndView("viewcart", "cartItems", cartItems);
	
		}
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ModelAndView displayProduct(Model model) {
		int c=countProduct.getCount();
		
		model.addAttribute("count", c);
		return new ModelAndView("success", "productList", productList);
	
		}
	
	@RequestMapping(value = "/placeorder", method = RequestMethod.GET)
	public ModelAndView placeOrder(Model model,HttpServletRequest request) {
	
		
		HttpSession session=request.getSession(false);
		cartItems=(CartItems) session.getAttribute("cart");
		
		model.addAttribute("total",cartItems.placeOrder());
		session.setAttribute("cart", new CartItems());
		return new ModelAndView("placeOrder", "cartItems", cartItems);
		}
	
	@ExceptionHandler(OutOfStockException.class)
	public ModelAndView handleCustomException(OutOfStockException except) {

	      return new ModelAndView("ExceptionPage", "Msg", except.getMessage());

	}
	

}
