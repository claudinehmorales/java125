package com.scg.domain;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;
import java.time.LocalDate;
import com.scg.util.Address;
import com.scg.util.StateCode;

/**
 * Invoice encapsulates the attributes and behavior to create client invoices for a given time 
 * period from time cards. The invoicing business' name and address are obtained from a properties 
 * file. The name of the property file is specified by the PROP_FILE_NAME static member.
 * 
 * @author Claudine Morales
 */

public final class Invoice implements Serializable {

	/**
	 * The client billed in this Invoice
	 */
	private ClientAccount client;
	
	/**
	 * the month of this Invoice
	 */
	private java.time.Month invoiceMonth;
	
	/**
	 * The year of this Invoice
	 */
	private int invoiceYear;
	
	/**
	 * The startDate for this Invoice
	 */
	private java.time.LocalDate startDate;
	
	/**
	 * The number of total hours in this Invoice
	 */
	private int totalHours;
	
	/**
	 * The amount of total charges in this Invoice
	 */
	private int totalCharges;
	
	/**
	 * An arrayList of line items for this invoice
	 */
	private List<InvoiceLineItem> invoiceLineItems = new ArrayList<InvoiceLineItem>();
	
	/**
	 * The date for hours worked in this invoice
	 */
	private java.time.LocalDate date;
	
	/**
	 * The file name from which invoice properties will be derived
	 */
	private static final java.lang.String PROP_FILE_NAME = "invoice.properties";
	
	/**
	 * The address of the business writing this Invoice
	 */
	private static final Address businessAddress;
	
	/**
	 * The name of the business writing this Invoice
	 */
	private static final String businessName;

	/**
	 * This gets the properties file, loads it, reads it, and derives values for certain properties of the business 
	 * from it.
	 */
	static {
		final Properties prop = new Properties();
		try (InputStream in = Invoice.class.getClassLoader().getResourceAsStream(PROP_FILE_NAME)) {
			prop.load(in);
		} catch (final IOException e) {
			e.printStackTrace();
		}
		businessName = prop.getProperty("business.name");
		final String businessStreet = prop.getProperty("business.street");
		final String businessCity = prop.getProperty("business.city"); 
		final String businessState = prop.getProperty("business.state");
		final String businessZip = prop.getProperty("business.zip");
		businessAddress = new Address(businessStreet, businessCity, StateCode.valueOf(businessState), businessZip);
	}
	
	/**
	 * This is the constructor method
	 * @param client the ClientAccount for this invoice
	 * @param invoiceMonth the Month for which this invoice is being created
	 * @param invoiceYear the Year for which this invoice is being created
	 */
	public Invoice(ClientAccount client, java.time.Month invoiceMonth, int invoiceYear) {
		this.client = client;
		this.invoiceMonth = invoiceMonth;
		this.invoiceYear = invoiceYear;
		date = LocalDate.of(this.invoiceYear, this.invoiceMonth, this.invoiceMonth.maxLength());
	}
	
	/**
	 * This is the getter method for the startDate property of the Invoice
	 * @return the value of the startDate property
	 */
	public java.time.LocalDate getStartDate() {
		return this.startDate;
	}
	
	/**
	 * This is the getter method for the invoiceMonth property of the Invoice
	 * @return the value of the invoiceMonth property
	 */
	public java.time.Month getInvoiceMonth() {
		return this.invoiceMonth;
	}
	
	/**
	 * This is the getter method for the client property of the Invoice
	 * @return the value of the client property 
	 */
	public ClientAccount getClientAccount() {
		return this.client;
	}
	
	/**
	 * This is the getter method for the totalHours property of the Invoice
	 * @return the value of the totalHours property
	 */
	public int getTotalHours() {
		return this.totalHours;
	}
	
	/**
	 * This is the getter method for the totalCharges property of the Invoice
	 * @return the value of the totalCharges property
	 */
	public int getTotalCharges() { 
		return this.totalCharges;
	}
	
	/**
	 * This method adds a lineItem to an Invoice
	 * @param lineItem the lineItem to be added
	 */
	public void addLineItem(InvoiceLineItem lineItem) {
		invoiceLineItems.add(lineItem);
		this.totalHours = totalHours + lineItem.getHours();
		this.totalCharges = totalCharges + lineItem.getSkill().getRate() * lineItem.getHours();
	}
	
	/**
	 * This method verifies the size of invoiceLineItems
	 * @return the size of invoiceLineItems
	 */
	public int getLineItemCount() {
		return this.invoiceLineItems.size();
	}
	
	/**
	 * This method extracts billable hours for this Invoice's client from the input TimeCard
	 * and adds them to the line items.
	 * @param timeCard the TimeCard potentially containing line items for this Invoices client
	 */
	public void extractLineItems(TimeCard timeCard) {
		List<ConsultantTime> bs = timeCard.getBillableHoursForClient(this.client.getName());
		ConsultantTime[] cta = bs.toArray(new ConsultantTime[bs.size()]);
		for(int i=0; i<=cta.length-1; i++) {
			if(cta[i].getDate().getMonth() == this.invoiceMonth) {	
				InvoiceLineItem ili = new InvoiceLineItem(cta[i].getDate(), timeCard.getConsultant(), cta[i].getSkill(), cta[i].getHours());
				addLineItem(ili);
			}
		}
	}	
	
//	public void extractLineItems(TimeCard timeCard) {
//		
//		List<ConsultantTime> bs = timeCard.getBillableHoursForClient(this.client.getName());
//		bs
//			.stream()
//			.filter(each -> each.getDate().getMonth() == this.invoiceMonth)
//			.forEach(each -> addLineItem(new InvoiceLineItem(each.getDate(), timeCard.getConsultant(), each.getSkill(), each.getHours())));	
//	}
	
	/**
	 * This method contains a string representation of this Invoice object
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.client);
		sb.append("\n");
		sb.append(this.startDate);
		return sb.toString();
	}
	
	/**
	 * This method creates a formatted string containing the printable invoice. It includes a header and
	 * a footer on each page.
	 * @return the formatted string
	 */
	public String toReportString()  {
		int hr = this.totalHours;
		double ch = (double) this.totalCharges;
		
		InvoiceHeader myHeader = new InvoiceHeader(businessName, businessAddress, this.client, date, date);
		InvoiceFooter myFooter = new InvoiceFooter(businessName);
		
		StringBuilder sb = new StringBuilder();
		String div = "----------------------------------------------------------------------------------";
		String div2 = "==================================================================================";
		sb.append("\n");
        sb.append(myHeader);
		sb.append("\nDATE            CONSULTANT           SKILL                 HOURS          CHARGE\n" );
		sb.append(div);
		sb.append("\n");
		
		InvoiceLineItem[] lineItemsArray = invoiceLineItems.toArray(new InvoiceLineItem[invoiceLineItems.size()]);
		for(int i=0; i<= lineItemsArray.length-1; i++) {
			if(i % 5 == 0 && i != 0) {
				sb.append("\n");
				sb.append(myFooter);
				sb.append("\n");
				sb.append(div2);
				sb.append("\n");
				sb.append("\n");
				sb.append("\n");
				sb.append(myHeader);
				sb.append("\nDATE            CONSULTANT           SKILL                 HOURS          CHARGE\n" );
				sb.append(div);
				myFooter.incrementPageNumber();			
			} else {
				sb.append(lineItemsArray[i]);
			}		
		sb.append("\n");
	}
		sb.append("\n");
		sb.append(String.format("Total: %1$57d %2$16.2f", hr, ch));
		sb.append("\n");
		sb.append("\n");
		sb.append(myFooter);
		sb.append("\n");
		sb.append(div2);
		return sb.toString();
	}
}


