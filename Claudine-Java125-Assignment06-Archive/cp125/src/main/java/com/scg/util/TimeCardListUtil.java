package com.scg.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import com.scg.util.DateRange;
import com.scg.domain.Consultant;
import com.scg.domain.TimeCard;

/**
 * This class processes TimeCard lists
 * @author Claudine Morales
 *
 */
public class TimeCardListUtil {
	/**
	 * This method sorts List<TimeCard> in ascending order, by startDate
	 * @param timeCards The list of timeCards to sort
	 */
	public static void sortByStartDate(List<TimeCard> timeCards) {
		Collections.sort(timeCards, new Comparator<TimeCard>() {

			@Override
			public int compare(TimeCard tc1, TimeCard tc2) {
				return (tc1.getWeekStartingDay()).compareTo(tc2.getWeekStartingDay());
			}			
		});
	}
	
	/**
	 * This method sorts List<TimeCard> in ascending order, by Consultant name
	 * @param timeCards The list of timeCards to sort
	 */
	public static void sortByConsultantName(List<TimeCard> timeCards) {
		Collections.sort(timeCards, new Comparator<TimeCard>() {

			@Override
			public int compare(TimeCard tc1, TimeCard tc2) {
				return (tc1.getConsultant()).compareTo(tc2.getConsultant());
			}
		});
	}
	
	/**
	 * This method gets a list of TimeCards with a weekStartingDay that falls within a specific
	 * dateRange. Each time may have time entries through out one week beginning with the time card 
	 * start date.
	 * @param timeCards The list of timeCards to get subset from
	 * @param dateRange The DateRange within which the dates of the returned TimeCards must fall
	 * @return the subset of timeCards that fall within dateRange
	 */
	
	
	//TRADITIONAL:
	/* public static List<TimeCard> getTimeCardsForDateRange(List<TimeCard> timeCards, DateRange dateRange) {
		List<TimeCard> timeCardsWithinRange = new ArrayList<TimeCard>();
		for(TimeCard each : timeCards) {	
			if(dateRange.isInRange(each.getWeekStartingDay())) {
				timeCardsWithinRange.add(each);
			}
		}
		return timeCardsWithinRange;
	}*/
	
	// USING LAMBDAS AND STREAMS:
	public static List<TimeCard> getTimeCardsForDateRange(List<TimeCard> timeCards, DateRange dateRange) {
		List<TimeCard> timeCardsWithinRange = new ArrayList<TimeCard>();
			timeCards
			    .stream()
			    .filter(each -> dateRange.isInRange(each.getWeekStartingDay()))
			    .forEach(each -> timeCardsWithinRange.add(each));
		return timeCardsWithinRange;
	}
	
	/**
	 * This method gets a list of TimeCards for a specific Consultant
	 * @param timeCards the list of timeCards to get subset from
	 * @param consultant the consultant the subset of TimeCards belongs to
	 * @return the subset of TimeCards for the given Consultant
	 */
	
	//TRADITIONAL:
	/*	public static List<TimeCard> getTimeCardsForConsultant(List<TimeCard> timeCards,
            Consultant consultant) {
		List<TimeCard> timeCardsForConsultant = new ArrayList<TimeCard>();
		for(TimeCard each : timeCards) {
			if(each.getConsultant().getName() == consultant.getName()) {
				timeCardsForConsultant.add(each);
			}
		}
				return timeCardsForConsultant;
	}*/
	
	//USING LAMBDAS AND STREAMS:
	
	public static List<TimeCard> getTimeCardsForConsultant(List<TimeCard> timeCards, Consultant consultant) {
		List<TimeCard> timeCardsForConsultant = new ArrayList<TimeCard>();
		timeCards
			.stream()
			.filter(each -> each.getConsultant().getName() == consultant.getName())
			.forEach(each -> timeCardsForConsultant.add(each));
		return timeCardsForConsultant;
	}
}
