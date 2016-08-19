package com.niit.shoppingcartbackend;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.SupplierDAO;
import com.niit.model.Supplier;

public class TestCaseSupplier {

	@Autowired
	SupplierDAO supplierDAO;
	
	@Autowired
	Supplier supplier;
	
	AnnotationConfigApplicationContext context;
	
	@Before
	public void init()
	{
	context = new AnnotationConfigApplicationContext();
	context.scan("com.niit");
	context.refresh();
	
	supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
	supplier = (Supplier) context.getBean("supplier");
	}
	@Test
	public void supplierListTestCase()
	{
	
		assertEquals("SupplierListTestCase", supplierDAO.list().size(),2);

	
	}
	@Test
	public void SupplierAddTestCase()
	{
		supplier.setId("Sup003");
		supplier.setName("vasu");
		supplier.setAddress("madurai");
		
		assertEquals("SupplierAddTestCase", supplierDAO.save(supplier),true);

		
	}
	@Test
	public void deleteSupplierTestCase()
	{
		supplier.setId("Sup002");
	boolean flag = supplierDAO.delete(supplier);
	assertEquals("deleteSupplierTestCase",flag, true);
	}
	
	
	@Test
	public void supplierGetTestCase()
	{
		supplier = supplierDAO.get("Sup001");
		System.out.println(supplier.getAddress());
		System.out.println(supplier.getName());
		
		assertEquals(supplier.getName(), "shugi");
	}
	
	@Test
	public void updateSupplierTestCase()
	{
	
	supplier.setName("Sup001");
	supplier.setAddress("salem");
	
	assertEquals("updateSupplierTestCase", supplierDAO.update(supplier), false);
	}


}



