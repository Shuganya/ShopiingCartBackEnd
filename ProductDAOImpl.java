package com.niit.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Product;

@EnableTransactionManagement
@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO{
	
	private static final Logger log= LoggerFactory.getLogger(ProductDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	public ProductDAOImpl(SessionFactory sessionFactory)
	{
	this.sessionFactory = sessionFactory;

	}
@Transactional
	public boolean save(Product product)
	{
	try {
		log.debug("starting of save method");
		sessionFactory.getCurrentSession().save(product);
		log.debug("Ending of save method");
		return true;
	}
	catch(Exception e)
	{
		log.error("exception occured in save method:" +e.getMessage());
		e.printStackTrace();
		return false;
	}
	}
@Transactional
	public boolean update(Product product)
	{
	try {
		log.debug("starting of update method");
		sessionFactory.getCurrentSession().update(product);
		log.debug("Ending of update method");

		return true;
	}
	catch(Exception e)
	{
		log.error("exception occured in update method:" +e.getMessage());
		e.printStackTrace();
		return false;
	}
	}
@Transactional
	public boolean delete(Product product)
	{
	try {
		log.debug("starting of delete method");
		sessionFactory.getCurrentSession().delete(product);
		log.debug("Ending of delete method");

		return true;
	}
	catch(Exception e)
	{
		log.error("exception occured in delete method:" +e.getMessage());
		e.printStackTrace();
		return false;
	}
	}
@Transactional
public Product get(String id)
{
	String hql = "from Product where id="+" '"+id+"'";
	Query query =sessionFactory.getCurrentSession().createQuery(hql);
	List<Product> list = query.list();
	if(list == null || list.isEmpty())
	{
		return null;
	}
	else
	{
		return list.get(0);
	}
}
@Transactional
public List<Product> list()
{
	String hql = "from Product";
	Query query =sessionFactory.getCurrentSession().createQuery(hql);
	return query.list();
}

}
