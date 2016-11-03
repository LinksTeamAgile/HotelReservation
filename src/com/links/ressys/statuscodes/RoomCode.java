package com.links.ressys.statuscodes;

// TODO: Auto-generated Javadoc
/**
 * The Enum RoomCode.
 */
public enum RoomCode {
	
    /** The success room. */
    SUCCESS_ROOM(100, "Valid room"),
	
	//EMPTY_MAXGUESTS(311, "Guests field empty"),
	//EMPTY_SERVICEABLE(321, "Serviceable field empty"),
	/** The empty services. */
	//EMPTY_AVAILABLE(331, "Available field empty"),
	EMPTY_SERVICES(341, "Services field empty"),
	
	/** The wrong maxguests. */
	WRONG_MAXGUESTS(312, "Invalid number of guests"),
	//WRONG_SERVICEABLE(322, "Serviceable field not valid"),
	//WRONG_AVAILABLE(332, "Available field not valid"),
    //WRONG_SERVICES(342, "Services not valid"),
	
	//DUPLICATE_MAXGUESTS(313, "Duplicate max guests field"),
	//DUPLICATE_SERVICEABLE(323, "Duplicate serviceable field"),
	//DUPLICATE_AVAILABLE(333, "Duplicate available field"),
	/** The code. */
	//DUPLICATE_SERVICES(343, "Duplicate services field"),
	;
	
	private final int code;
	
	/** The description. */
	private final String description;
	
	/**
	 * Instantiates a new room code.
	 *
	 * @param code the code
	 * @param description the description
	 */
	private RoomCode(int code, String description){
		this.code = code;
		this.description = description;
	}

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * Gets the description.
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
