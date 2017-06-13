package com.scg.util;

import java.io.Serializable;

/**
 * This class encapsulates the address of a person
 * @author Claudine Morales
 *
 */
public final class Address implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3220003286366710322L;

	/**
	 * The street address for this Address
	 */
	private String streetNumber;
	
	/**
	 * The city for this Address
	 */
	private String city;
	
	/**
	 * The state code for this Address
	 */
	private StateCode state;
	
	/**
	 * The postal code for this Address
	 */
	private String postalCode;

	/**
	 * The constructor methods takes 4 args
	 * @param streetNumber the desired value of the streetNumber property
	 * @param city the desired value of the city property
	 * @param state the desired value of the state property
	 * @param postalCode the desired value of the postalCode property
	 */
	public Address(String streetNumber, String city, StateCode state, String postalCode) {
		this.streetNumber = streetNumber;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
	}
	
	/**
	 * The getter method for the streetNumber property
	 * @return the value of the streetNumber property
	 */
	public String getStreetNumber() {
		return this.streetNumber;
	}
	
	/**
	 * The getter method for the city property
	 * @return the value of the city property
	 */
	public String getCity() {
		return this.city;
	}
	
	/**
	 * The getter method for the state property
	 * @return the value of the state property
	 */
	public StateCode getState() {
		return this.state;
	}
	
	/**
	 * The getter method for the postalCode property
	 * @return the value of the postalCode property
	 */
	public String getPostalCode() {
		return this.postalCode;
	}
	
	/**
	 * This returns the hashCode of an Address object
	 */
	public int hashCode() {
		return this.hashCode();
	}
	
	/**
	 * This method evaluates two Address objects for equality
	 * @return true if two Address objects are equal
	 */
	public boolean equals(Object obj) {
		if(this.equals(obj)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * This method returns the formatted string representation of an Address object
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.streetNumber);
		sb.append(" ");
		sb.append("\n");
		sb.append(this.city);
		sb.append(",");
		sb.append(" ");
        sb.append(this.state);
        sb.append(" ");
		sb.append(this.postalCode);
		return sb.toString();
	}
	
}
