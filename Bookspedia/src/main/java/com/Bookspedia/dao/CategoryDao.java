package com.Bookspedia.dao;

import java.util.List;

import com.Bookspedia.dto.Category;

public interface CategoryDao {

	List<Category> getCategoryList();
	Category getCategoryById(int id); 
	boolean addCategory(Category category);
	boolean updateCategory(Category category);
	boolean deleteCategory(Category category);
}
