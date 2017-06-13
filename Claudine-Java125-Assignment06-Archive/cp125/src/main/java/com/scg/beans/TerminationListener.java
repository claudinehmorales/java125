package com.scg.beans;

import java.util.EventListener;

/**
 * This serves as an interface for accepting notification of consultant terminations.
 * @author Claudine Morales
 *
 */
public interface TerminationListener extends EventListener {
	
	/**
	 * Invoked when a consultant is voluntarily terminated.
	 * @param evt the TerminationEvent
	 */
	void voluntaryTermination(TerminationEvent evt);
	
	/**
	 * Invoked when a consultant is involuntarily terminated.
	 * @param evt the TerminationEvent
	 */
	void forcedTermination(TerminationEvent evt);

}
