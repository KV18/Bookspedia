package com.Bookspedia.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Bookspedia.dao.CategoryDao;
import com.Bookspedia.dao.ProductDao;
import com.Bookspedia.dto.Category;
import com.Bookspedia.dto.Product;
import com.Bookspedia.exception.ProductNotFoundException;

@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private ProductDao productDao;

	@RequestMapping(value= {"/","/home","/index"})
	public ModelAndView home()
	{
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("title", "Home");
		
		logger.info("Inside HomeController index - INFO");
		logger.debug("Inside HomeController index - DEBUG");
		
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
	
	/*
	 * view single product
	 * */
	
	@RequestMapping("show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable int id) throws ProductNotFoundException
	{
		ModelAndView mv = new ModelAndView("index");
		Product product = productDao.getProductById(id);
		
		if(product==null) throw new ProductNotFoundException();
		
		//update views count
		product.setViews(product.getViews()+1);
		productDao.updateProduct(product);
		mv.addObject("title",product.getProductName());
		mv.addObject("product",product);
		
		mv.addObject("userClickShowProduct", true);
		return mv;
	}
}
