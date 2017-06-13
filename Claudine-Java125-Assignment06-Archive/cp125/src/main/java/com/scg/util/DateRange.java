package com.scg.util;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * This class encapsulates a range of two dates, inclusive of the start date and end date.
 * @author Claudine Morales
 *
 */
public class DateRange implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7320248021090146112L;
	java.time.LocalDate startDate;
	java.time.LocalDate endDate;
	java.time.LocalDate date;
	String start;
	String end;
	java.time.Month month;
	int year;
	boolean isInRange = false;
	
	/**
	 * This is a constructor method
	 * @param startDate the earliest date of the DateRange object
	 * @param endDate the latest date of the DateRange object
	 */
	public DateRange(java.time.LocalDate startDate, java.time.LocalDate endDate) {
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	/**
	 * This is a constructor method
	 * @param start the earliest date of the DateRange object in String format, yyyy-MM-dd
	 * @param end the latest date of the DateRange object in String format, yyyy-MM-dd
	 */
	public DateRange(String start, String end) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		this.startDate = LocalDate.parse(start, dtf);
		this.endDate = LocalDate.parse(end, dtf);
	}
	

	/**
	 * This is a constructor method
	 * @param month the month of the DateRange object
	 * @param year the year of the DateRange object
	 */
	public DateRange(java.time.Month month, int year) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		if(month.getValue() >= 10) {
		String parsedStartDate = Integer.toString(year) + "-" + month.getValue() + "-01";
		String parsedEndDate = Integer.toString(year) + "-" + month.getValue() + "-31";
		this.startDate = LocalDate.parse(parsedStartDate, dtf);
		this.endDate = LocalDate.parse(parsedEndDate, dtf);
		} else {
			String parsedStartDate = Integer.toString(year) + "-0" + month.getValue() + "-01";
			String parsedEndDate = Integer.toString(year) + "-0" + month.getValue() + "-31";
			this.startDate = LocalDate.parse(parsedStartDate, dtf);
			this.endDate = LocalDate.parse(parsedEndDate, dtf);
		}

	}
	
	/**
	 * This method returns the start date for this DateRange object
	 * @return the start date for this DateRange
	 */
	public java.time.LocalDate getStartDate() {
		return this.startDate;
	}
	

	/**
	 * This method returns the end date for this DateRange object
	 * @return the end date for this DateRange
	 */
	public java.time.LocalDate getEndDate() {
		return this.endDate;
	}
	
	/**
	 * This boolean method determines if a specified date is within a specific DateRange
	 * @param date the date to check for being within this DateRange
	 * @return if the specified date is within this DateRange
	 */
	public boolean isInRange(java.time.LocalDate date) {
		if(this.getStartDate().compareTo(date) <= 0 && this.getEndDate().compareTo(date) >= 0) {
			return true;
		} else {
			return false;
		}
	}
	
	
}
