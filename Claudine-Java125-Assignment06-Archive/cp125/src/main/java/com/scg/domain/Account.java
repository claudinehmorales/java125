package com.scg.domain;
import java.io.Serializable;

/**
 * This is the interface that all accounts must implement.
 * @author Claudine Morales
 *
 */

public interface Account extends Serializable {
	
	/**
	 * The getter method for the name property of the account
	 * @return the name of the account
	 */
	public String getName();
	
	/**
	 * The boolean method that determines if the account is billable or not
	 * @return the value of the boolean (true if account is billable)
	 */
	public boolean isBillable();
	
}
