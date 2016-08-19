package com.niit.shoppingcartbackend;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.ProductDAO;
import com.niit.model.Product;

public class TestCaseProduct {

	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	Product product;
	
	AnnotationConfigApplicationContext context;
	
	@Before
	public void init()
	{
	context = new AnnotationConfigApplicationContext();
	context.scan("com.niit");
	context.refresh();
	
	productDAO = (ProductDAO) context.getBean("productDAO");
	product = (Product) context.getBean("product");
	}
	
	@Test
	public void addProductTestCase()
	{
		product.setId("mob_005");
		product.setName("lenova");
		product.setPrice(5000);
		product.setDescription("mobile phone");
		
		assertEquals("addProductTestCase", productDAO.save(product),true);
	}
	@Test
	public void listProductTestCase()
	{
		assertEquals("addProductTestCase", productDAO.list().size(),3);
	}
	
	@Test
	public void deleteProductTestCase()
	{
		product.setId("mob_003");
	boolean flag = productDAO.delete(product);
	assertEquals("deleteProductTestCase",flag, true);
	}
	
	@Test
	public void updateProductTestCase()
	{
	product.setId("mob_004");
	product.setPrice(50000);
	assertEquals("updateProductTestCase", productDAO.update(product), true);
	}
	
	@Test
	public void getProductTestCase()
	{
		assertEquals("getProductTestCase", productDAO.get("mob_005"), null);
	}
	
	
}



