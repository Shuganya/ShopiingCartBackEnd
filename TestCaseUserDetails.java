package com.niit.shoppingcartbackend;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.niit.dao.UserdetailsDAO;

import com.niit.model.Userdetails;

public class TestCaseUserDetails {

	@Autowired
	UserdetailsDAO userdetailsDAO;
	
	@Autowired
	Userdetails userdetails;
	
	AnnotationConfigApplicationContext context;
	
	@Before
	public void init()
	{
	context = new AnnotationConfigApplicationContext();
	context.scan("com.niit");
	context.refresh();
	
	userdetailsDAO =  (UserdetailsDAO) context.getBean("userdetailsDAO");
	userdetails = (Userdetails) context.getBean("userdetails");
	}
	
	@Test
	public void addUserDetailsTestCase()
	{
		userdetails.setId("user_002");
		userdetails.setFname("shugi");
		userdetails.setLname("R");
		userdetails.setEmail("shugi@gmail.com");
		userdetails.setContact("7401581209");
		userdetails.setPassword("12345");
		userdetails.setConpass("12345");
		
		
		assertEquals("addUserDetailsTestCase", userdetailsDAO.save(userdetails),true);
	}
	
	public void deleteUserDetailsTestCase()
	{
		userdetails.setId("user_002");
	boolean flag = userdetailsDAO.delete(userdetails);
	assertEquals("deleteUserDetailsTestCase",flag, true);
	}

	@Test
	public void userdetailsGetTestCase()
	{
		userdetails = userdetailsDAO.get("user_001");
		System.out.println(userdetails.getFname());
		System.out.println(userdetails.getLname());
		System.out.println(userdetails.getEmail());
			
		assertEquals(userdetails.getFname(), "ram");
	}
	@Test
	public void userdetailsListTestCase()
	{
		
		assertEquals("UserdetailsListTestCase", userdetailsDAO.list().size(),1);	
	}
	@Test
	public void userdetailsupdateTestCase()
	{
		userdetails.setId("user_001");
		userdetails.setFname("ram");
		userdetails.setLname("S");
		userdetails.setEmail("ram@gmail.com");
		userdetails.setContact("8220153895");
		userdetails.setPassword("123456");
		userdetails.setConpass("123456");
		assertEquals("updateProductTestCase", userdetailsDAO.update(userdetails), true);
		}

		
	}


