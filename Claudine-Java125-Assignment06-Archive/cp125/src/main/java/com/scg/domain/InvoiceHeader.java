package com.scg.domain;

import java.time.LocalDate;
import com.scg.util.Address;
final class InvoiceHeader {
	
	/**
	 * The name of the business writing this Invoice
	 */
	private String businessName;
	
	/**
	 * The address of the business writing this Invoice
	 */
	private Address businessAddress;
	
	/**
	 * The client this Invoice is for
	 */
	private ClientAccount client;
	
	/**
	 * The date of this Invoice
	 */
	private LocalDate invoiceDate;
	
	/**
	 * The month of this Invoice
	 */
	private LocalDate invoiceForMonth;

	/**
	 * This is the constructor 
	 * @param businessName the name of the business
	 * @param businessAddress the address of the business
	 * @param client the client
	 * @param invoiceDate the date the invoice is being made for
	 * @param invoiceForMonth the month the invoice is being made for
	 */
	public InvoiceHeader(String businessName, Address businessAddress, ClientAccount client,
            java.time.LocalDate invoiceDate, java.time.LocalDate invoiceForMonth) {
		this.businessName = businessName;
		this.businessAddress = businessAddress;
		this.client = client;
		this.invoiceDate = invoiceDate;
		this.invoiceForMonth = invoiceForMonth;
	}
	
	/**
	 * This method creates a string representation of this InvoiceHeader object. It contains the businessName,
	 * businessAddress, the client, the invoiceForMonth, and the invoiceDate.
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.businessName);
		sb.append("\n");
		sb.append(this.businessAddress);
		sb.append("\n");
		sb.append("\n");
		sb.append("Invoice for:");
		sb.append("\n");
		sb.append(this.client.getName());
		sb.append("\n");
		sb.append(this.client.getAddress());
		sb.append("\n");
		sb.append(this.client.getContact());
		sb.append("\n");
		sb.append("\n");
		sb.append("Invoice for month of: " + this.invoiceForMonth);
		sb.append("\n");
		sb.append("Invoice date: " + this.invoiceDate);
		sb.append("\n");
		return sb.toString();
	}

}
