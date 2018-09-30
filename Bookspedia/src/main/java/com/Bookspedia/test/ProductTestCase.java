package com.Bookspedia.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Bookspedia.dao.ProductDao;
import com.Bookspedia.dto.Product;

public class ProductTestCase {

	private static AnnotationConfigApplicationContext context;
	
	private static ProductDao productDao;
	
	private Product product;
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.Bookspedia");
		context.refresh();
		productDao = (ProductDao)context.getBean("productDao");
	}
	
	/*@Test
	public void testCRUDProduct()
	{
			product = new Product();
			
			product.setProductName("Oppo Selfie S53");
			product.setBrand("Oppo");
			product.setProductDescription("There is some description about Oppo");
			product.setUnitPrice(25000);
			product.setActive(true);
			product.setCategoryId(3);
			product.setSupplierId(3);
			
			assertEquals("Something went wrong while inserting a new product",true,productDao.addProduct(product));
			
			//reading and updating the category
			product = productDao.getProductById(2);
			product.setProductName("Samsung Galaxy S7");
			assertEquals("Somethign went wrong while updating the product",true,productDao.updateProduct(product));
			
			assertEquals("Somethign went wrong while deleting the product",true,productDao.deleteProduct(product));
			
			//list
			assertEquals("Somethign went wrong while fetching the product list",6,productDao.getProductList().size());
					
	}*/
	
	@Test
	public void testListActiveProducts() {
		
		assertEquals("Somehing went wrong while fetching the list products",5,productDao.listActiveProducts().size());
		
	}
	
	@Test
	public void testListActiveProductsByCategory() {
		
		assertEquals("Somehing went wrong while fetching the list products",3,productDao.listActiveProductsByCategory(3).size());
		assertEquals("Somehing went wrong while fetching the list products",2,productDao.listActiveProductsByCategory(2).size());
		
	}
	
	@Test
	public void testGetLatestActiveProduct() {
		
		assertEquals("Somehing went wrong while fetching the list products",3,productDao.getLatestActiveProducts(3).size());
		
	}
} 
