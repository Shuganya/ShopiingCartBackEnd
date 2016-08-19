package com.niit.shoppingcartbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CategoryDAO;
import com.niit.model.Category;

public class CategoryTest {
public static void main(String[] args) {
		

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("com.niit");
		context.refresh();
		
		CategoryDAO categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
		Category category = (Category)context.getBean("category");
		
		category.setId("CG005");
		category.setName("CGName005");
		category.setDescription("Description");
		
		if(categoryDAO.save(category) == true)
		{
			System.out.println("category created successfully");
		}
		else
		{
			System.out.println("category not created");
		}
		
		
	}
	
	

}
