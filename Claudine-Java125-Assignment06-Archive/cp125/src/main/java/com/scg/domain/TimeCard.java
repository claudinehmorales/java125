package com.scg.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Formatter;
import java.util.List;

/**
 * This class encapsulates a time card capable of storing a consultant's billable and non-billable hours for a week.
 * @author Claudine Morales
 *
 */

@SuppressWarnings("serial")
public final class TimeCard implements Comparable<TimeCard>, Serializable {
	
	/**
	 * The beginning date for this TimeCard
	 */
	private java.time.LocalDate weekStartingDay;
	
	/**
	 * The consultant on this TimeCard
	 */
	private Consultant consultant;
	
	/**
	 * The total number of billable hours in this TimeCard
	 */
	private int totalBillableHours;
	
	/**
	 * The total number of nonbillable hours in this TimeCard
	 */
	private int totalNonBillableHours;
	
	/**
	 * An ArrayList of hours for the consultant named in this TimeCard
	 */
	private List<ConsultantTime> consultingHours = new ArrayList<ConsultantTime>();
	
	/**
	 * The total number of hours in this TimeCard
	 */
	private int totalHours;
	
	/**
	 * An ArrayList of ConsultantTime objects that are billable for a certain client
	 */
	private List<ConsultantTime> billableHoursForClient = new ArrayList<ConsultantTime>();
	
	/**
	 * The name of the client
	 */
	private String clientName;

	/**
	 * This is the constructor method
	 * @param consultant the object of type Consultant for which the time card is being created
	 * @param weekStartingDay the starting day of the pay period
	 */
	public TimeCard(Consultant consultant, java.time.LocalDate weekStartingDay){
		this.consultant = consultant;
		this.weekStartingDay = weekStartingDay;
		this.clientName = clientName;
	}

	/**
	 * The getter method for the consultant property
	 * @return the object of type Consultant for which the time card is created
	 */
	public Consultant getConsultant() {
		return this.consultant;
	}
	
	
	/**
	 * The getter method for the total billable hours property
	 * @return the set total billable hours on a time card
	 */
	public int getTotalBillableHours() {
		return this.totalBillableHours;
	}
	
	/**
	 * The getter method for the total nonbillable hours property
	 * @return the total nonbillable hours on a time card
	 */
	public int getTotalNonBillableHours() {
		return this.totalNonBillableHours;
	}
	
	/**
	 * The getter method for the consulting hours property
	 * @return a list of consulting hours on a time card
	 */
	public List<ConsultantTime> getConsultingHours() {
		return this.consultingHours;
	}
	
	/**
	 * This method adds a consultant's time into a time card
	 * @param consultantTime the object of type ConsultantType that gets added into the time card
	 */
	public void addConsultantTime(ConsultantTime consultantTime) {
		totalHours = totalHours + consultantTime.getHours();
		consultingHours.add(consultantTime);
		if(consultantTime.isBillable()) {
			billableHoursForClient.add(consultantTime);
			totalBillableHours = totalBillableHours + consultantTime.getHours();
		} else {
			totalNonBillableHours = totalNonBillableHours + consultantTime.getHours();
		}
	}
	
	/**
	 * The getter method for the totalHours property
	 * @return the total hours on a time card
	 */
	public int getTotalHours() {
		return this.totalHours;
	}
	
	/**
	 * The getter method for the weekStartingDay property
	 * @return the week starting day of the time card
	 */
	public java.time.LocalDate getWeekStartingDay() {
		return weekStartingDay;
	}
	
	/**
	 * The getter method for the ArrayList of billableHours for a certain client. The ConsultantTime object
	 * is added to an ArrayList called billableTimeToInvoice if the clientName for that ConsultantTime object
	 * matches the clientName passed in this method. 
	 * @param clientName the String name of the client
	 * @return an ArrayList of billable ConsultantTime objects that matches the clientName
	 */
	public List<ConsultantTime> getBillableHoursForClient(String clientName) {
		List<ConsultantTime> billableTimeToInvoice = new ArrayList<ConsultantTime>();
		for(ConsultantTime ct: billableHoursForClient) {
			if(ct.getAccount().getName().toString().equals(clientName)){
				billableTimeToInvoice.add(ct);
			}
			
		}return billableTimeToInvoice;
	}
	
//	// USING LAMBDAS AND STREAM
//	public List<ConsultantTime> getBillableHoursForClient(String clientName) {
//		List<ConsultantTime> billableTimeToInvoice = new ArrayList<ConsultantTime>();
//		billableHoursForClient.stream()
//							  .filter(each -> each.getAccount().getName().toString() == clientName)
//			                  .forEach(each -> billableTimeToInvoice.add(each));
//		return billableTimeToInvoice;
//	}
	
	/**
	 * This method prints out a string representation of the consultant and the week starting day for a time card
	 */
	public String toString() {
		return (this.consultant.getName()).toString() + this.weekStartingDay.toString();
	}
	
	/**
	 * This method prints out a formatted time card that includes information on billable hours, nonbillable hours,
	 * and summary totals.
	 * @return a formatted time card
	 */
	public String toReportString() {
		String div = "----------------------------------------------------------------------------------";
		String div2 = "==================================================================================";
		int tbh = this.totalBillableHours;
		int tnbh = this.totalNonBillableHours;
		int th = this.totalHours;
		
		// format week starting day
		Formatter fmt = new Formatter();
	    LocalDate cal = this.weekStartingDay;
	    fmt.format("%tb %td %ty", cal, cal, cal);

		String cn = this.getConsultant().getName().toString();
		
		// Build string for billable time
		StringBuilder n = new StringBuilder();
		for(ConsultantTime each: consultingHours) {
			if(!each.isBillable()) {
				n.append(each.toString() + "\n");
			}
		}
		String nstr = n.toString();
		
		// Build string for nonbillable time
		StringBuilder o = new StringBuilder();
		for(ConsultantTime each: consultingHours) {
			if(each.isBillable()) {
				o.append(each.toString() + "\n");
			}
		} 
		String ostr = o.toString();

		// return statement
		return String.format(div2 + "\nConsultant: %1$-40s Week Starting: %2$10s\n" + div2 
				+ "\nBillable Time:"
				+ "\nACCOUNT                        DATE             HOURS          SKILL\n" 
				+ div
				+ "\n%3$80s" 
				+ "\nNonBillable Time:"
				+ "\nACCOUNT                        DATE             HOURS          SKILL\n" 
				+ div
				+ "\n%4$80s"
				+ "\nSummary:"
				+ "\nTotal Billable:    %5$-40s\nTotal NonBillable: %6$-40s\nTotal Hours:       %7$-40s" 				
				+ "\n", cn, fmt, ostr, nstr, tbh, tnbh, th)
				+ "\n" + div2 + "\n";
	}

	/**
	 * This method compares TimeCard, by ascending date order, consultant, totalHours, totalBillableHours 
	 * and totalNonBillableHours.
	 * @param other The other TimeCard to compare to
	 * @return a negative integer, zero, or a positive integer as this object is less than, equal to, or greater 
	 * than the specified object.
	 */
	public int compareTo(TimeCard other) {
		// return ((this.toString().compareTo(other.toString())));
		int consultantsAreEqual = 0;
		consultantsAreEqual = this.getConsultant().toString().compareTo(other.getConsultant().toString());
		if(consultantsAreEqual != 0) {
			if (consultantsAreEqual < 0) {
				return -1;
			} else {
				return 1;
			}
		}
		
		int startingDaysAreEqual = 0;
		startingDaysAreEqual = this.getWeekStartingDay().compareTo(other.getWeekStartingDay());
		if(startingDaysAreEqual != 0) {
			if (startingDaysAreEqual < 0) {
				return -1;
			} else {
				return 1;
			}
		}

		int firstTimeCardHours = this.getTotalHours();
		int secondTimeCardHours = other.getTotalHours();
		if (firstTimeCardHours != secondTimeCardHours) {
			if (firstTimeCardHours < secondTimeCardHours) {
				return -1;
			} else {
				return 1;
			}
		}
		
		int firstTimeCardBillables = this.getTotalBillableHours();
		int secondTimeCardBillables = other.getTotalBillableHours();
		if (firstTimeCardBillables != secondTimeCardBillables) {
			if (firstTimeCardBillables < secondTimeCardBillables) {
				return -1;
			} else {
				return 1;
			}
		}
		return 0;
	}
}
