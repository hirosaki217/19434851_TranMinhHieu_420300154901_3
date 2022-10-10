package com.spring.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.app.entity.Product;
import com.spring.app.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductRepository productRepository;
	
	public Product createProduct(Product product) {
		
		return productRepository.saveAndFlush(product);
	}

	public List<Product> getProducts() {
		
		return productRepository.findAll();
	}
	
}
