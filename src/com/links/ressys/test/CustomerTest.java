package com.links.ressys.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.links.ressys.core.CustomerConcrete;

import junit.framework.TestCase;

public class CustomerTest extends TestCase{
	CustomerConcrete customerConcrete;

	@Before
	public void setUp() throws Exception {
		customerConcrete = new CustomerConcrete("PRSFLC90E09B408T",
				"Felice","Parisi","349 567 4345", "ginoPino90@gmail.com",
				4000_5328);
	}

	@Test
	public void testWorkingGetTaxCode() {
		assertEquals("PRSFLC90E09B408T", customerConcrete.getTaxCode());
	}

	@Test
	public void testWorkingSetTaxCode() {
		customerConcrete.setTaxCode("PRSFLC90E09B408T");
		assertEquals("PRSFLC90E09B408T", customerConcrete.getTaxCode());
	}

	@Test
	public void testWorkingGetName() {
		assertEquals("Felice", customerConcrete.getName());
	}

	@Test
	public void testWorkingSetName() {
		customerConcrete.setName("Felice");
		assertEquals("Felice", customerConcrete.getName());
	}

	@Test
	public void testWorkingGetSurname() {
		assertEquals("Parisi", customerConcrete.getSurname());
	}

	@Test
	public void tesWorkingSetSurname() {
		customerConcrete.setSurname("Parisi");
		assertEquals("Parisi", customerConcrete.getSurname());
	}

	@Test
	public void testWorkingGetCellPhoneNumber() {
		assertEquals("349 567 4345", customerConcrete.getCellPhoneNumber());
	}

	@Test
	public void testWorkingSetCellPhoneNumber() {
	    customerConcrete.setCellPhoneNumber("349 567 4345");
		assertEquals("349 567 4345", customerConcrete.getCellPhoneNumber());
	}

	@Test
	public void testWorkingGetMailAddress() {
		assertEquals("ginoPino90@gmail.com", customerConcrete.getMailAddress());
	}

	@Test
	public void testWorkingSetMailAddress() {
		customerConcrete.setMailAddress("ginoPino90@gmail.com");
		assertEquals("ginoPino90@gmail.com", customerConcrete.getMailAddress());

	}

	@Test
	public void testWorkingGetCardNumber() {
		assertEquals(4000_5328, customerConcrete.getCardNumber());


	}

	@Test
	public void testWorkingSetCardNumber() {
		customerConcrete.setCardNumber(4000_5328);
		assertEquals(4000_5328, customerConcrete.getCardNumber());
	}






}
