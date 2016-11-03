package com.links.ressys.statuscodes;

// TODO: Auto-generated Javadoc
/**
 * The Enum CustomerCode contains all the possible status codes for customer's fields.
 */
public enum CustomerCode {
	
	/** The success customer. */
	SUCCESS_CUSTOMER(100, "Valid customer"),
	
	/** The empty name. */
	EMPTY_NAME(511, "Name field empty"),
	
	/** The empty surname. */
	EMPTY_SURNAME(521, "Surname field empty"),
	
	/** The empty taxcode. */
	EMPTY_TAXCODE(531, "TaxCode field empty"),
	
	/** The empty phonenum. */
	EMPTY_PHONENUM(541, "Phone number field empty"),
	
	/** The empty mail. */
	EMPTY_MAIL(551, "Mail field empty"),
	
	/** The empty cardnum. */
	EMPTY_CARDNUM(561, "Card field empty"),
	
    /** The wrong name. */
    WRONG_NAME(512, "Wrong name field"),
	
	/** The wrong surname. */
	WRONG_SURNAME(522, "Wrong surname field"),
	
	/** The wrong taxcode. */
	WRONG_TAXCODE(532, "Wrong Tax Code format"),
    
    /** The wrong phonenum. */
    WRONG_PHONENUM(542, "Wrong phone number format"),
	
	/** The wrong mail. */
	WRONG_MAIL(552, "Wrong mail format"),
	
	/** The wrong cardnum. */
	WRONG_CARDNUM(562, "Wrong card format"),
	
	//DUPLICATE_NAME(513, "Duplicate name field"),
	//DUPLICATE_SURNAME(523, "Duplicate surname field"),
	//DUPLICATE_TAXCODE(533, "Duplicate Tax Code field"),
	/** The duplicate mail. */
	//DUPLICATE_PHONENUM(543, "Duplicate phone number field"),
	DUPLICATE_MAIL(553, "Duplicate mail"),
	
	/** The code. */
	//DUPLICATE_CARDNUM(561, "DuplicTE Card field")
	;
	
	private final int code;
	
	/** The description. */
	private final String description;
	
	/**
	 * This method instantiates a new customer code.
	 *
	 * @param code the code
	 * @param description the description
	 */
	private CustomerCode(int code, String description){
		this.code = code;
		this.description = description;
	}

	/**
	 * This method gets the code.
	 *
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * This method gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString(){
		return code + ": " + description;
	}

}
