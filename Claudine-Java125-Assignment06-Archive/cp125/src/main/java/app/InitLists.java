package app;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.scg.domain.ClientAccount;
import com.scg.domain.Consultant;
import com.scg.domain.Invoice;
import com.scg.domain.TimeCard;
import com.scg.util.DateRange;
import com.scg.util.ListFactory;
import com.scg.util.TimeCardListUtil;

/**
 * Assignment 04 application.
 */
public final class InitLists implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/** The invoice month. */
	private static final Month INVOICE_MONTH = Month.MARCH;

	/** The test year. */
	private static final int INVOICE_YEAR = 2006;

	/**
	 * The main method populates the accounts, consultants, and timeCards lists, and then serializes accounts
	 * and consultants into two different files, namely ClientList.ser and TimeCards.ser.
	 * @throws IOException
	 */
	public static void main(final String[] args) throws IOException {
		System.out.println("Serializing lists...");
		// Create lists and populate them by ListFactory
		final List<ClientAccount> accounts = new ArrayList<ClientAccount>();
		final List<Consultant> consultants = new ArrayList<Consultant>();
		final List<TimeCard> timeCards = new ArrayList<TimeCard>();
		ListFactory.populateLists(accounts, consultants, timeCards);

		// Serialize ClientAccount list
		try {
			FileOutputStream cfos = new FileOutputStream("ClientList.ser");
			ObjectOutputStream cloos = new ObjectOutputStream(cfos);
			cloos.writeObject(accounts);
			cloos.close();
			cfos.close();
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		// Serialize TimeCard list
		try {
			FileOutputStream tfos = new FileOutputStream("TimeCards.ser");
			ObjectOutputStream tcoos = new ObjectOutputStream(tfos);
			tcoos.writeObject(timeCards);
			tcoos.close();
			tfos.close();
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
