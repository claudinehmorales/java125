package com.scg.util;

import java.io.Serializable;

/**
 * This class encapsulates the name of a person
 * @author Claudine Morales
 *
 */
@SuppressWarnings("serial")
public final class Name implements Serializable {
	
	/**
	 * The last name for this Name
	 */
	String lastName;
	
	/**
	 * The first name for this Name
	 */
	String firstName;
	
	/**
	 * The middle name for this Name
	 */
	String middleName;
	
	/**
	 * The hashCode value for this Name
	 */
	int hashCode;
	
	/**
	 * This is the two-arg constructor method
	 * @param lastName the last name of the person
	 * @param firstName the first name of the person
	 */
	public Name(String lastName, String firstName) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.middleName = "NMN";
	}

	/**
	 * The is the three-arg constructor method
	 * @param lastName the last name of the person
	 * @param firstName the first name of the person
	 * @param middleName the middle name of the person
	 */
	public Name(String lastName, String firstName, String middleName) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.middleName = middleName;
	}
	
	/**
	 * The getter method for the first name property
	 * @return the set value of the first name property
	 */
	public String getFirstName() {
		return this.firstName;
	}
	
	/**
	 * The setter method for the first name property
	 * @param firstName the desired value for the first name property
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * The getter method for the last name property
	 * @return the set value for the last name property
	 */
	public String getLastName() {
		return this.lastName;
	}
	
	/**
	 * The setter method for the last name property
	 * @param lastName the desired value for the last name property
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * The getter method for the middle name property
	 * @return the set value for the middle name property
	 */
	public String getMiddleName() {
		return this.middleName;
	}
	
	/**
	 * The setter method for the middle name property
	 * @param middleName the desired value for the middle name property
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	/**
	 * This method overrides hashCode in class Object
	 */
	public int hashCode(){
		return this.hashCode;
	}
	
	/**
	 * This method compares two Name objects to determine equality
	 * @return the value of the boolean (true if the Name objects are equal)
	 */
	public boolean equals(Object other) {
		if(super.equals(other)){
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * This method returns a string representation of the Name object
	 * @return the set last name, first name, and middle name properties in a formatted string
	 */
	public String toString() {
		String ln = this.getLastName();
		String fn = this.getFirstName();
		String mn = this.getMiddleName();
		return String.format("%s, %s %s", ln, fn, mn);
	}
}
