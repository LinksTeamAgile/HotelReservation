/**
 *
 */
package com.links.ressys.test;

import com.links.ressys.core.RoomConcrete;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

// TODO: Auto-generated Javadoc
/**
 * The Class RoomTest.
 *
 * @author userm03
 */
public class RoomTest extends TestCase{
	
	/** The services. */
	String[] services = new String[1];
	
	/** The room concrete. */
	RoomConcrete roomConcrete;

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Before
	public void setUp() throws Exception {
		services[0] = "fridge";
		roomConcrete = new RoomConcrete(1,true,true,2,services);
	}

	/**
	 * Test working get room id.
	 */
	@Test
	public void testWorkingGetRoomId() {
		assertEquals(1, roomConcrete.getRoomId());
	}

	/**
	 * Test working set room id.
	 */
	@Test
	public void testWorkingSetRoomId() {
		roomConcrete.setRoomId(1);
		assertEquals(1, roomConcrete.getRoomId());
	}

	/**
	 * Test working set serviceable.
	 */
	@Test
	public void testWorkingSetServiceable() {
		roomConcrete.setServiceable(true);
		assertEquals(true, roomConcrete.isServiceable());
	}

	/**
	 * Test workingset available.
	 */
	@Test
	public void testWorkingsetAvailable() {
		roomConcrete.setServiceable(true);
		assertEquals(true, roomConcrete.isServiceable());
	}

	/**
	 * Test working get max guests.
	 */
	@Test
	public void testWorkingGetMaxGuests() {
		assertEquals(2, roomConcrete.getMaxGuests());
	}

	/**
	 * Tes working set max guests.
	 */
	@Test
	public void tesWorkingSetMaxGuests() {
		roomConcrete.setMaxGuests(2);
		assertEquals(2, roomConcrete.getMaxGuests());
	}

	/**
	 * Test working get services.
	 */
	@Test
	public void testWorkingGetServices() {
		String[] services = roomConcrete.getServices();
		assertEquals("fridge", services[0]);
	}

	/**
	 * Test working set services.
	 */
	@Test
	public void testWorkingSetServices() {
		String[] services = {"fridge"};
	    roomConcrete.setServices(services);
		assertEquals("fridge", services[0]);
	}
}
