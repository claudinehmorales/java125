package com.scg.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * This class monitors SCG's terminations.
 * @author Claudine Morales
 *
 */
public class Eeoc implements TerminationListener {
	
	Logger logger = Logger.getLogger("Eeoc");
	ConsoleHandler handler = new ConsoleHandler();
	
	/**
	 * A list of voluntary termination events
	 */
	List<TerminationEvent> quit = new ArrayList<TerminationEvent>();

	/**
	 * A list of involuntary termination events
	 */
	List<TerminationEvent> fired = new ArrayList<TerminationEvent>();

	/**
	 * Adds the voluntary termination event to List<TerminationEvent> quit and logs a message
	 */
	public void voluntaryTermination(TerminationEvent evt) {	
		quit.add(evt);
		logger.info(evt.getConsultant() + " quit.\n");
	}
	
	/**
	 * Adds the voluntary termination event to List<TerminationEvent> fired and logs a message
	 */
	public void forcedTermination(TerminationEvent evt) {
		fired.add(evt);
		logger.info(evt.getConsultant() + " was fired.\n");
	}
	
	/**
	 * Gets the size of List<TerminationEvent> fired 
	 * @return the size of List<TerminationEvent> fired 
	 */
	public int forcedTerminationCount() {
		return fired.size();
		
	}
	
	/**
	 * Gets the size of List<TerminationEvent> quit
	 * @return the size of List<TerminationEvent> quit 
	 */
	public int voluntaryTerminationCount() {
		return quit.size();
	}
}
