package com.bitwise.cart;

import java.util.ArrayList;
import java.util.List;

import com.bitwise.exceptions.ItemNotFoundException;
import com.bitwise.exceptions.OutOfStockException;

public class CartItems {

	List<ProductDetails> products=new ArrayList<ProductDetails>();

	public List<ProductDetails> getProducts() {
		return products;
	}

	public void setProducts(List<ProductDetails> products) {
		this.products = products;
	}
	
	public void additem(ProductDetails product)
	{
		
		if(products.contains(product))
		{
			if(product.stock>=1)
			{
			product.quantity++;
			product.stock--;
			}
			else
			{
				 throw new OutOfStockException("Product out of Stock");
			}
		}
		else
		{
			products.add(product);
			product.stock--;
		}
	}

	public void removeProduct(String id) {
		int pid=0;
		for (ProductDetails product : products) {
			if(product.getProduct_Name().equals(id))
			{
				if(product.quantity>1)
				{
					product.quantity--;
					product.stock++;
					break;
				}
				else
				{
					pid=products.indexOf(product);
					products.remove(pid);
					product.stock++;
					break;
				}
				
				//products.remove(product);
			}		
		}
		
		
	}

	public int placeOrder() {
		
		int totalPrice=0;
		
		for (ProductDetails product : products) {
			totalPrice=totalPrice+(product.price*product.quantity);
		}
		return totalPrice;
		}
	

}
