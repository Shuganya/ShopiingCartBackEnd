package com.niit.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Category;
@EnableTransactionManagement
@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
	private static final Logger log= LoggerFactory.getLogger(CategoryDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	public CategoryDAOImpl(SessionFactory sessionFactory)
	{
	this.sessionFactory = sessionFactory;

	}
@Transactional
	public boolean save(Category category)
	{
	try {
		log.debug("starting of save method");
		sessionFactory.getCurrentSession().save(category);
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
	public boolean update(Category category)
	{
	try {
		log.debug("starting of update method");
		sessionFactory.getCurrentSession().update(category);
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
	public boolean delete(Category category)
	{
	try {
		log.debug("starting of delete method");
		sessionFactory.getCurrentSession().delete(category);
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
public Category get(String id)
{
	String hql = "from Category where id="+" '" +id+ "'";
	Query query =sessionFactory.getCurrentSession().createQuery(hql);
	List<Category> list = query.list();
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
public List<Category> list()
{
	String hql = "from Category";
	Query query =sessionFactory.getCurrentSession().createQuery(hql);
	return query.list();
}
}
