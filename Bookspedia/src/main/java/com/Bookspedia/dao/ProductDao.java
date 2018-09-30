package com.Bookspedia.dao;

import java.util.List;

import com.Bookspedia.dto.Product;

public interface ProductDao {

	Product getProductById(int productId);
	List<Product> getProductList();
	boolean addProduct(Product product);
	boolean updateProduct(Product product);
	boolean deleteProduct(Product product);

	//business methods
	List<Product> listActiveProducts();
	List<Product> listActiveProductsByCategory(int categoryId);
	List<Product> getLatestActiveProducts(int count);
}
