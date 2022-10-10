package com.spring.app.service;

import java.util.List;

import com.spring.app.entity.Product;

public interface ProductService {
	Product createProduct(Product product);
	
	List<Product> getProducts();
}
