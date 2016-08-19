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

import com.niit.model.Userdetails;

@EnableTransactionManagement
@Repository("userdetailsDAO")
public class UserdetailsDAOImpl implements UserdetailsDAO {
	
	private static final Logger log = LoggerFactory.getLogger(UserdetailsDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	public UserdetailsDAOImpl(SessionFactory sessionFactory)
	{
	this.sessionFactory = sessionFactory;

	}
@Transactional
	public boolean save(Userdetails userdetails)
	{
	try {
		log.debug("starting of save method");
		sessionFactory.getCurrentSession().save(userdetails);
		log.debug("starting of save method");
		return true;
	}
	catch(Exception e)
	{
		log.error("Exception occured in save" +e.getMessage());
		e.printStackTrace();
		return false;
	}
	}
@Transactional
	public boolean update(Userdetails userdetails)
	{
	try {
		log.debug("starting of update method");
		sessionFactory.getCurrentSession().update(userdetails);
		log.debug("starting of update method");
		return true;
	}
	catch(Exception e)
	{
		log.error("Exception occured in update" +e.getMessage());
		e.printStackTrace();
		return false;
	}
	}
@Transactional
	public boolean delete(Userdetails userdetails)
	{
	try {
		log.debug("starting of delete method");
		sessionFactory.getCurrentSession().delete(userdetails);
		log.debug("starting of delete method");
		return true;
	}
	catch(Exception e)
	{
		log.error("Exception occured in delete" +e.getMessage());
		e.printStackTrace();
		return false;
	}
	}
@Transactional
public Userdetails get(String id)
{
	String hql = "from Userdetails where id= "+" '" +id+ "'";
	Query query =sessionFactory.getCurrentSession().createQuery(hql);
	List<Userdetails> list = query.list();
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
public List<Userdetails> list()
{
	String hql = "from Userdetails";
	Query query =sessionFactory.getCurrentSession().createQuery(hql);
	return query.list();
}
}

