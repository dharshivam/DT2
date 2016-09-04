package com.niit.MobBackEnd.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.MobBackEnd.dao.CartDao;
import com.niit.MobBackEnd.dao.CartDaoImpl;
import com.niit.MobBackEnd.dao.CategoryDao;
import com.niit.MobBackEnd.dao.CategoryDaoImpl;
import com.niit.MobBackEnd.dao.ProductDao;
import com.niit.MobBackEnd.dao.ProductDaoImpl;
import com.niit.MobBackEnd.dao.SupplierDao;
import com.niit.MobBackEnd.dao.SupplierDaoImpl;
import com.niit.MobBackEnd.dao.UserDao;
import com.niit.MobBackEnd.dao.UserDaoImpl;
import com.niit.MobBackEnd.model.Cart;
import com.niit.MobBackEnd.model.Category;
import com.niit.MobBackEnd.model.Product;
import com.niit.MobBackEnd.model.Supplier;
import com.niit.MobBackEnd.model.UserDetails;
import com.niit.MobBackEnd.model.Users;







@Configuration
@ComponentScan("com.niit.*")
@EnableTransactionManagement

public class ApplicationContextConfig {
	
	 @Bean(name = "dataSource")
	    public DataSource getDataSource() {
	    	BasicDataSource dataSource = new BasicDataSource();
	    	dataSource.setDriverClassName("org.h2.Driver");
	    	dataSource.setUrl("jdbc:h2:tcp://localhost/~/cellDb");
	    	dataSource.setUsername("sa");
	    	dataSource.setPassword("");
	    	
	    	return dataSource;
	    }
	    
	  private Properties getHibernateProperties() {
	    	Properties properties = new Properties();
	    	properties.put("hibernate.show_sql", "true");
	    	properties.put("hibernate.format_sql", "true");
	    	properties.put("hibernate.hbm2ddl.auto", "update");
	    	properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
	    	return properties;
	    }
	    
	    @Autowired
	    @Bean(name = "sessionFactory")
	    public SessionFactory getSessionFactory(DataSource dataSource) {
	    	LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
	    	sessionBuilder.addProperties(getHibernateProperties());
	    	sessionBuilder.addAnnotatedClasses(Category.class);
	    	sessionBuilder.addAnnotatedClasses(Product.class);
	    	sessionBuilder.addAnnotatedClasses(Supplier.class);
	    	sessionBuilder.addAnnotatedClasses(Users.class);
	    	sessionBuilder.addAnnotatedClasses(UserDetails.class);
	    	sessionBuilder.addAnnotatedClasses(Cart.class);
	    	return sessionBuilder.buildSessionFactory();
	    }
	    
		@Autowired
		@Bean(name = "transactionManager")
		public HibernateTransactionManager getTransactionManager(
				SessionFactory sessionFactory) {
			HibernateTransactionManager transactionManager = new HibernateTransactionManager(
					sessionFactory);

			return transactionManager;
		}
	    
	    @Autowired
	    @Bean(name = "productDao")
	    public ProductDao geProductDao(SessionFactory sessionFactory) {
	    	return new ProductDaoImpl(sessionFactory);
	    }
	    
	    @Autowired
	    @Bean(name="categoryDao")
	    public CategoryDao getCategoryDao(SessionFactory sessionFactory)
	    {
	    	return new CategoryDaoImpl(sessionFactory);
	    }
	    
	    @Autowired
	    @Bean(name="supplierDao")
	    public SupplierDao getSuplierDao(SessionFactory sessionFactory)
	    {
	    	return new SupplierDaoImpl(sessionFactory);
	    }
	    @Autowired
	    @Bean(name="userDao")
	    public UserDao getUserDao(SessionFactory sessionFactory)
	    {
	    	return new UserDaoImpl(sessionFactory);
	    }

	    @Autowired
	    @Bean(name="cartDao")
	    public CartDao getCartDao(SessionFactory sessionFactory)
	    {
			return new CartDaoImpl(sessionFactory);
	    	
	    }

}
