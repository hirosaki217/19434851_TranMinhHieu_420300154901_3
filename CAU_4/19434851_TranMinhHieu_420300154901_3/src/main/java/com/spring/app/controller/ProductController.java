package com.spring.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.app.entity.Product;
import com.spring.app.service.JmsProducer;
import com.spring.app.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	ProductService productService;
	
	@Autowired
	JmsProducer jmsProducer;
	
	@PostMapping("/createProduct")
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		Product p = productService.createProduct(product);
		return ResponseEntity.ok(p);
		
	}
	
	@GetMapping("/getProducts")
	@PreAuthorize("hasAnyAuthority('USER_READ')")
	public ResponseEntity<List<Product>> getProducts() {
		return  ResponseEntity.ok(productService.getProducts());
	}
	
	@PostMapping("/createProductActiveMQ")
	public ResponseEntity<Product> createProductActiveMQ(@RequestBody Product product) {
		Product p = productService.createProduct(product);
		jmsProducer.sendMessage(p);
		return ResponseEntity.ok(p);
		
	}
	
}
