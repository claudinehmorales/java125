package app;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintStream;
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
import com.scg.util.TimeCardListUtil;

/**
 * Assignment 05 application.
 */
public final class Assignment05 implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The invoice month. */
	private static final Month INVOICE_MONTH = Month.MARCH;

	/** The test year. */
	private static final int INVOICE_YEAR = 2006;

	private static List<Invoice> invoices = new ArrayList<Invoice>();
	private static List<TimeCard> timeCardList = new ArrayList<TimeCard>();
	/** This class' logger. */
	private static final Logger log = LoggerFactory.getLogger("Assignment05");

	/**
	 * Prevent instantiation.
	 */
	private Assignment05() {
	}

	/**
	 * This method creates invoices for the clients from the timecards.
	 * @param accounts the accounts to create the invoices for
	 * @param timeCards the time cards to create the invoices from
	 * @return the created invoices
	 */
	private static List<Invoice> createInvoices(final List<ClientAccount> accounts, final List<TimeCard> timeCards) {
		final List<Invoice> invoices = new ArrayList<Invoice>();
		final List<TimeCard> timeCardList = TimeCardListUtil.getTimeCardsForDateRange(timeCards,
				new DateRange(INVOICE_MONTH, INVOICE_YEAR));
		for (final ClientAccount account : accounts) {
			final Invoice invoice = new Invoice(account, INVOICE_MONTH, INVOICE_YEAR);
			invoices.add(invoice);
			for (final TimeCard currentTimeCard : timeCardList) {
				invoice.extractLineItems(currentTimeCard);
			}
		}
		return invoices;
	}

	/**
	 * This method prints the invoice to a PrintStream.
	 * @param invoices the invoices to print
	 * @param out the output stream; can be System.out or a text file.
	 */
	private static void printInvoices(final List<Invoice> invoices, final PrintStream out) {
		for (final Invoice invoice : invoices) {
			out.println(invoice.toReportString());
		}
	}

	/**
	 * The application method. The files containing the timecards list and the client accounts list are
	 * both deserialized. After that, invoices using the data from the deserialized files are created and 
	 * printed
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public static void main(final String[] args) throws ClassNotFoundException, IOException {

		List<TimeCard> timeCards = null;
		List<ClientAccount> accounts = null;


		FileInputStream fileIn1 = new FileInputStream("TimeCards.ser");
		FileInputStream fileIn2 = new FileInputStream("ClientList.ser");
		ObjectInputStream objIn1 = new ObjectInputStream(fileIn1);
		ObjectInputStream objIn2 = new ObjectInputStream(fileIn2);
		try {
			timeCards = (List<TimeCard>) objIn1.readObject();
			accounts = (List<ClientAccount>) objIn2.readObject();
			objIn1.close();
			objIn2.close();
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		// Create invoices
		invoices = createInvoices(accounts, timeCards);
		// Print them
		System.out.println();
		System.out.println("==================================================================================");
		System.out.println("=============================== I N V O I C E S ==================================");
		System.out.println("==================================================================================");
		System.out.println();
		printInvoices(invoices, System.out);
	}
}
