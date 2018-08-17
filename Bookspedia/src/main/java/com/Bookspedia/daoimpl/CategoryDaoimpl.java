package com.Bookspedia.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.Bookspedia.dao.CategoryDao;
import com.Bookspedia.dto.Category;


@Repository
public class CategoryDaoimpl implements CategoryDao {

	
	
	private static List<Category> categories = new ArrayList<>();
	
	static {
		
		Category category = new Category();
		
		category.setCategoryId(1);
		category.setCategoryName("Television");
		category.setCategoryDescription("This is description for television");
		category.setImageUrl("Cat_tele.jpg");
		
		categories.add(category);
		
		//second
		category = new Category();
		category.setCategoryId(2);
		category.setCategoryName("Mobiles");
		category.setCategoryDescription("This is description for mobiles");
		category.setImageUrl("Cat_mob.jpg");
		
		categories.add(category);
		
		//third
		category = new Category();
		category.setCategoryId(3);
		category.setCategoryName("Laptop");
		category.setCategoryDescription("This is description for laptop");
		category.setImageUrl("Cat_lap.jpg");
		
		categories.add(category);
	}
	
	
	@Override
	public List<Category> getCategoryList() {
		// TODO Auto-generated method stub
		return categories;
	}


	@Override
	public Category getCategoryById(int id) {
		
		for(Category category : categories)
		{
			if(category.getCategoryId()==id)
			{
				return category;
			}
		}
		return null;
	}

}
