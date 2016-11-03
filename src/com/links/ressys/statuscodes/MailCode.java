package com.links.ressys.statuscodes;

// TODO: Auto-generated Javadoc
/**
 * The Enum MailCode contains all the possible status codes for customer's mail.
 */
public enum MailCode {
	
	/** The success mail. */
	SUCCESS_MAIL(100, "Valid mail"),
	
	/** The empty mail. */
	EMPTY_MAIL(201, "Mail field empty"),
	
	/** The wrong mail. */
	WRONG_MAIL(202, "Wrong mail format"),
	
	/** The duplicate mail. */
	DUPLICATE_MAIL(203, "Duplicate mail");
	
	/** The code. */
	private final int code;
	
	/** The description. */
	private final String description;
	
	/**
	 * This method instantiates a new mail code.
	 *
	 * @param code the code
	 * @param description the description
	 */
	private MailCode(int code, String description){
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
