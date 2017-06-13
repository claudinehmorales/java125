package com.scg.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import java.util.logging.*;

/**
 * This class is responsible for logging changes in benefits
 * @author Claudine Morales
 *
 */
public class BenefitManager implements PropertyChangeListener {

	/**
	 * This method logs the PropertyChangeEvent
	 */
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		
		Logger logger = Logger.getLogger("BenefitManager");
		logger.info(evt.getPropertyName() + " change from old value " + evt.getOldValue() + " to new value " + 
				evt.getNewValue() + " for " + evt.getSource() + "\n");
	}
}
