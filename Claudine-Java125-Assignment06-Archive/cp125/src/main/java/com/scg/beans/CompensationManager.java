package com.scg.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.util.logging.Logger;

/**
 * This class approves or rejects compensation changes.
 * @author Claudine Morales
 *
 */
public class CompensationManager implements PropertyChangeListener, VetoableChangeListener {

	Logger logger = Logger.getLogger("CompensationManager");

	/**
	 * This method vetoes any payRate change over 5% 
	 */
	@Override
	public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
		int originalPayRate = (int) evt.getOldValue();
		int newPayRate = (int) evt.getNewValue();
		int diff = newPayRate - originalPayRate;
		float pctChange = (float) diff / originalPayRate * 100;
		logger.info("REJECTED " + evt.getPropertyName() + " change from old value " + evt.getOldValue() + " to new value " + 
				evt.getNewValue() + " for " + evt.getSource() + "\n");
		logger.info("Denied " + evt.getPropertyName() + " for " + evt.getSource() + "\n");
	}

	/**
	 * This method processes the payRate change
	 */
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		logger.info("APPROVED " + evt.getPropertyName() + " change from old value " + evt.getOldValue() + " to new value " + 
				evt.getNewValue() + " for " + evt.getSource() + "\n");
	}

}
