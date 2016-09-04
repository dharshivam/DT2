package com.niit.MobBackEnd.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.MobBackEnd.model.Product;
@Repository("productDao")
public class ProductDaoImpl implements ProductDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	public Product product;

	public ProductDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Transactional
	public List<Product> list() {
		@SuppressWarnings("unchecked")
		List<Product> listProduct = (List<Product>) sessionFactory.getCurrentSession()
		.createCriteria(Product.class)
		.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        return listProduct;
	}
	@Transactional
	public Product getPro(String id) {
		String hql = "from Product where id='" + id+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Product> listProduct = (List<Product>) query.list();
		
		if (listProduct != null && !listProduct.isEmpty()) {
			return listProduct.get(0);
		}
		return null;
	}
	@Transactional
	public void saveOrUpdate(Product product) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(product);
		
	}
	@Transactional
	public void delete(String id) {
		Product ProductToDelete = new Product();
		ProductToDelete.setPid(id);
		sessionFactory.getCurrentSession().delete(ProductToDelete);
		
	}

}
