package com.links.ressys.controller;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import com.links.ressys.Sys;
import com.links.ressys.core.Reservation;
import com.links.ressys.gui.Gui;

public class ControllerConcrete extends Controller {

	public ControllerConcrete(Sys sys, Gui gui) {
		super(sys, gui);
	}


	private int controlIfInteger(String s){
		try {
			int checkedInt = Integer.parseInt(s);
			return checkedInt;
		} catch(NumberFormatException e) {
			return -1;
		}

	}

	private String[] transformInArray(String s){
		String[] array = s.split(",");
		ArrayList list = new ArrayList();
		int i = 0;
		for(String str : array) {
			list.add(str.trim());
		}
		String[] strings = new String[list.size()];
		list.toArray(array);
		return array;

	}

	private int[] transformInInteger(String s) {
		String[] array = s.split(",");
		int[] intArray;
		ArrayList<String> list = new ArrayList();
		int i = 0;
		for (String str : array) {
			list.add(str.trim());
		}
		String[] strings = new String[list.size()];
		intArray = new int[list.size()];
		i = 0;
		for(String x : list) {
			try {
				intArray[i++] = Integer.parseInt(x);
			} catch(NumberFormatException e) {
				return null;
			}
		}
		return intArray;
	}

	private String controlIfDate(String s){
		try {
			String parsedDate = LocalDate.parse(s).toString();
			return parsedDate;
		} catch (DateTimeParseException e) {
			return null;
		}
	}

	protected void makeCreateRoom(){
		int maxGuest = -1;
		while(maxGuest == -1){
			maxGuest = this.controlIfInteger(this.gui.getInput("Max guest for room (numeric value): "));
		}
		String[] services = this.transformInArray(this.gui.getInput("Insert services (separated by comma): "));
		super.sys.createRoom(maxGuest, services);
		if(!super.sys.isThereAnError()) {
			System.out.println("Room created");
		} else {
			this.prinErrors(super.sys.getLastErrors());
			System.out.println("Room not created");
		}
	}

	@Override
	protected void makeDeleteRoom() {
		int idRoom = this.controlIfInteger(this.gui.getInput("Insert the ID room to delete: "));
		if(idRoom == -1){
			System.out.println("Not valid idRoom: insert a numeric value");
		} else {
			if(super.sys.deleteRoom(idRoom)){
				System.out.println("Room with ID "+idRoom+" deleted ");
			}else{
				System.out.println("The room with ID "+idRoom+" has not found");
			}
		}
	}

	@Override
	protected void makeShowRooms() {
		this.sys.showRoom(null);
	}

	@Override
	protected void makeCreateCustomer(){
		String taxCode = this.gui.getInput("Insert tax code:");
		String name = this.gui.getInput("Insert name:");
		String surName = this.gui.getInput("Insert surname:");
		String cellPhone = this.gui.getInput("Insert phone number:");
		String mail = this.gui.getInput("Insert email:");
		String cardNumber = this.gui.getInput("Insert card number:");
		super.sys.createCustomer(taxCode, name, surName, cellPhone, mail, cardNumber);
		if (!super.sys.isThereAnError()) {
			System.out.println("Customer created successfully!");
		} else {
			this.prinErrors(super.sys.getLastErrors());
			System.out.println("Customer not created!");
		}
	}

	@Override
	protected void makeDeleteCustomer() {
		String es1=this.gui.getInput("Insert the mail address of the customer to delete: ");
		if(super.sys.deleteCustomer(es1)){
			System.out.println("Customer with mail address "+es1+" deleted ");
		}else{
			System.out.println("The mail address "+es1+" has not found");
		}
	}

	@Override
	protected void makeShowCustomers() {
		super.sys.showCustomer(null);
	}

	@Override
	protected Reservation makeCreateReservation(boolean onDb){
		int countTries = 0;
		String idCostumer = super.gui.getInput("Please insert the customer's email: ");
		int maxGuests = Integer.parseInt(super.gui.getInput("Please insert the number of guests: "));
		this.sys.showRoom(s -> s.getMaxGuests() <= maxGuests);
		int[] idRoom = this.transformInInteger(this.gui.getInput("Insert the ID room: "));
		while (idRoom == null) {
			idRoom = this.transformInInteger(this.gui.getInput("Insert the ID room: "));
			if(countTries++ == 5)
				return null;
		}
		System.out.println(idRoom);
		LocalDate[] dates = getDatesFromKeyboard();

		Reservation res = super.sys.createReservation(idCostumer, idRoom, dates[0], dates[1], onDb);
		if (!super.sys.isThereAnError()) {
			System.out.println("Reservation created successfully!");
		} else {
			this.prinErrors(super.sys.getLastErrors());
			System.out.println("Reservation not created!");
		}
		return res;
	}

	protected void makeDeleteReservation() {
		int reservationId = this.controlIfInteger(this.gui.getInput("Insert the ID reservation to update: "));
		if(reservationId == -1)
			System.out.println("Insert a correct ID.");
		else {
			if (super.sys.deleteReservation(reservationId)) {
				System.out.println("Reservation with ID " + reservationId + " deleted ");
			} else {
				System.out.println("The reservation with ID " + reservationId + " has not been found");
			}
		}
	}


	@Override
	protected void makeShowReservations() {
		super.sys.showReservation(null);
	}

	@Override
	protected void makeCloseApp() {
		System.out.println("Closing app");
		System.exit(0);

	}

	@Override
	protected void wrongChoose() {
		System.out.println("Selected item from menu' can't be used");

	}

	private <T> void prinErrors(Iterator<T> it){
		System.out.println("ERRORS");
		while(it.hasNext()){
			System.out.print(it.next()+" ");
		}
		System.out.println("===========");
	}


	private LocalDate[] getDatesFromKeyboard(){
		Scanner keyboard = new Scanner(System.in);
		boolean continueScanneringUserInput = true;
		LocalDate[] scanneredDates = new LocalDate[2];
		String[] scanneredDate = new String[2];
		int scannerCounter = 0;
		int startDate[] = new int[3];
		int endDate[] = new int[3];

		while(continueScanneringUserInput == true){
			try{
				if(scannerCounter == 0){
					System.out.println("Please insert a start date using the YYYY-MM-DD format: ");
					scanneredDate[0] = keyboard.nextLine();
					if((scanneredDate[0].isEmpty() == true) || (scanneredDate[0].matches("\\d{4}-[01]\\d-[0-3]\\d") == false)){
						System.out.println("Choice not valid!\nPlease enter a vail date");
					} else {
						scannerCounter += 1;
					}
				}
				else{
					System.out.println("Please insert an end date using the YYYY-MM-DD format: ");
					scanneredDate[1] = keyboard.nextLine();
					if((scanneredDate[1].isEmpty() == true) || (scanneredDate[0].matches("\\d{4}-[01]\\d-[0-3]\\d") == false)){
						System.out.println("Choice not valid!\nPlease enter a vail date");
					} else {
						scannerCounter += 1;
						continueScanneringUserInput = false;
					}
				} 
			} catch (InputMismatchException ex){
				System.out.println("User input is not a valid value for this method.");
				System.out.println("Exception caught: User cannot put that value as menu choice.");
				continueScanneringUserInput = false;
			}
		}

		String[] start = new String[3];
		start = scanneredDate[0].split("-");
		for(int i=0; i<3; i++){
			startDate[i] = Integer.parseInt(start[i]);
		}

		String[] end = new String[3];
		end = scanneredDate[1].split("-");
		for(int i=0; i<3; i++){
			endDate[i] = Integer.parseInt(end[i]);
		}

		scanneredDates[0] = LocalDate.of(startDate[0], startDate[1], startDate[2]);
		scanneredDates[1] = LocalDate.of(endDate[0], endDate[1], endDate[2]);

		return scanneredDates;
	}


	@Override
	protected void makeUpdateReservation() {
		int idRes = this.controlIfInteger(this.gui.getInput("Which Reservation do you want to update? (id)"));
		if(idRes == -1){
			System.out.println("Insert a numeric value for id!");
		}
		Reservation resNew = this.makeCreateReservation(false);
		if (super.sys.updateReservation(resNew, idRes)) {
			System.out.println("Reservation with ID " + idRes + " updated ");
		} else {
			System.out.println("The reservation with ID " + idRes + " not updated");
		}

	}

}

