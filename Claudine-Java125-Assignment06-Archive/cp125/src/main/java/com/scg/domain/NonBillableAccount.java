package com.scg.domain;

/**
 * This enum encapsulates the different types of nonbillable accounts
 * @author Claudine Morales
 *
 */
public enum NonBillableAccount implements Account {
	
	BUSINESS_DEVELOPMENT ("Business Development"),
	SICK_LEAVE ("Sick Leave"),
	VACATION ("Vacation");

	/**
	 * The name for this NonBillableAccount
	 */
	private String name;
	
	/**
	 * Determines if this account is billable (always set to false)
	 */
	private boolean isBillable = false;
	
	/**
	 * This method allows an enum type to be set using a string value
	 * @param name the string value of the account
	 */
	private NonBillableAccount (String name) {
		this.name = name;
	}

	/**
	 * This is the getter method for the name property 
	 * @return the value for the name property
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * This method determines if an account is billable or not and is always set to false for this account type
	 * @return the value of the boolean (always false for NonBillableAccount)
	 */
	public boolean isBillable() {
		return false;
	}
	
	/**
	 * This method returns a spring representation of the name of the account
	 * @return the name of the account
	 */
	public String toString() {
		return name;
	}
}
