package com.scg.util;

/**
 * This enum encapsulates the state code of a person's address
 * @author Claudine Morales
 *
 */
public enum StateCode {
	 
	CA ("CA"),
	WA ("WA");
	
	/**
	 * The string representation of this StateCode
	 */
	private String stateCode;

	StateCode(String stateCode) {
		this.stateCode = stateCode;
	}
}
