package com.links.ressys.gui;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GuiBash implements Gui {
	
	private void viewMenu(){
		System.out.println("Menu'");
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
	}

	@Override
	public void open() {
		this.viewMenu();
	}

	@Override
	public void close() {
	}

	@SuppressWarnings("resource")
	@Override
	public String getInput(String message) {
		Scanner keyboard = new Scanner(System.in);
		int scanneredNumber = 0;		

		System.out.println(message);
		try {
			scanneredNumber = keyboard.nextInt();
		} catch (InputMismatchException ex) {
			System.out.println("User input is not a valid value for this method.");
			System.out.println("Exception caught: User cannot put that value as menu choice.");
			scanneredNumber = -1;
		}
		return Integer.toString(scanneredNumber);
	}

}
