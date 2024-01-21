package com.example.demo.reponsitory;

import com.example.demo.entity.Product;
import com.example.demo.entity.User;

public class OrderRepository {
	
	private Product product;
	private User user;
	
	public OrderRepository() {
		// TODO Auto-generated constructor stub
	}
	public OrderRepository(Product product, User user) {
		super();
		this.product = product;
		this.user = user;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	

}
