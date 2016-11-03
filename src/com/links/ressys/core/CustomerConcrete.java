package com.links.ressys.core;

// TODO: Auto-generated Javadoc
/**
 * The Class CustomerConcrete.
 */
public class CustomerConcrete extends Customer{
	
	/** The tax code. */
	private String taxCode;
	
	/** The name. */
	private String name;
	
	/** The surname. */
	private String surname;
	
	/** The cell phone number. */
	private String cellPhoneNumber;
	
	/** The mail address. */
	private String mailAddress;
	
	/** The card number. */
	private String cardNumber;

	/**
	 * Instantiates a new customer concrete.
	 *
	 * @param taxCode the tax code
	 * @param name the name
	 * @param surname the surname
	 * @param cellPhoneNumber the cell phone number
	 * @param mailAddress the mail address
	 * @param cardNumber the card number
	 */
	public CustomerConcrete(String taxCode, String name, String surname, String cellPhoneNumber, String mailAddress,
			String cardNumber) {
		super();
		this.taxCode = taxCode;
		this.name = name;
		this.surname = surname;
		this.cellPhoneNumber = cellPhoneNumber;
		this.mailAddress = mailAddress;
		this.cardNumber = cardNumber;
	}

	/* (non-Javadoc)
	 * @see com.links.ressys.core.Customer#getTaxCode()
	 */
	public String getTaxCode() {
		return taxCode;
	}

	/* (non-Javadoc)
	 * @see com.links.ressys.core.Customer#setTaxCode(java.lang.String)
	 */
	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}

	/* (non-Javadoc)
	 * @see com.links.ressys.core.Customer#getName()
	 */
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see com.links.ressys.core.Customer#setName(java.lang.String)
	 */
	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see com.links.ressys.core.Customer#getSurname()
	 */
	public String getSurname() {
		return surname;
	}

	/* (non-Javadoc)
	 * @see com.links.ressys.core.Customer#setSurname(java.lang.String)
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/* (non-Javadoc)
	 * @see com.links.ressys.core.Customer#getCellPhoneNumber()
	 */
	public String getCellPhoneNumber() {
		return cellPhoneNumber;
	}

	/* (non-Javadoc)
	 * @see com.links.ressys.core.Customer#setCellPhoneNumber(java.lang.String)
	 */
	public void setCellPhoneNumber(String cellPhoneNumber) {
		this.cellPhoneNumber = cellPhoneNumber;
	}

	/* (non-Javadoc)
	 * @see com.links.ressys.core.Customer#getMailAddress()
	 */
	public String getMailAddress() {
		return mailAddress;
	}

	/* (non-Javadoc)
	 * @see com.links.ressys.core.Customer#setMailAddress(java.lang.String)
	 */
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	/* (non-Javadoc)
	 * @see com.links.ressys.core.Customer#getCardNumber()
	 */
	public String getCardNumber() {
		return cardNumber;
	}

	/* (non-Javadoc)
	 * @see com.links.ressys.core.Customer#setCardNumber(java.lang.String)
	 */
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Customer:\n\tTax Code = " + taxCode + "\n\tName = " + name + "\n\tSurname = " + surname + "\n\tCell Phone Number = "
				+ cellPhoneNumber + "\n\tMail Address = " + mailAddress + "\n\tCard Number = " + cardNumber + "\n";
	}

}
