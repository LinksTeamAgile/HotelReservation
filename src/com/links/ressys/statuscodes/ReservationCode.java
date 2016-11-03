package com.links.ressys.statuscodes;

// TODO: Auto-generated Javadoc
/**
 * The Enum ReservationCode contains all the possible status codes for the fields of a reservation.
 */
public enum ReservationCode {
	
    /** The success reservation. */
    SUCCESS_RESERVATION(100, "Valid reservation"),
	
	/** The empty customer. */
	EMPTY_CUSTOMER(411, "Customer field empty"),
	
	/** The empty rooms. */
	EMPTY_ROOMS(421, "Room field empty"),
	
	/** The empty reservationid. */
	EMPTY_RESERVATIONID(431, "Reservation id field empty"),
	
	/** The empty startdate. */
	EMPTY_STARTDATE(441, "Start date field empty"),
	
	/** The empty enddate. */
	EMPTY_ENDDATE(451, "End date field empty"),
	
	/** The wrong customer. */
	WRONG_CUSTOMER(412, "Wrong customer field"),
	
	/** The wrong rooms. */
	WRONG_ROOMS(422, "Wrong room field"),
	
	/** The wrong reservationid. */
	WRONG_RESERVATIONID(432, "Reservation id not valid"),
    
    /** The wrong startdate. */
    WRONG_STARTDATE(442, "Start date format not valid"),
	
	/** The wrong enddate. */
	WRONG_ENDDATE(452, "End date format not valid"),
    //DUPLICATE_CUSTOMER(413, "Duplicate customer field"),
	/** The duplicate rservationid. */
    //DUPLICATE_ROOM(423, "Duplicate room field"),
	DUPLICATE_RSERVATIONID(433, "Duplicate reservation id"),
	//DUPLICATE_STARTDATE(443, "Duplicate start date field"),
	/** The invalid date. */
	//DUPLICATE_ENDDATE(453, "Duplicate end date field");
	INVALID_DATE(403, "Invalid start date format");
	
	
	/** The code. */
	private final int code;
	
	/** The description. */
	private final String description;
	
	/**
	 * This method instantiates a new reservation code.
	 *
	 * @param code the code
	 * @param description the description
	 */
	private ReservationCode(int code, String description){
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
