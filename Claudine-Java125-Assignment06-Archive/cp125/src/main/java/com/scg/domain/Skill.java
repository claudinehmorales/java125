package com.scg.domain;

/**
 * This enum encapsulates the different skills that consultants might possess
 * @author Claudine Morales
 *
 */

public enum Skill {	
	PROJECT_MANAGER ("Project Manager", 250),
	SYSTEM_ARCHITECT ("System Architect", 200),
	SOFTWARE_ENGINEER ("Software Engineer", 150),
	SOFTWARE_TESTER ("Software Tester", 100),
	UNKNOWN_SKILL ("Unknown Skill", 0);
	
	/**
	 * The string representation of this skill
	 */
	private String skill;
	
	/**
	 * The rate charged per hour for this skill
	 */
	private int rate;

	/**
	 * This allows an enum type to be set using a string value
	 * @param name the string value of the skill
	 */
	private Skill(String skill, int rate) {
		this.skill = skill;
		this.rate = rate;
	}
	
	/**
	 * This is the getter method for the designated rate for the skill
	 * @return the rate for the skill
	 */
	public int getRate(){
		return this.rate;
	}
	
	/**
	 * This returns a string representation of the skill
	 */
	public String toString() {
		return this.skill;
	}
}




