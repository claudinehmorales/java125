package com.scg.domain;

public class InvoiceFooter {
	
	/**
	 * This is the iterator
	 */
	private int i = 1;
	
	/**
	 * The name of the business writing the invoice
	 */
	private String businessName;

	/**
	 * This is the constructor method
	 * @param businessName the name of the business
	 */
	public InvoiceFooter(String businessName) {
		this.businessName = businessName;
	}
	
	/**
	 * This method increments the page number everytime it's called
	 */
	public void incrementPageNumber() {
		i++;
	}
	
	/**
	 * This is the string representation of this InvoiceFooter object. It contains the businessName and the
	 * page number.
	 */
	public String toString() {
		return String.format("%1$-68s Page: %2$6d", this.businessName, i) ;
	}
}
