package com.niit.shoppingcartbackend;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CategoryDAO;
import com.niit.model.Category;

public class TestCaseCategory {
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	Category category;
	
	AnnotationConfigApplicationContext context;
	
	@Before
	public void init()
	{
	context = new AnnotationConfigApplicationContext();
	context.scan("com.niit");
	context.refresh();
	
	categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	category = (Category) context.getBean("category");
	}
	@Test
	public void categoryListTestCase()
	{
		
		assertEquals("CategoryListTestCase", categoryDAO.list().size(),6);

		
	}
	@Test
	public void deleteCategoryTestCase()
	{
		category.setId("mob_01");
	boolean flag = categoryDAO.delete(category);
	assertEquals("deleteCategoryTestCase",flag, true);
	}

	@Test
	public void categoryAddTestCase()
	{
		category.setId("mob_10");
		category.setName("micro");
		category.setDescription("description");
		
		assertEquals("categoryAddTestCase", categoryDAO.save(category),true);

		
	}
	
	@Test
	public void updateCategoryTestCase()
	{
	
	category.setName("mobile");
	category.setDescription("category");
	
	assertEquals("updateCategoryTestCase", categoryDAO.update(category), false);
	}
	
	@Test
	public void categoryGetTestCase()
	{
		category = categoryDAO.get("101");
		System.out.println(category.getDescription());
		System.out.println(category.getName());
		
		assertEquals(category.getName(), "iphone");
	}
	}
