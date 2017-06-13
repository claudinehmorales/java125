package com.scg.util;

import java.util.Comparator;

import com.scg.domain.TimeCard;

/**
 * This class implements the Comparator interface. It compares the consultant values of two TimeCard 
 * objects.
 * @author Claudine Morales
 */

public final class TimeCardConsultantComparator implements Comparator<TimeCard>{
	
	public TimeCardConsultantComparator(){
		
	}

	/**
	 * Compares its two arguments for order. Returns a negative integer, zero, or a positive integer as the first argument 
	 * is less than, equal to, or greater than the second.
	 * @param firstTimeCard the first TimeCard to be compared
	 * @param secondTimeCard the second TimeCard to be compared
	 * @return a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater 
	 * than the second.
	 */
	@Override
	public int compare(TimeCard firstTimeCard, TimeCard secondTimeCard) {
		// TODO Auto-generated method stub
		//return ((firstTimeCard.getConsultant().toString()).compareTo(secondTimeCard.getConsultant().toString()));
		
		int consultantsAreEqual = 0;
		consultantsAreEqual = firstTimeCard.getConsultant().toString().compareTo(secondTimeCard.getConsultant().toString());
		if(consultantsAreEqual != 0) {
			if (consultantsAreEqual < 0) {
				return -1;
			} else {
				return 1;
			}
		}
		
		int startingDaysAreEqual = 0;
		startingDaysAreEqual = firstTimeCard.getWeekStartingDay().compareTo(secondTimeCard.getWeekStartingDay());
		if(startingDaysAreEqual != 0) {
			if (startingDaysAreEqual < 0) {
				return -1;
			} else {
				return 1;
			}
		}

		int firstTimeCardHours = firstTimeCard.getTotalHours();
		int secondTimeCardHours = secondTimeCard.getTotalHours();
		if (firstTimeCardHours != secondTimeCardHours) {
			if (firstTimeCardHours < secondTimeCardHours) {
				return -1;
			} else {
				return 1;
			}
		}
		
		int firstTimeCardBillables = firstTimeCard.getTotalBillableHours();
		int secondTimeCardBillables = secondTimeCard.getTotalBillableHours();
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
