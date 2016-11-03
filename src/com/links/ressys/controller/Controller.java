package com.links.ressys.controller;

import com.links.ressys.Sys;
import com.links.ressys.gui.Gui;

public abstract class Controller {
	
	protected Sys sys;
	protected Gui gui;
	
	public Controller(Sys sys, Gui gui){
		this.sys = sys;
		this.gui = gui;
	}
	
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
	
	protected abstract void makeCreateRoom();
	protected abstract void makeDeleteRoom();
	protected abstract void makeShowRooms();
	protected abstract void makeCreateCustomer();
	protected abstract void makeDeleteCustomer();
	protected abstract void makeShowCustomers();
	protected abstract void makeCreateReservation();
	protected abstract void makeModifyReservation();
	protected abstract void makeShowReservations();
	protected abstract void makeCloseApp();
	protected abstract void wrongChoose();

}
