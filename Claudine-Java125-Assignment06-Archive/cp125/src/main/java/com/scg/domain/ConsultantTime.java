package com.scg.domain;

import java.io.Serializable;

/**
 * This class encapsulates and maintains information on the consultant's time, skill, account, hours data, 
 * and employment dates.
 * @author Claudine Morales
 *
 */
@SuppressWarnings("serial")
public final class ConsultantTime implements Serializable {
	
	/**
	 * The date of this ConsultantTime
	 */
	private java.time.LocalDate date;
	
	/**
	 * The account of this ConsultantTime
	 */
	private Account account;
	
	/**
	 * The skillType for this ConsultantTime
	 */
	private Skill skillType;
	
	/**
	 * The number of hours for this ConsultantTime
	 */
	private int hours;
	
	/**
	 * Determines if this ConsultantTime is billable
	 */
	private boolean isBillable = true;
	
	/**
	 * Determines equality between two ConsultantTime objects
	 */
	boolean equals;
	
	/**
	 * Gets the hashCode value of this ConsultantTime 
	 */
	private int hashCode;

	/**
	 * The constructor method
	 * @param date the date work hours took place
	 * @param account the account of the consultant's time (can be an object of type ClientAccount or NonBillableAccount)
	 * @param skillType the consultant's skill
	 * @param hours the number of hours to be entered for a certain date
	 */
	public ConsultantTime(java.time.LocalDate date, Account account, Skill skillType, int hours) {
		this.date = date;
		this.account = account;
		this.skillType = skillType;
		this.hours = hours;
	}
	
	/**
	 * This is the getter method for the date property
	 * @return the value of the date property
	 */
	public java.time.LocalDate getDate() {
		return this.date;
	}
	
	/**
	 * This is the setter method for the date property
	 * @param date the desired value for the date property
	 */
	public void setDate(java.time.LocalDate date) {
		this.date = date;
	}
	
	/**
	 * This is the getter method for the account property
	 * @return the value of the consultant time's account property
	 */
	public Account getAccount() {
		return account;
	}
	
	/**
	 * This is the setter method for the account property
	 * @param account the desired account type (can be an object of type ClientAccount or NonBillableAccount)
	 */
	public void setAccount(Account account) {
		this.account = account;
	}
	
	/**
	 * This boolean method determines if the consultant's time is billable or not
	 * @return the value of the boolean (true if the account is billable)
	 */
	public boolean isBillable() {
		if(this.account.isBillable()) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * This is the getter method for the hours property
	 * @return the value for the hours property
	 */
	public int getHours() {
		return this.hours;
	}
	
	/**
	 * This is the setter for the hours property
	 * @param hours the desired number of consultant time hours to be entered
	 * @throws IllegalArgumentException if the number of consultant hours entered is 0 or less
	 */
	public void setHours(int hours) throws IllegalArgumentException {
	if(hours <= 0) {
		throw new IllegalArgumentException("Hours must be greater than 0");
	} else {
		this.hours = hours;
	}
	}
	
	/**
	 * This is the getter method for the skill property
	 * @return the value for the skill property
	 */
	public Skill getSkill() {
		return skillType;
	}
	
	/**
	 * This method overrides hashCode in class Object
	 */
	public int hashCode() {
		return hashCode;
	}
	
	/**
	 * This boolean method determines if two objects are equal
	 * @return the value of the boolean (true if two objects are equal)
	 */
	public boolean equals(Object obj) {
		if(equals) {
			return true;
		} else { 
			return false;
		}
	}
	
	/**
	 * This method prints out a string representation of the consultant time data
	 * @return a formatted string of consultant time data, including the date 
	 * consulting hours took place, the account, the skill, and hours entered.
	 */
	public String toString() {
		String dt = this.getDate().toString();
		String ac = this.account.getName().toString();
		String sk = this.skillType.toString();
		int hr = this.getHours();
		return String.format("%1$-30s %2$-20s %3$-10d %4$-20s", ac, dt, hr, sk);
		
	}
}
