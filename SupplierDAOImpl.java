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

import com.niit.model.Supplier;
@EnableTransactionManagement
@Repository("supplierDAO")
public class SupplierDAOImpl implements SupplierDAO {
	
	private static final Logger log = LoggerFactory.getLogger(SupplierDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	public SupplierDAOImpl(SessionFactory sessionFactory)
	{
	this.sessionFactory = sessionFactory;

	}
@Transactional
	public boolean save(Supplier supplier)
	{
	try {
		log.debug("Starting of the save method");
		sessionFactory.getCurrentSession().save(supplier);
		log.debug("Ending of the save method");
		return true;
	}
	catch(Exception e)
	{
		log.error("Exception occured in save method" +e.getMessage());
		e.printStackTrace();
		return false;
	}
	}
@Transactional
	public boolean update(Supplier supplier)
	{
	try {
		log.debug("Starting of the update method");
		sessionFactory.getCurrentSession().update(supplier);
		log.debug("Ending of the update method");
		return true;
	}
	catch(Exception e)
	{
		log.error("Exception occured in update method" +e.getMessage());
		e.printStackTrace();
		return false;
	}
	}
@Transactional
	public boolean delete(Supplier supplier)
	{
	try {
		log.debug("Starting of the delete method");
		sessionFactory.getCurrentSession().delete(supplier);
		log.debug("Ending of the delete method");
		return true;
	}
	catch(Exception e)
	{
		log.error("Exception occured in delete method" +e.getMessage());
		e.printStackTrace();
		return false;
	}
	}
@Transactional
public Supplier get(String id)
{
	String hql = "from Supplier where id="+" '"+id+"'";
	Query query =sessionFactory.getCurrentSession().createQuery(hql);
	List<Supplier> list = query.list();
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
public List<Supplier> list()
{
	String hql = "from Supplier";
	Query query =sessionFactory.getCurrentSession().createQuery(hql);
	return query.list();
}

}
