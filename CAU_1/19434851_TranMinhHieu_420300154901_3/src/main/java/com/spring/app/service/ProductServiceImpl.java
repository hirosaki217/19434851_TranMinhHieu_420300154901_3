package com.spring.app.service;

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
	
}
