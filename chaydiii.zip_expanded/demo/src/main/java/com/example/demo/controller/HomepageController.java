package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import com.example.demo.reponsitory.OrderRepository;
import com.example.demo.reponsitory.ProductRepository;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/products")
public class HomepageController {
	@Autowired
	private ProductService productService;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private ProductRepository productRepository;
	
	
	@GetMapping("/")
	public List<Product> getProduct() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("products");
		return productService.getAllProduct();
	}
	
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable("id") Long id) {
		return productService.getProductById(id);
	}
	
	@PostMapping("/add")
	public Product addProduct(@RequestBody Product product) {
		return productService.add(product);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable("id") Long id) {
		productService.delete(id);
		return "delete complete";
	}
	@GetMapping("/orderproduct/{id}/{productId}")
	public ResponseEntity<OrderRepository> orderProductByUser(@PathVariable Long id,
			@PathVariable Long productId){
		OrderRepository orderRepository = new OrderRepository();
		String url = "http://localhost:8080/home/users/" + id;
		ResponseEntity<User> responeEntity = restTemplate.getForEntity(url,User.class);
		Optional<Product> optionalProduct = productRepository.findById(productId);
		Product product = null;
		if(optionalProduct.isPresent()) {
			product = optionalProduct.get();
		}else {
			new RuntimeException("Khong co");
		}
		User user = responeEntity.getBody();
		orderRepository.setUser(user);
		orderRepository.setProduct(product);
		return new ResponseEntity<>(orderRepository,HttpStatus.OK);
		
	}

	

}
