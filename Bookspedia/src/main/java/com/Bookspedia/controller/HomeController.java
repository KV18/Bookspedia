package com.Bookspedia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Bookspedia.dao.CategoryDao;
import com.Bookspedia.dto.Category;

@Controller
public class HomeController {
	
	@Autowired
	private CategoryDao categoryDao;

	@RequestMapping(value= {"/","/home","/index"})
	public ModelAndView home()
	{
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("title", "Home");
		mv.addObject("userClickHome", true);
		mv.addObject("categoryList",categoryDao.getCategoryList());
		return mv;
	}
	
	@RequestMapping("/about")
	public ModelAndView about()
	{
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("title", "About");
		mv.addObject("userClickAbout", true);
		return mv;
	}
	
	@RequestMapping("/contact")
	public ModelAndView contact()
	{
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("title", "Contact");
		mv.addObject("userClickContact", true);
		return mv;
	}
	/*
	 * methods
	 * */
	
	@RequestMapping("/show/all/products")
	public ModelAndView showAll()
	{
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("title", "All Products");
		mv.addObject("categoryList", categoryDao.getCategoryList());
		mv.addObject("userClickAllProducts", true);
		return mv;	
	}
	
	@RequestMapping("/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id)
	{
		ModelAndView mv = new ModelAndView("index");
		
		Category category=null;
		category = categoryDao.getCategoryById(id);
		
		mv.addObject("title",category.getCategoryName());
		
		mv.addObject("categoryList", categoryDao.getCategoryList());
		
		mv.addObject("category", category);
		mv.addObject("userClickCategoryProducts", true);
		return mv;	
	}
}
