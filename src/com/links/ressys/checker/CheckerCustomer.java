package com.links.ressys.checker;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.links.ressys.core.Customer;
import com.links.ressys.statuscodes.*;

public class CheckerCustomer implements Checker {

	private Customer customer;
	private String regexName = "^\\pL+[\\pL\\pZ\\pP]{0,}$";
	private String regexTax = "^[a-zA-Z]{6}[0-9]{2}[abcdehlmprstABCDEHLMPRST]{1}[0-9]{2}([a-zA-Z]{1}[0-9]{3})[a-zA-Z]{1}$";
	private String regexNum = "^\\+[1-9]{1}[0-9]{1,14}$";
	private String regexMail = "^(.+)@(.+)$";
	private String regexCard = "^[1-9][0-9]{15}$";

	public CheckerCustomer(Customer c) {
		this.customer = c;
	}

	@Override
	public ArrayList<Integer> check() {
		ArrayList<Integer> check = new ArrayList<Integer>();
		if (isNull()) {
			check.add(CustomerCode.EMPTY_NAME.getCode());
			check.add(CustomerCode.EMPTY_SURNAME.getCode());
			check.add(CustomerCode.EMPTY_TAXCODE.getCode());
			check.add(CustomerCode.EMPTY_PHONENUM.getCode());
			check.add(CustomerCode.EMPTY_MAIL.getCode());
			check.add(CustomerCode.EMPTY_CARDNUM.getCode());
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

	private int checkName() {

		if (customer.getName().equals("")){
			return CustomerCode.EMPTY_NAME.getCode();
		} else if (customer.getName().length() > 255){
			return CustomerCode.WRONG_NAME.getCode();
		} else if (!customer.getName().matches(regexName)){
			return CustomerCode.WRONG_NAME.getCode();
		} else{
			return CustomerCode.SUCCESS_CUSTOMER.getCode();
		}
	}

	private int checkSurname() {
		if (customer.getSurname().equals("")){
			return CustomerCode.EMPTY_SURNAME.getCode();
		} else if (customer.getSurname().length() > 255){
			return CustomerCode.WRONG_SURNAME.getCode();
		} else if (!customer.getSurname().matches(regexName)){
			return CustomerCode.WRONG_SURNAME.getCode();
		} else{
			return CustomerCode.SUCCESS_CUSTOMER.getCode();
		}
	}

	private int checkTaxCode() {
		if (customer.getTaxCode().equals("")){
			return CustomerCode.EMPTY_TAXCODE.getCode();
		} else if (!customer.getTaxCode().matches(regexTax)){
			return CustomerCode.WRONG_TAXCODE.getCode();
		} else {
			return CustomerCode.SUCCESS_CUSTOMER.getCode();
		}
	}

	private int checkCellPhoneNumber() {
		if (customer.getCellPhoneNumber().equals("")){
			return CustomerCode.EMPTY_PHONENUM.getCode();
		} else if (!customer.getCellPhoneNumber().matches(regexNum)){
			return CustomerCode.WRONG_PHONENUM.getCode();
		} else {
			return CustomerCode.SUCCESS_CUSTOMER.getCode();
		}
	}

	private int checkMailAddress() {
		if (customer.getMailAddress().equals("")){
			return CustomerCode.EMPTY_MAIL.getCode();
		} else if (!customer.getMailAddress().matches(regexMail)){
			return CustomerCode.WRONG_MAIL.getCode();
		} else {
			return CustomerCode.SUCCESS_CUSTOMER.getCode();
		}
	}

	private int checkCardNumber() {
		if (customer.getCardNumber().equals("")){
			return CustomerCode.EMPTY_CARDNUM.getCode();
		}
		else if (customer.getCardNumber().length() != 16 || !customer.getCardNumber().matches(regexCard)){
			return CustomerCode.WRONG_CARDNUM.getCode();
		} else {
			return CustomerCode.SUCCESS_CUSTOMER.getCode();
		}
	}
}
