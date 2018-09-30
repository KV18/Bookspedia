package com.Bookspedia.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Bookspedia.dao.ProductDao;
import com.Bookspedia.dto.Product;


@Repository("productDao")
@Transactional

public class ProductDaoImpl implements ProductDao {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public Product getProductById(int productId) {
		try {
			
			return sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(productId));
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Product> getProductList() {
		return sessionFactory.getCurrentSession().createQuery("FROM Product",Product.class).getResultList();
		
	}

	@Override
	public boolean addProduct(Product product) {
		try {
			
			sessionFactory.getCurrentSession().persist(product);
			return true;
		}
		catch(Exception ex) {
			
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} 
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteProduct(Product product) {
		try {
			product.setActive(false);
			//call the update method 
			return this.updateProduct(product);
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Product> listActiveProducts() {
		String selectActiveProducts = "FROM Product WHERE active = :active";
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectActiveProducts, Product.class)
						.setParameter("active", true)
							.getResultList();
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		String selectActiveProductsByCategory = "FROM Product WHERE active = :active AND categoryId = :categoryId";
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectActiveProductsByCategory, Product.class)
						.setParameter("active", true)
						.setParameter("categoryId",categoryId)
							.getResultList();
		
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		return sessionFactory
				.getCurrentSession()
					.createQuery("FROM Product WHERE active = :active ORDER BY productId", Product.class)
						.setParameter("active", true)
						.setFirstResult(0)
						.setMaxResults(count)
							.getResultList();
	}

}
