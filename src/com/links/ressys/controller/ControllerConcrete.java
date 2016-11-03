package com.links.ressys.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import com.links.ressys.Sys;
import com.links.ressys.gui.Gui;

public class ControllerConcrete extends Controller {

	public ControllerConcrete(Sys sys, Gui gui) {
		super(sys, gui);
	}

	protected void makeCreateRoom(){
		int maxGuests = getRoomGuestsFromKeyboard();
		String[] services = getRoomServicesFromKeyboard();
		int codeOperation = 0;
		for (String service : services) {
			if (!service.equals(null) && maxGuests != 0 && maxGuests != -1) {
				codeOperation = 100;
			} else {
				codeOperation = 200;
			}
		}
		if(codeOperation == 100){
			super.sys.createRoom(maxGuests, services);
			if (!super.sys.isThereAnError()) {
				System.out.println("Room created successfully!");
			} else {
				this.prinErrors(super.sys.getLastErrors());
				System.out.println("Room not created!");
			}
		}
	}
	
	@Override
	protected void makeDeleteRoom() {
		String es=this.gui.getInput("Insert the ID room to delete: ");
		int idRoom=Integer.parseInt(es);
		if(super.sys.deleteRoom(idRoom)){
			System.out.println("Room with ID "+idRoom+" deleted ");
		}else{
			System.out.println("The room with ID "+idRoom+" has not found");
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
	protected void makeCreateReservation(){
		String idCostumer = super.gui.getInput("Please insert the customer's email: ");
		int[] idRoom = getRoomIdFromKeyboard();
		LocalDate[] dates = getDatesFromKeyboard();
		super.sys.createReservation(idCostumer, idRoom, dates[0], dates[1]);
		if (!super.sys.isThereAnError()) {
			System.out.println("Reservation created successfully!");
		} else {
			this.prinErrors(super.sys.getLastErrors());
			System.out.println("Reservation not created!");
		}
	}

	@Override
	protected void makeModifyReservation() {
		String es2=this.gui.getInput("Insert the ID reservation to delete: ");
		int idReservation=Integer.parseInt(es2);
		if(super.sys.deleteReservation(idReservation)){
			System.out.println("Reservation with ID "+idReservation+" deleted ");
		}else{
			System.out.println("The reservation ID "+idReservation+" has not found");
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


	
	
	
	private int getRoomGuestsFromKeyboard() {
		boolean continueScanneringUserInput = true;
		int scanneredNumber = 0;
		Scanner keyboard = new Scanner(System.in);

		while (continueScanneringUserInput == true) {
			System.out.println("Please enter the number of guests: ");
			try {
				scanneredNumber = keyboard.nextInt();
				if (scanneredNumber <= 0 || scanneredNumber > 5) {
					System.out.println("Choice not valid!\nPlease entered a number of guests between 1 and 5.");
				} else {
					continueScanneringUserInput = false;
				}
			} catch (InputMismatchException ex) {
				System.out.println("User input is not a valid value for this method.");
				System.out.println("Exception caught: User cannot put that value as menu choice.");
				continueScanneringUserInput = false;
				scanneredNumber = -1;
			}
		}

		return scanneredNumber;
	}

	private String[] getRoomServicesFromKeyboard() {
		int serviceCounter = 0, pairNumber = 0;
		boolean continueScanneringUserInput = true, stopScanneringInput = true;
		Scanner keyboard = new Scanner(System.in);

		String scanneredService = "", scanneredChoice = "";
		String[] scanneredServices = new String[50];

		while (continueScanneringUserInput == true) {
			System.out.println("Please enter the type of services that you want in your room: ");
			try {
				scanneredService = keyboard.nextLine();
				if (scanneredService.isEmpty() == true) {
					System.out.println("Choice not valid!\nPlease entered a valid service");
				}
				if (scanneredService.matches("[0-9]+") && scanneredService.length() > 0) {
					System.out.println("Choice not valid!\nPlease entered a valid service");
				} else {
					scanneredServices[serviceCounter] = scanneredService;
					serviceCounter += 1;
					stopScanneringInput = true;
					if ((serviceCounter % 4) == 0) {
						while (stopScanneringInput == true) {
							System.out.println("Do you want to stop type? Please digit yes/no: ");
							scanneredChoice = keyboard.nextLine();
							if (scanneredChoice.equalsIgnoreCase("yes")) {
								stopScanneringInput = false;
								continueScanneringUserInput = false;
							} else if (scanneredChoice.isEmpty() == true) {
								System.out.println("Choice not valid!");
							} else if (scanneredChoice.equalsIgnoreCase("no")) {
								stopScanneringInput = false;
							} else {
								System.out.println("Choice not valid!");
							}
						}
					}
				}
			} catch (InputMismatchException ex) {
				System.out.println("User input is not a valid value for this method.");
				System.out.println("Exception caught: User cannot put that value as menu choice.");
				continueScanneringUserInput = false;
			}
		}

		String[] services = new String[serviceCounter];

		for (int i = 0; i < serviceCounter; i++) {
			services[i] = scanneredServices[i];
		}
		return services;
	}

	public int[] getRoomIdFromKeyboard(){
		Scanner keyboard = new Scanner(System.in);
		boolean continueScanneringUserInput = true;
		int idCounter = 0;
		int scanneredRoomId = 0;
		ArrayList<Integer> scanneredRoomIds = new ArrayList<Integer>();
		int i = 0;

		while(continueScanneringUserInput == true){
			System.out.println("Please insert the rooms' id: ");
			try{
				scanneredRoomId = keyboard.nextInt();
				if (scanneredRoomId == 0){
					System.out.println("Choice not valid!\nPlease enter a vail id");
				} else {
					scanneredRoomIds.add(idCounter, scanneredRoomId);
					idCounter += 1;
					continueScanneringUserInput = false;
				}
			} catch (InputMismatchException ex){
				System.out.println("User input is not a valid value for this method.");
				System.out.println("Exception caught: User cannot put that value as menu choice.");
				continueScanneringUserInput = false;
			}
		}
		
		int[] roomIds = new int[scanneredRoomIds.size()];
		
		for(Integer s : scanneredRoomIds){
			roomIds[i] = s.intValue();
			i++;
		}
		
		return roomIds;
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

	

}

