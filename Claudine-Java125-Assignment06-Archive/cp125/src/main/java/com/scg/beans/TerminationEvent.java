package com.scg.beans;

import java.util.EventObject;

import com.scg.domain.Consultant;

public final class TerminationEvent extends EventObject {
	
	/**
	 * Event used to notify listeners of a Consultant's termination.
	 */
	private static final long serialVersionUID = -8977759411881719732L;
	
	/**
	 * The source of the event
	 */
	private Object source;
	
	/**
	 * The Consultant object
	 */
	private Consultant consultant;
	
	/**
	 * A boolean that determines if a TerminationEvent was voluntary or otherwise
	 */
	private boolean voluntary;
	
	/**
	 * The constructor method
	 * @param source The event source 
	 * @param consultant The Consultant object
	 * @param voluntary Determines if a TerminationEvent was voluntary or otherwise
	 */
	public TerminationEvent(Object source, Consultant consultant, boolean voluntary) {
		super(source);
		this.consultant = consultant;
		this.voluntary = voluntary;
	}
	
	/**
	 * Gets the voluntary termination status
	 * @return true if the termination status is voluntary
	 */
	public boolean isVoluntary() {
		return voluntary;
	}
	
	/**
	 * Gets the Consultant object
	 * @return the Consultant object
	 */
	public Consultant getConsultant() {
		return this.consultant;
	}
}
