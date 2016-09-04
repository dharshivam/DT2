package com.niit.MobBackEnd.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.MobBackEnd.model.Supplier;



@Repository("supplierDao")
public class SupplierDaoImpl implements SupplierDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	Supplier supplier;
	
	public SupplierDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	@Transactional
	public List<Supplier> list() {
		@SuppressWarnings("unchecked")
		List<Supplier> listSupplier = (List<Supplier>) sessionFactory.getCurrentSession()
				.createCriteria(Supplier.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		        return listSupplier;
	}
	@Transactional
	public void saveOrUpdate(Supplier supplier) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(supplier);
		
	}
	public Supplier get(String id) {
		String hql = "from Supplier where id='" + id+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Supplier> listSupplier = (List<Supplier>) query.list();
		
		if (listSupplier != null && !listSupplier.isEmpty()) {
			return listSupplier.get(0);
		}
		return null;
	}
	public void delete(String id) {
		Supplier SupplierToDelete = new Supplier();
		SupplierToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(SupplierToDelete);
		
	}
	
}
