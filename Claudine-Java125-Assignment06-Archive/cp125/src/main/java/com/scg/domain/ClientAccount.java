package com.scg.domain;
import java.util.Comparator;

import com.scg.util.*;

/**
 * This class encapsulates the information for a billable client account.
 * @author Claudine Morales
 *
 */
public final class ClientAccount implements Account, Comparable<ClientAccount> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3762889028095953545L;

	/**
	 * The contact for this ClientAccount
	 */
	private Name contact;
	
	/**
	 * The name of the ClientAccount
	 */
	private String name;
	
	/**
	 * Determines if this ClientAccount is billable
	 */
	private boolean isBillable = true;
	
	/**
	 * The address of this ClientAccount
	 */
	private Address address;

	
	/**
	 * This is the constructor method
	 * @param name the name of the client
	 * @param contact the contact for the client
	 */
	public ClientAccount(String name, Name contact, Address address) {
		this.name = name;
		this.contact = contact;
		this.address = address;
	}
	
	/**
	 * This is the getter for the name property
	 * @return the value of the name property of the client account
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * This is the getter for the contact property
	 * @return the value of the contact property of the client account
	 */
	public Name getContact() {
		return this.contact;
	}
	
	/**
	 * This is the setter for the contact property
	 * @param contact an object of type Name that serves as contact for the client account 
	 */
	public void setContact(Name contact) {
		this.contact = contact;
	}
	
	/**
	 * This method determines if an account is billable and is always set to true for ClientAccount
	 * @return the value of the boolean (always true for ClientAccount)
	 */
	public boolean isBillable() {
		return true;
	}
	
	/**
	 * This method is the getter for the address property
	 * @return the value of address property of the client account
	 */
	public Address getAddress() {
		return this.address;
	}
	
	/**
	 * This method is the setter for the address property
	 * @param address an object of type Address that is to be the desired value of the address property
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
	
	/**
	 * This method returns the string representation of the client account
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getName());
		sb.append("\n");
		sb.append(this.getAddress());
		sb.append("\n"); 
		sb.append(this.getContact());
		return sb.toString();
	}

	/**
	 * Compares this Client with the specified Client for order, ordering by name, contact, and finally address. Returns 
	 * a negative integer, zero, or a positive integer as this Client is less than, equal to, or greater than the specified 
	 * Client.
	 * @param other the other Client to compare to
	 * @return a negative integer, zero, or a positive integer as this Client is less than, equal to, or greater than the 
	 * specified Client.
	 */
	@Override
	public int compareTo(ClientAccount other) {
			//return ((this.toString().compareTo(other.toString())));
		
		int namesAreEqual = 0;
		namesAreEqual = this.getName().compareTo(other.getName());
		if(namesAreEqual != 0) {
			if(namesAreEqual < 0) {
				return -1;
			} else {
				return 1;
			}
		}
		
		int contactsAreEqual = 0;
		contactsAreEqual = this.getContact().toString().compareTo(other.getContact().toString());
		if(contactsAreEqual != 0) {
			if(contactsAreEqual < 0) {
				return -1;
			} else {
				return 1;
			}
		}
		
		int addressesAreEqual = 0;
		addressesAreEqual = this.getAddress().toString().compareTo(other.getAddress().toString());
			if (addressesAreEqual != 0) {
				if(addressesAreEqual < 0) {
					return -1;
				} else {
					return 1;
				}
			}
		return 0;
	}

}
