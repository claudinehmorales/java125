package com.scg.beans;

import java.beans.PropertyVetoException;
import java.beans.VetoableChangeSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.scg.domain.Consultant;

/**
 * This class is responsible for managing pay rate, sick leave, and vacation hours of StaffConsultant objects.
 * @author Claudine Morales
 *
 */
public class HumanResourceManager {
	
	/**
	 * A list of TerminationListener objects
	 */
	private List<TerminationListener> tl = new ArrayList<TerminationListener>();
	
	/**
	 * A Logger object
	 */
	Logger logger = Logger.getLogger("HumanResourceManager");
	
	/**
	 * Adjusts a StaffConsultant's payRate. Throws a PropertyVetoException
	 * @param c the StaffConsultant
	 * @param newPayRate the payRate to be set
	 */
	public void adjustPayRate(StaffConsultant c, int newPayRate)  {
		try {
			int originalPayRate = c.getPayRate();
			c.setPayRate(newPayRate);
			int diff = newPayRate - originalPayRate;
			float pctChange = (float) diff / originalPayRate * 100;
			logger.info("% change: " + "( " + newPayRate + " - " + originalPayRate + " ) / " + originalPayRate + " = " + pctChange + "\n");
			
		} catch (PropertyVetoException ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * Adjusts a StaffConsultant's sickLeaveHours property
	 * @param c the StaffConsultant
	 * @param newSickLeaveHours the number of sickLeaveHours to set
	 */
	public void adjustSickLeaveHours(StaffConsultant c, int newSickLeaveHours) {
		c.setSickLeaveHours(newSickLeaveHours);
	}
	
	/**
	 * Adjusts a StaffConsultant's vacationHours property
	 * @param c the Consultant
	 * @param newVacationHours the number of vacationHours
	 */
	public void adjustVacationHours(StaffConsultant c, int newVacationHours) {
		c.setVacationHours(newVacationHours);
	}
	
	/**
	 * Fires a voluntary TerminationEvent for the StaffConsultant
	 * @param c the Consultant
	 */
	public void acceptResignation(Consultant c) {
		TerminationEvent resignation = new TerminationEvent(this, c, true);
		for (TerminationListener each : tl) {
			each.voluntaryTermination(resignation);
		}
	}
	
	/**
	 * Fires an involuntary TerminationEvent for the staff consultant.
	 * @param c the Consultant
	 */
	public void terminate(Consultant c) {
		TerminationEvent forced = new TerminationEvent(this, c, false);
		for (TerminationListener each : tl) {
			each.forcedTermination(forced);
		}
	}
	
	/**
	 * Adds a TerminationListener
	 * @param l the listener
	 */
	public void addTerminationListener(TerminationListener l) {
		tl.add(l);
	}
	
	/**
	 * Removes a TerminationListener
	 * @param l the listener
	 */
	public void removeTerminationListener(TerminationListener l) {
		tl.remove(l);
	}
}
