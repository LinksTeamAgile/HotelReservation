/**
 *
 */
package com.links.ressys.test;

import com.links.ressys.core.RoomConcrete;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

/**
 * @author userm03
 *
 */
public class RoomTest extends TestCase{
	String[] services = new String[1];
	RoomConcrete roomConcrete;

	@Before
	public void setUp() throws Exception {
		services[0] = "fridge";
		roomConcrete = new RoomConcrete(1,true,true,2,services);
	}

	@Test
	public void testWorkingGetRoomId() {
		assertEquals(1, roomConcrete.getRoomId());
	}

	@Test
	public void testWorkingSetRoomId() {
		roomConcrete.setRoomId(1);
		assertEquals(1, roomConcrete.getRoomId());
	}

	@Test
	public void testWorkingSetServiceable() {
		roomConcrete.setServiceable(true);
		assertEquals(true, roomConcrete.isServiceable());
	}

	@Test
	public void testWorkingsetAvailable() {
		roomConcrete.setServiceable(true);
		assertEquals(true, roomConcrete.isServiceable());
	}

	@Test
	public void testWorkingGetMaxGuests() {
		assertEquals(2, roomConcrete.getMaxGuests());
	}

	@Test
	public void tesWorkingSetMaxGuests() {
		roomConcrete.setMaxGuests(2);
		assertEquals(2, roomConcrete.getMaxGuests());
	}

	@Test
	public void testWorkingGetServices() {
		String[] services = roomConcrete.getServices();
		assertEquals("fridge", services[0]);
	}

	@Test
	public void testWorkingSetServices() {
		String[] services = {"fridge"};
	    roomConcrete.setServices(services);
		assertEquals("fridge", services[0]);
	}
}
