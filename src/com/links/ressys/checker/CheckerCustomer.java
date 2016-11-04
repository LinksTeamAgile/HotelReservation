package com.links.ressys.checker;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.links.ressys.core.Customer;
import com.links.ressys.statuscodes.*;

public class CheckerCustomer implements Checker {

	private Customer customer;
	
	//Matches a string consisting of Unicode characters, space and punctuation
	private String regexName = "^\\pL+[\\pL\\pZ\\pP]{0,}$";
	
	//Matches a string consisting of 6 letters, 2 numbers, 1 letter, 2 numbers, 1 letter, 3 numbers and 1 letter 
	private String regexTax = "^[a-zA-Z]{6}[0-9]{2}[a-zA-Z]{1}[0-9]{2}[a-zA-Z]{1}[0-9]{3}[a-zA-Z]{1}$";
	
	//Matches a string consisting of a "+", 1 number and 1 to 14 numbers
	private String regexNum = "^\\+[1-9]{1}[0-9]{1,14}$";
	
	//Matches a string consisting of every character, a "@", a string of every character, a "." and a string of 2 to 4 characters
	private String regexMail = "^\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b$";
	
	//MAtches a string made of 15 numbers
	private String regexCard = "^[1-9][0-9]{16}$";

	public CheckerCustomer(Customer c) {
		this.customer = c;
	}

	@Override
	public ArrayList<Enum> check() {
		ArrayList<Enum> check = new ArrayList<Enum>();
		if (isNull()) {
			check.add(CustomerCode.EMPTY_NAME);
			check.add(CustomerCode.EMPTY_SURNAME);
			check.add(CustomerCode.EMPTY_TAXCODE);
			check.add(CustomerCode.EMPTY_PHONENUM);
			check.add(CustomerCode.EMPTY_MAIL);
			check.add(CustomerCode.EMPTY_CARDNUM);
			return check;
		} else {
			check.add(checkName());
			check.add(checkSurname());
			check.add(checkTaxCode());
			check.add(checkCellPhoneNumber());
			check.add(checkMailAddress());
			check.add(checkCardNumber());
			return check;
		}
	}

	private boolean isNull() {
		if (customer == null)
			return true;
		else
			return false;
	}

	private Enum checkName() {

		if (customer.getName().equals("")){
			return CustomerCode.EMPTY_NAME;
		} else if (customer.getName().length() > 255){
			return CustomerCode.WRONG_NAME;
		} else if (!customer.getName().matches(regexName)){
			return CustomerCode.WRONG_NAME;
		} else{
			return CustomerCode.SUCCESS_CUSTOMER;
		}
	}

	private Enum checkSurname() {
		if (customer.getSurname().equals("")){
			return CustomerCode.EMPTY_SURNAME;
		} else if (customer.getSurname().length() > 255){
			return CustomerCode.WRONG_SURNAME;
		} else if (!customer.getSurname().matches(regexName)){
			return CustomerCode.WRONG_SURNAME;
		} else{
			return CustomerCode.SUCCESS_CUSTOMER;
		}
	}

	private Enum checkTaxCode() {
		if (customer.getTaxCode().equals("")){
			return CustomerCode.EMPTY_TAXCODE;
		} else if (!customer.getTaxCode().matches(regexTax)){
			return CustomerCode.WRONG_TAXCODE;
		} else {
			return CustomerCode.SUCCESS_CUSTOMER;
		}
	}

	private Enum checkCellPhoneNumber() {
		if (customer.getCellPhoneNumber().equals("")){
			return CustomerCode.EMPTY_PHONENUM;
		} else if (!customer.getCellPhoneNumber().matches(regexNum)){
			return CustomerCode.WRONG_PHONENUM;
		} else {
			return CustomerCode.SUCCESS_CUSTOMER;
		}
	}

	private Enum checkMailAddress() {
		if (customer.getMailAddress().equals("")){
			return CustomerCode.EMPTY_MAIL;
		} else if (!customer.getMailAddress().matches(regexMail)){
			return CustomerCode.WRONG_MAIL;
		} else {
			return CustomerCode.SUCCESS_CUSTOMER;
		}
	}

	private Enum checkCardNumber() {
		if (customer.getCardNumber().equals("")){
			return CustomerCode.EMPTY_CARDNUM;
		}
		else if (customer.getCardNumber().length() != 16 || !customer.getCardNumber().matches(regexCard)){
			return CustomerCode.WRONG_CARDNUM;
		} else {
			return CustomerCode.SUCCESS_CUSTOMER;
		}
	}
}
