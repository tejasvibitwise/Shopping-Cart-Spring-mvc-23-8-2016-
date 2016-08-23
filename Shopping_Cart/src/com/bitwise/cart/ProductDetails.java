package com.bitwise.cart;

import java.util.ArrayList;
import java.util.List;

public class ProductDetails {
	
		String product_Name;
		int price;
		String color;
		String model;
		int stock;
		int quantity=1;
		
		//List<ProductDetails> products=new ArrayList<ProductDetails>();
		
		
		public int getQuantity() {
			return quantity;
		}


		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}


		public String getProduct_Name() {
			return product_Name;
		}


		public void setProduct_Name(String product_Name) {
			this.product_Name = product_Name;
		}


		public int getPrice() {
			return price;
		}


		public void setPrice(int price) {
			this.price = price;
		}


		public int getStock() {
			return stock;
		}


		public void setStock(int stock) {
			this.stock = stock;
		}


		

		@Override
		public String toString() {
			return "<BR>Product_Name=" + product_Name +"<BR>";
		}


		


//		public ProductDetails(String string, int i, int j)
//		{
//			this.product_Name=string;
//			this.price=i;
//			this.stock=j;
//		}
//
//		public ProductDetails()
//		{
//			products.add(new ProductDetails("prod1",1,2));
//			products.add(new ProductDetails("prod2",10,4));
//			products.add(new ProductDetails("prod3",11,5));
//			products.add(new ProductDetails("prod4",12,6));
//			products.add(new ProductDetails("prod5",13,7));
//			products.add(new ProductDetails("prod6",45,5));
//			products.add(new ProductDetails("prod7",23,5));
//			products.add(new ProductDetails("prod8",56,4));
//			products.add(new ProductDetails("prod9",789,9));
//			products.add(new ProductDetails("prod10",56,8));
//		}
		
	
}
