package com.links.ressys.controller;

import com.links.ressys.Sys;
import com.links.ressys.gui.Gui;

// TODO: Auto-generated Javadoc
/**
 * The Class Controller.
 */
public abstract class Controller {
	
	/** The sys. */
	protected Sys sys;
	
	/** The gui. */
	protected Gui gui;
	
	/**
	 * Instantiates a new controller.
	 *
	 * @param sys the sys
	 * @param gui the gui
	 */
	public Controller(Sys sys, Gui gui){
		this.sys = sys;
		this.gui = gui;
	}
	
	/**
	 * Start.
	 */
	public void start() {
		int choice = 0;

		this.gui.open();

		while (true) {
			choice = Integer.valueOf(this.gui.getInput("Make a choice:"));
			switch (choice) {
			case 1:
				this.makeCreateRoom();
				break;
			case 2:
				this.makeDeleteRoom();
				break;
			case 3:
				this.makeShowRooms();
				break;
			case 4:
				this.makeCreateCustomer();
				break;
			case 5:
				this.makeDeleteCustomer();
				break;
			case 6:
				this.makeShowCustomers();				
				break;
			case 7:
				this.makeCreateReservation();
				break;
			case 8:
				this.makeModifyReservation();
				break;
			case 9:
				this.makeShowReservations();	
				break;
			case 0:
				this.makeCloseApp();
				break;
			default:
				this.wrongChoose();
				break;
			}
			this.gui.viewMenu();
		}
	}
	
	/**
	 * Make create room.
	 */
	protected abstract void makeCreateRoom();
	
	/**
	 * Make delete room.
	 */
	protected abstract void makeDeleteRoom();
	
	/**
	 * Make show rooms.
	 */
	protected abstract void makeShowRooms();
	
	/**
	 * Make create customer.
	 */
	protected abstract void makeCreateCustomer();
	
	/**
	 * Make delete customer.
	 */
	protected abstract void makeDeleteCustomer();
	
	/**
	 * Make show customers.
	 */
	protected abstract void makeShowCustomers();
	
	/**
	 * Make create reservation.
	 */
	protected abstract void makeCreateReservation();
	
	/**
	 * Make modify reservation.
	 */
	protected abstract void makeModifyReservation();
	
	/**
	 * Make show reservations.
	 */
	protected abstract void makeShowReservations();
	
	/**
	 * Make close app.
	 */
	protected abstract void makeCloseApp();
	
	/**
	 * Wrong choose.
	 */
	protected abstract void wrongChoose();

}
