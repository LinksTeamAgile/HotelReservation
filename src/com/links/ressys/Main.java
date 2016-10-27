package com.links.ressys;

import java.util.ArrayList;
import java.util.InputMismatchException;
import com.links.ressys.core.*;

//import java.io.IOException;
//import java.time.LocalDate;
//import java.time.Month;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ArrayList<Room> RoomList = new ArrayList<Room>();
		int choice = 0;
		menu(choice);

		// CustomerConcrete customerConcrete = new
		// CustomerConcrete("SSSKVN74A01F839P", "Kevin", "Sasso", "342 042
		// 7775",
		// "kevinciaociao@gmail.com", "4023600442460293");
		// customerConcrete.print();
		//
		// String[] services = { "fridge", "phon", "television" };
		// RoomConcrete roomConcrete = new RoomConcrete(601, false, 1,
		// services);
		// roomConcrete.print();
		//
		// // Current Date
		// LocalDate startDate = LocalDate.now();
		// System.out.println("Start Date = " + startDate);
		//
		// // Creating LocalDate by providing input arguments
		// LocalDate endDate = LocalDate.of(2016, Month.OCTOBER, 29);
		// System.out.println("End Date = " + endDate + "\n");
		//
		// RoomConcrete[] reservatedRoom = { roomConcrete };
		//
		// ReservationConcrete reservationConcrete = new
		// ReservationConcrete(1234, "Kevin Sasso", reservatedRoom,
		// startDate, endDate);
		// reservationConcrete.print();

	}

	public static void menu(int choice) {
		Scanner keyboard = new Scanner(System.in);
		boolean flagContinueScanner = true;
		int scanneredNumber = 0;

		// possibili scelte creaQualcosa, inventaQualcosa
		System.out.println("Test menu'");
		System.out.println("1 - Create room.");
		System.out.println("2 - Delete room.");
		System.out.println("3 - Show rooms.");
		System.out.println("4 - Create customer.");
		System.out.println("5 - Delete customer.");
		System.out.println("6 - Show customers.");
		System.out.println("7 - Create reservation.");
		System.out.println("8 - Modify reservation.");
		System.out.println("9 - Show reservations.");
		System.out.println("0 - Exit");

		while (flagContinueScanner == true) {
			System.out.println("Please enter your choice: ");
			try {
				scanneredNumber = keyboard.nextInt();
			} catch (InputMismatchException ex) {
				System.out.println("User input is not a valid value for this method.");
				System.out.println("Exception caught: User cannot put that value as menu choice.");
				scanneredNumber = -1;
			}
			if (scanneredNumber == -1) {
				flagContinueScanner = false;
			}else if(scanneredNumber >= 0 && scanneredNumber <= 9 ){
				System.out.println("value entered : " + scanneredNumber);
			}

			if (scanneredNumber >= 0 && scanneredNumber <= 9) {
				flagContinueScanner = false;
				choice = scanneredNumber;
			}
		}

		switch (choice) {

		case 1: // createRoom(,...)
			System.out.println("method for CreateRoom");
			break;
		case 2: // deleteRoom(,...)
			System.out.println("method for DeleteRoom");
			break;
		case 3: // showRoom(,...)
			System.out.println("method for ShowRooms");
			break;
		case 4: // createCustomer(,...)
			System.out.println("method for CreateCustomer");
			break;
		case 5: // deleteCustomer(,...)
			System.out.println("method for DeleteRoom");
			break;
		case 6: // showCustomers(,...)
			System.out.println("method for ShowRooms");
			break;
		case 7: // createReservation(,...)
			System.out.println("method for CreateReservation");
			break;
		case 8: // deleteReservation(,...)
			System.out.println("method for DeleteReservation");
			break;
		case 9: // showReservation(,...)
			System.out.println("method for ShowRooms");
			break;
		case 0: // System.exit(0)
			System.out.println("Exit!");
			System.exit(0);
			break;
		case -1:
			System.exit(1);
			break;
		}
	}
}
