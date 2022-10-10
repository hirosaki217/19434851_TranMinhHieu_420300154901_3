package com.spring.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.app.entity.Product;
import com.spring.app.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	ProductService productService;
	
	@PostMapping("/createProduct")
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		Product p = productService.createProduct(product);
		return ResponseEntity.ok(p);
		
	}
}
