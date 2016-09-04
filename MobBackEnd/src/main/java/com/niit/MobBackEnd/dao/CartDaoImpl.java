package com.niit.MobBackEnd.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.MobBackEnd.model.Cart;
@Repository("cartDao")
public class CartDaoImpl implements CartDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	public CartDao cartDao;
	
	@Autowired
	Cart cart;
	
	public CartDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}

	@Transactional
	public void SaveOrUpdate(Cart cart) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(cart);
		
	}
	
	@Transactional
	public List<Cart> list() {
		@SuppressWarnings("unchecked")
		List<Cart> listCart = (List<Cart>) sessionFactory.getCurrentSession()
				.createCriteria(Cart.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		        return listCart;
	}
	@Transactional
	public void delete(String id) {
		Cart CartToDelete = new Cart();
//		CartToDelete.setCart_id(id);
		sessionFactory.getCurrentSession().delete(CartToDelete);
	}
	@Transactional
	public Cart getCart(String id) {
		String hql = "from Cart where user_id=" + id;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Cart> listCart = (List<Cart>) query.list();
		
		if (listCart != null && !listCart.isEmpty()) {
			return listCart.get(0);
		}
		
		return null;
	}

}
