package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;;

@Service
public interface ProductService {
	
	public List<Product> getAllProduct();
	public Product add(Product product);
	public String delete(Long id);
	//public Product update(Long id, Product product);
	public Product getProductById(Long id);
}
