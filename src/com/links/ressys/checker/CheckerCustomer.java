package com.links.ressys.checker;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.links.ressys.core.Customer;
import com.links.ressys.statuscodes.*;

// TODO: Auto-generated Javadoc
/**
 * The Class CheckerCustomer checks the validity of customer's name, surname, tax code,
 * cellphone number, mail address and card number.
 */
public class CheckerCustomer implements Checker {

	/** The customer. */
	private Customer customer;

	/**
	 * Instantiates a new checker customer.
	 *
	 * @param c the c
	 */
	public CheckerCustomer(Customer c) {
		this.customer = c;
	}

	/* (non-Javadoc)
	 * @see com.links.ressys.checker.Checker#check()
	 */
	
	/**
	 * This method instantiates the ArrayList check and fills it with the codes resulting from 
	 * the check on the customer's fields.
	 * 
	 * @return the ArrayList check containing the codes resulting from the check on the customer's fields.
	 */
	@Override
	public ArrayList<Integer> check() {
		ArrayList<Integer> check = new ArrayList<Integer>();
		check.add(checkName());
		check.add(checkSurname());
		check.add(checkTaxCode());
		check.add(checkCellPhoneNumber());
		check.add(checkMailAddress());
		check.add(checkCardNumber());
		return check;
	}

	/**
	 * This method checks the validity of customer's name.
	 *
	 * @return the int containing the code that indicates if the string name is empty, wrong or valid.
	 */
	private int checkName() {
		if (customer.getName().equals(""))
			return CustomerCode.EMPTY_NAME.getCode();
		else if (customer.getName().length() < 255)
			return CustomerCode.WRONG_NAME.getCode();
		String regex = "^[A-Za-z\\s]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(customer.getName());
		if(!matcher.matches())
			return CustomerCode.WRONG_NAME.getCode();
		else 
			return CustomerCode.SUCCESS_CUSTOMER.getCode();
	}

	/**
	 * This method checks the validity of customer's surname.
	 *
	 * @return the int containing the code that indicates if the string surname is empty, wrong or valid.
	 */
	private int checkSurname() {
		if (customer.getSurname().equals(""))
			return CustomerCode.EMPTY_SURNAME.getCode();
		else if (customer.getSurname().length() < 255)
			return CustomerCode.WRONG_SURNAME.getCode();
		String regex = "^[A-Za-z\\s]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(customer.getSurname());
		if(!matcher.matches())
			return CustomerCode.WRONG_SURNAME.getCode();
		else 
			return CustomerCode.SUCCESS_CUSTOMER.getCode();
	}
	
	/**
	 * This method checks the validity of customer's tax code.
	 *
	 * @return the int containing the code that indicates if the string taxCode is empty, wrong or valid.
	 */
	private int checkTaxCode() {
		if (customer.getTaxCode().equals(""))
			return CustomerCode.EMPTY_TAXCODE.getCode();
		else if (customer.getTaxCode().length() != 16)
			return CustomerCode.WRONG_TAXCODE.getCode();
		else
			return CustomerCode.SUCCESS_CUSTOMER.getCode();
	}

	/**
	 * This method checks the validity of customer's cellphone number.
	 *
	 * @return the int containing the code that indicates if the string cellPhoneNumber is empty, wrong or valid.
	 */
	private int checkCellPhoneNumber() {
		if (customer.getCellPhoneNumber().equals(""))
			return CustomerCode.EMPTY_PHONENUM.getCode();
		try {
			Integer.parseInt(customer.getCellPhoneNumber());
			return CustomerCode.SUCCESS_CUSTOMER.getCode();
		} catch (NumberFormatException e) {
			return CustomerCode.WRONG_PHONENUM.getCode();
		}
	}
 
	/**
	 * This method checks the validity of customer's mail address.
	 *
	 * @return the int containing the code that indicates if the string mailAddress is empty, wrong or valid.
	 */
	private int checkMailAddress() {
		if (customer.getMailAddress().equals(""))
			return CustomerCode.EMPTY_MAIL.getCode();
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(customer.getMailAddress());
		if(!matcher.matches())
			return CustomerCode.WRONG_MAIL.getCode();
		else 
			return CustomerCode.SUCCESS_CUSTOMER.getCode();
	}

	/**
	 * This method checks the validity of customer's card number.
	 *
	 * @return the int containing the code that indicates if the string cardNumber is empty, wrong or valid.
	 */
	private int checkCardNumber() {
		if (customer.getCardNumber().equals(""))
			return CustomerCode.EMPTY_CARDNUM.getCode();
		else if(customer.getCardNumber().length()!=16)
			return CustomerCode.WRONG_CARDNUM.getCode();
		try {
			Integer.parseInt(customer.getCardNumber());
			return CustomerCode.SUCCESS_CUSTOMER.getCode();
		} catch (NumberFormatException e) {
			return CustomerCode.WRONG_CARDNUM.getCode();
		}
	}
}
