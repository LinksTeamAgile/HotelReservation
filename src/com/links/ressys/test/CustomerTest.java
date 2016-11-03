package com.links.ressys.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.links.ressys.core.CustomerConcrete;

import junit.framework.TestCase;

// TODO: Auto-generated Javadoc
/**
 * The Class CustomerTest.
 */
public class CustomerTest extends TestCase{
	
	/** The customer concrete. */
	CustomerConcrete customerConcrete;

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Before
	public void setUp() throws Exception {
		customerConcrete = new CustomerConcrete("PRSFLC90E09B408T",
				"Felice","Parisi","349 567 4345", "ginoPino90@gmail.com",
				"4000_5328");
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	@After
	public void tearDown() {
		customerConcrete = null;
	}
	
	/**
	 * Test working get tax code.
	 */
	@Test
	public void testWorkingGetTaxCode() {
		assertEquals("PRSFLC90E09B408T", customerConcrete.getTaxCode());
	}

	/**
	 * Test working set tax code.
	 */
	@Test
	public void testWorkingSetTaxCode() {
		customerConcrete.setTaxCode("PRSFLC90E09B408T");
		assertEquals("PRSFLC90E09B408T", customerConcrete.getTaxCode());
	}

	/**
	 * Test working get name.
	 */
	@Test
	public void testWorkingGetName() {
		assertEquals("Felice", customerConcrete.getName());
	}

	/**
	 * Test working set name.
	 */
	@Test
	public void testWorkingSetName() {
		customerConcrete.setName("Felice");
		assertEquals("Felice", customerConcrete.getName());
	}

	/**
	 * Test working get surname.
	 */
	@Test
	public void testWorkingGetSurname() {
		assertEquals("Parisi", customerConcrete.getSurname());
	}

	/**
	 * Tes working set surname.
	 */
	@Test
	public void tesWorkingSetSurname() {
		customerConcrete.setSurname("Parisi");
		assertEquals("Parisi", customerConcrete.getSurname());
	}

	/**
	 * Test working get cell phone number.
	 */
	@Test
	public void testWorkingGetCellPhoneNumber() {
		assertEquals("349 567 4345", customerConcrete.getCellPhoneNumber());
	}

	/**
	 * Test working set cell phone number.
	 */
	@Test
	public void testWorkingSetCellPhoneNumber() {
	    customerConcrete.setCellPhoneNumber("349 567 4345");
		assertEquals("349 567 4345", customerConcrete.getCellPhoneNumber());
	}

	/**
	 * Test working get mail address.
	 */
	@Test
	public void testWorkingGetMailAddress() {
		assertEquals("ginoPino90@gmail.com", customerConcrete.getMailAddress());
	}

	/**
	 * Test working set mail address.
	 */
	@Test
	public void testWorkingSetMailAddress() {
		customerConcrete.setMailAddress("ginoPino90@gmail.com");
		assertEquals("ginoPino90@gmail.com", customerConcrete.getMailAddress());

	}

	/**
	 * Test working get card number.
	 */
	@Test
	public void testWorkingGetCardNumber() {
		assertEquals("4000_5328", customerConcrete.getCardNumber());

	}

	/**
	 * Test working set card number.
	 */
	@Test
	public void testWorkingSetCardNumber() {
		customerConcrete.setCardNumber("4000_5328");
		assertEquals("4000_5328", customerConcrete.getCardNumber());
	}
}