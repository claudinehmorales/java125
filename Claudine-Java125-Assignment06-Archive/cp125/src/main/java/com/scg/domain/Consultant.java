package com.scg.domain;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Comparator;

import com.scg.util.Name;

/**
 * This class encapsulates information re: the consultant
 * @author Claudine Morales
 *
 */


@SuppressWarnings("serial")
public class Consultant implements Comparable<Consultant>, Serializable {


	/**
	 * The name of this Consultant
	 */
	private Name name;

	/**
	 * The constructor method 
	 * @param name the name of the consultant
	 */
	public Consultant (Name name) {
		this.name = name;		
	}
	
	/**
	 * This is the getter method for the name property
	 * @return the name of the consultant
	 */
	public final Name getName() {
		return name;
	}
	
	/**
	 * This method prints out the name of the consultant
	 */
	public final String toString() {
		return this.getName().toString();
	}

	public final int compareTo(Consultant other) {
		return ((this.toString().compareTo(other.toString())));
	}
	
	/**
	 * This method is used to return the Consultant object serialized in the SerializationProxy class in a formatted 
	 * string 
	 * @return this ConsultantObject
	 */
	private Object writeReplace() {
		final String ellipsis = "...";
		final String msg = String.format("Serializing consultant %s, %s", getName(), ellipsis);
		System.out.println(msg);
		return new SerializationProxy(this);
	}
	
	/**
	 * This method reads the serialized Consultant object and throws an exception if it's determined that the proxy
	 * was not used in the creation of the Consultant object
	 * @param ois the ObjectInputStream object
	 * @throws InvalidObjectException
	 */
	private void readObject(final ObjectInputStream ois) 
		throws InvalidObjectException {
			throw new InvalidObjectException("Proxy required");
	}
	
	/**
	 * This nested class encapsulates the creation of a serialized Consultant object using a proxy
	 * @author Claudine Morales
	 *
	 */
	private static final class SerializationProxy implements Serializable {
		
		private static final long serialVersionUID = 5184412602342122398L;
		
		/**
		 * This Consultant's lastName
		 */
		private final String lastName;
		
		/**
		 * This Consultant's firstName
		 */
		private final String firstName;
		
		/**
		 * This Consultants middleName
		 */
		private final String middleName;
		
		/**
		 * This is the constructor method
		 * @param consultant The Consultant object
		 */
		@SuppressWarnings("unused")
		SerializationProxy(final Consultant consultant) {
			final Name name = consultant.getName();
			lastName = name.getLastName();
			firstName = name.getFirstName();
			middleName = name.getMiddleName();
		}
		
		/**
		 * This method deserializes the serialized Consultant object
		 * @return
		 */
		private Object readResolve() {
			final String ellipsis = "...";
			final String msg = String.format("Deserializing consultant %s, %s, %s, %s", lastName, firstName, middleName,
					ellipsis);
			System.out.println(msg);
			return new Consultant(new Name(lastName, firstName, middleName));
		}
	}
}
