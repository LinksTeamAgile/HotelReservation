package com.links.entities;

public abstract class Customer {
	private String taxCode;
	private String customerId;
	private String name;
	private String surname;
	private String cellPhoneNumber;
	private String mailAddress;
	private String cardNumber;

	public Customer(String taxCode, String name, String surname, String cellPhoneNumber,
			String mailAddress, String cardNumber) {
		this.taxCode = taxCode;
		this.name = name;
		this.surname = surname;
		this.cellPhoneNumber = cellPhoneNumber;
		this.mailAddress = mailAddress;
		this.cardNumber = cardNumber;
	}

	public String getTaxCode() {
		return taxCode;
	}

	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getCellPhoneNumber() {
		return cellPhoneNumber;
	}

	public void setCellPhoneNumber(String cellPhoneNumber) {
		this.cellPhoneNumber = cellPhoneNumber;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	@Override
	public String toString() {
		return "Customer [taxCode=" + taxCode + ", customerId=" + customerId + ", name=" + name + ", surname=" + surname
				+ ", cellPhoneNumber=" + cellPhoneNumber + ", mailAddress=" + mailAddress + ", cardNumber=" + cardNumber
				+ "]";
	}

}
