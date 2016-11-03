package com.links.ressys.gui;

import java.io.Closeable;
import java.util.NoSuchElementException;
import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class GuiBash.
 */
public class GuiBash implements Gui, Closeable, AutoCloseable {
	
	/** The keyboard. */
	private Scanner keyboard = new Scanner(System.in);

	/* (non-Javadoc)
	 * @see com.links.ressys.gui.Gui#open()
	 */
	@Override
	public void open() {
		this.viewMenu();
	}

	/* (non-Javadoc)
	 * @see com.links.ressys.gui.Gui#close()
	 */
	@Override
	public void close() {
		keyboard.close();
	}

	/* (non-Javadoc)
	 * @see com.links.ressys.gui.Gui#getInput(java.lang.String)
	 */
	@Override
	public String getInput(String message) {
		try{
			System.out.println(message);
			return keyboard.next();
		} catch (NoSuchElementException ex) {
			System.out.println("User input is not a valid value for this method.");
			System.out.println("Exception caught: User cannot put that value as menu choice.");
			System.exit(-1);
			return "";
		}
	}
	
	/* (non-Javadoc)
	 * @see com.links.ressys.gui.Gui#viewMenu()
	 */
	@Override
	public void viewMenu(){
		System.out.println("Menu'");
		System.out.println("1 - Create room.");
		System.out.println("2 - Delete room.");
		System.out.println("3 - Show rooms.");
		System.out.println("4 - Create customer.");
		System.out.println("5 - Delete customer.");
		System.out.println("6 - Show customers.");
		System.out.println("7 - Create reservation.");
//		System.out.println("8 - Modify reservation.");
//		System.out.println("9 - Show reservations.");
		System.out.println("0 - Exit");
	}

}
