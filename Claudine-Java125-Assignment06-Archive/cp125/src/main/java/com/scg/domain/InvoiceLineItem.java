package com.scg.domain;

import java.io.Serializable;

/**
 * This class encapsulates a single billable item to be included in an invoice.
 * @author Claudine Morales
 *
 */
public class InvoiceLineItem implements Serializable {
	
	/**
	 * The date of this InvoiceLineItem
	 */
	private java.time.LocalDate date;
	
	/**
	 * The consultant in this InvoiceLineItem
	 */
	private Consultant consultant;
	
	/**
	 * The skill of the consultant in this InvoiceLineItem
	 */
	private Skill skill;
	
	/**
	 * The number of hours in this InvoiceLineItem
	 */
	private int hours;
	
	/**
	 * The amount of the charge for this InvoiceLineItem
	 */
	private int charge;
	
	/**
	 * This is the constructor method
	 * @param date
	 * @param consultant
	 * @param skill
	 * @param hours
	 */
	public InvoiceLineItem(java.time.LocalDate date, Consultant consultant, Skill skill, int hours) {
		this.date = date;
		this.consultant = consultant;
		this.skill = skill; 
		this.hours = hours;
	}
	
	/**
	 * This is the getter method for the consultant property of this InvoiceLineItem
	 * @return the value of the consultant property 
	 */
	public Consultant getConsultant() {
		return this.consultant;
	}
	
	/**
	 * This is the getter method for the skill property of this InvoiceLineItem
	 * @return the value of the skill property
	 */
	public Skill getSkill() {
		return this.skill;
	}
	
	/**
	 * This is the getter method for the hours property of this InvoiceLineItem
	 * @return the value of the hours property
	 */
	public int getHours() {
		return this.hours;
	}
	
	/**
	 * This is the getter method for the charge property of this InvoiceLineItem where the hourly rate
	 * is multiplied by the number of hours
	 * @return the value of the charge 
	 */
	public int getCharge() {
		charge = this.skill.getRate() * this.hours;
		return charge;
	}
	
	/**
	 * This method returns a string representation of this InvoiceLineItem, including the date, the Consultant,
	 * the skill, the hours, and the charge.
	 */
	public String toString() {
		String dt = this.date.toString();
		String cn = this.getConsultant().toString();
		String sk = this.getSkill().toString();
		int hr = this.getHours();
		double ch = this.getCharge();
		return String.format("%1$-15s %2$-20s %3$-25s %4$-10d %5$-10.2f", dt, cn, sk, hr, ch);
	}
}
