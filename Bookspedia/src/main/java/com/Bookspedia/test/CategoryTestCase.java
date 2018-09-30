package com.Bookspedia.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Bookspedia.dao.CategoryDao;
import com.Bookspedia.dto.Category;

public class CategoryTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDao categoryDao;
	
	private Category category;
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.Bookspedia");
		context.refresh();
		
		categoryDao = (CategoryDao)context.getBean("categoryDao");
	}

	/*@Test
	public void testAddCategory() {
		
		category = new Category();
		
		
		category.setCategoryName("Mobile");
		category.setCategoryDescription("There is some description about Mobile");
		category.setImageUrl("Cat_3.png");
		
		assertEquals("Successfully added category",true,categoryDao.addCategory(category));
	}*/
	
	/*
	@Test
	public void testGetCategory()
	{
		category = categoryDao.getCategoryById(1);
		assertEquals("Successfully fetched a single category","Television",category.getCategoryName());
	}
	*/
	
	/*
	@Test
	public void testUpdateCategory()
	{
		category = categoryDao.getCategoryById(1);
		category.setCategoryName("TV");
		assertEquals("Successfully updated a single category",true,categoryDao.updateCategory(category));
	}*/
	
	
	/*
	@Test
	public void testDeleteCategory()
	{
		category = categoryDao.getCategoryById(1);
		assertEquals("Successfully deleted a single category",true,categoryDao.deleteCategory(category));
	}
	*/
	
	/*
	 * @Test
	public void testListCategory()
	{
		
		assertEquals("Successfully fetched list of category",2,categoryDao.getCategoryList().size());
	}
	*/
	
	@Test
	public void testCRUDcategory()
	{
		category = new Category();
		
		category.setCategoryName("Television");
		category.setCategoryDescription("There is some descriptrion");
		category.setImageUrl("Cat_01.png");
		
		assertEquals("Successfullt added category to the table",true,categoryDao.addCategory(category));
		
		category = new Category();
		
		category.setCategoryName("Laptop");
		category.setCategoryDescription("There is some descriptrion");
		category.setImageUrl("Cat_02.png");
		
		assertEquals("Successfullt added category to the table",true,categoryDao.addCategory(category));
		
		category = new Category();
		
		category.setCategoryName("Mobile");
		category.setCategoryDescription("There is some descriptrion");
		category.setImageUrl("Cat_03.png");
		
		assertEquals("Successfullt added category to the table",true,categoryDao.addCategory(category));
		
		
		/*category = new Category();
		
		category.setCategoryName("Television");
		category.setCategoryDescription("There is some descriuptrion");
		category.setImageUrl("Cat_02.png");
		
		assertEquals("Successfullt added category to the table",true,categoryDao.addCategory(category));
		
		
		//fetching results
		
		category = categoryDao.getCategoryById(2);
		category.setCategoryName("TV");
		assertEquals("Successfully updated a single category",true,categoryDao.updateCategory(category));

		//deleting category
		
		assertEquals("Successfully deleted a single category",true,categoryDao.deleteCategory(category));
		
		//fetching the list

		assertEquals("Successfully fetched list of category",3,categoryDao.getCategoryList().size());*/
	}
}
