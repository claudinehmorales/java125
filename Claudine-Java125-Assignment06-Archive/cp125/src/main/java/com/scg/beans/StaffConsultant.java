package com.scg.beans;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.beans.VetoableChangeSupport;
import java.io.Serializable;

import com.scg.domain.Consultant;
import com.scg.util.Name;

/**
 * This class encapsulates a Consultant who is kept on staff and receives
 * benefits
 * 
 * @author claudinemorales
 *
 */
public class StaffConsultant extends Consultant implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8016979012766020063L;

	/**
	 * The pay rate
	 */
	private int payRate;

	/**
	 * The number of sick leave hours
	 */
	private int sickLeaveHours;

	/**
	 * The number of vacation hours
	 */
	private int vacationHours;

	/**
	 * The pay rate property name
	 */
	public static final String PAY_RATE_PROPERTY_NAME = "payRate";

	/**
	 * The vacation hours property name.
	 */
	public static final String VACATION_HOURS_PROPERTY_NAME = "vacationHours";

	/**
	 * The pay rate property name.
	 */
	public static final String SICK_LEAVE_HOURS_PROPERTY_NAME = "sickLeaveHours";

	/**
	 * The PropertyChangeSupport object
	 */
	private PropertyChangeSupport mPcs = new PropertyChangeSupport(this);

	/**
	 * The VetoableChangeSupport object
	 */
	private VetoableChangeSupport mVcs = new VetoableChangeSupport(this);

	/**
	 * The constructor method
	 * 
	 * @param name the name of the StaffConsultant
	 * @param rate the pay rate
	 * @param sickLeave the number of sick leave hours
	 * @param vacation the number of vacation hours
	 */
	public StaffConsultant(Name name, int rate, int sickLeave, int vacation) {
		super(name);
		this.payRate = rate;
		this.sickLeaveHours = sickLeave;
		this.vacationHours = vacation;
	}

	/**
	 * The getter for the payRate property
	 * @return
	 */
	public int getPayRate() {
		return this.payRate;
	}

	/**
	 * The setter for the payRate property. Fires a VetoableChangeEvent
	 * @param payRate
	 * @throws PropertyVetoException
	 */
	public synchronized void setPayRate(int payRate) throws PropertyVetoException {
		// this should fire a PropertyChangeEvent
		int originalPayRate = this.payRate;
		int diff = payRate - originalPayRate;
		float pctChange = (float) diff / originalPayRate;

		try {
			if (pctChange > 0.05) {
				mVcs.fireVetoableChange(PAY_RATE_PROPERTY_NAME, originalPayRate, payRate);
				this.payRate = originalPayRate;
			} else {
				mPcs.firePropertyChange(PAY_RATE_PROPERTY_NAME, originalPayRate, payRate);
				this.payRate = payRate;
			}
		} catch (PropertyVetoException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Adds a general PropertyChangeListener object
	 * @param l the listener
	 */
	public synchronized void addPropertyChangeListener(PropertyChangeListener l) {
		mPcs.addPropertyChangeListener(l);
	}

	/**
	 * Removes a PropertyChangeListener object
	 * @param l the listener
	 */
	public synchronized void removePropertyChangeListener(PropertyChangeListener l) {
		mPcs.removePropertyChangeListener(l);
	}

	/**
	 * Adds a general PropertyChangeListener object
	 * @param l the listener
	 */
	public synchronized void addPayRateListener(PropertyChangeListener l) {
		mPcs.addPropertyChangeListener(l);
	}

	/**
	 * Removes a general PropertyChangeListener object
	 * @param l the listener
	 */
	public synchronized void removePayRateListener(PropertyChangeListener l) {
		mPcs.removePropertyChangeListener(l);
	}

	/**
	 * a general VetoableChangeListener object
	 * @param l the listener
	 */
	public synchronized void addVetoableChangeListener(VetoableChangeListener l) {
		mVcs.addVetoableChangeListener(l);
	}

	/**
	 * Removes a general VetoableChangeListener object
	 * @param l the listener
	 */
	public synchronized void removeVetoableChangeListener(VetoableChangeListener l) {
		mVcs.removeVetoableChangeListener(l);
	}

	/**
	 * The getter for the sickLeaveHours property
	 * @return the value for the sickLeaveHours property
	 */
	public int getSickLeaveHours() {
		return this.sickLeaveHours;
	}

	/**
	 * The setter for the sickLeaveHours property. Fires a PropertyChangeEvent
	 * @param sickLeaveHours the number of sick leave hours
	 */
	public synchronized void setSickLeaveHours(int sickLeaveHours) {
		// this should fire a PropertyChangeEvent
		int originalSickLeaveHours = this.sickLeaveHours;
		this.sickLeaveHours = sickLeaveHours;
		mPcs.firePropertyChange(SICK_LEAVE_HOURS_PROPERTY_NAME, originalSickLeaveHours, sickLeaveHours);
	}

	/**
	 * Adds a general PropertyChangeListener object
	 * @param l the listener
	 */
	public synchronized void addSickLeaveHoursListener(PropertyChangeListener l) {
		mPcs.addPropertyChangeListener(SICK_LEAVE_HOURS_PROPERTY_NAME, l);
	}

	/**
	 * Removes a general PropertyChangeListener object
	 * @param l the listener
	 */
	public synchronized void removeSickLeaveHoursListener(PropertyChangeListener l) {
		mPcs.removePropertyChangeListener(SICK_LEAVE_HOURS_PROPERTY_NAME, l);
	}

	/**
	 * The getter for the vacationHours property
	 * @return the value fo the vacationHours property
	 */
	public int getVacationHours() {
		return this.vacationHours;
	}

	/**
	 * The setter for the vacationHours property. Fires a PropertyChangeEvent
	 * @param vacationHours the number of vacation hours
	 */
	public synchronized void setVacationHours(int vacationHours) {
		// should fire a PropertyChangeEvent
		int originalVacationHours = this.vacationHours;
		this.vacationHours = vacationHours;
		mPcs.firePropertyChange(VACATION_HOURS_PROPERTY_NAME, originalVacationHours, vacationHours);
	}

	/**
	 * Adds a a general PropertyChangeListener object
	 * @param l the listener
	 */
	public synchronized void addVacationHoursListener(PropertyChangeListener l) {
		mPcs.addPropertyChangeListener(VACATION_HOURS_PROPERTY_NAME, l);
	}
	
	/**
	 * Removes a general PropertyChangeListener object
	 * @param l the listener
	 */
	public synchronized void removeVacationHoursListener(PropertyChangeListener l) {
		mPcs.removePropertyChangeListener(VACATION_HOURS_PROPERTY_NAME, l);
	}

	/**
	 * Calculates the object's hashCode
	 */
	public int hashCode() {
		return this.hashCode();
	}
}
