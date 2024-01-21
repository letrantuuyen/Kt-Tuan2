package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.reponsitory.ProductRepository;


@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;
	@Override
	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}
	@Override
	public Product add(Product product) {
		// TODO Auto-generated method stub
		return productRepository.save(product);
	}
	@Override
	public String delete(Long id) {
		// TODO Auto-generated method stub
		productRepository.deleteById(id);
		return "delete complete";
	}
	/*
	@Override
	public Product update(int id, Product product) {
		// TODO Auto-generated method stub
		return null;
	}
	*/
	@Override
	public Product getProductById(Long id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id).get();
	}
	

}
