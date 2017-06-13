package cp125;
import com.scg.domain.*;
import com.scg.util.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.*;

public class Test {

	/**
	 * Tests for Name class
	 */
	
	@org.junit.Test
	public void canCreateNewNameTwoArgs() {
		Name n = new Name("Ln", "Fn");
		Assert.assertEquals("Ln", n.getLastName());
		Assert.assertEquals("Fn", n.getFirstName());
	}
	
	@org.junit.Test 
	public void canCreateNewNameThreeArgs() {
		Name n = new Name("Ln", "Fn", "Mn");
		Assert.assertEquals("Ln", n.getLastName());
		Assert.assertEquals("Fn", n.getFirstName());
		Assert.assertEquals("Mn", n.getMiddleName());
	}
	
	@org.junit.Test
	public void canGetFirstName() {
		Name n = new Name("Ln", "Fn");
		Assert.assertEquals("Fn", n.getFirstName());
	}
	
	@org.junit.Test
	public void canSetFirstName() {
		Name n = new Name("Ln", "Fn");
		n.setFirstName("Fn1");
		Assert.assertEquals("Fn1", n.getFirstName());
	}
	
	@org.junit.Test
	public void canGetLastName() {
		Name n = new Name("Ln", "Fn");
		Assert.assertEquals("Ln", n.getLastName());
	}
	
	@org.junit.Test
	public void canSetLastName() {
		Name n = new Name("Ln", "Fn");
		n.setLastName("Ln1");
		Assert.assertEquals("Ln1", n.getLastName());
	}
	
	@org.junit.Test
	public void canGetMiddleName() {
		Name n = new Name("Ln", "Fn", "Mn");
		Assert.assertEquals("Mn", n.getMiddleName());
	}
	
	@org.junit.Test
	public void canSetMiddleName() {
		Name n = new Name("Ln", "Fn", "Mn");
		n.setMiddleName("Mn1");
		Assert.assertEquals("Mn1", n.getMiddleName());
	}
	
	@org.junit.Test 
	public void canGetHashCode() {
		Name n = new Name("Ln", "Fn", "Mn");
		Assert.assertEquals(n.hashCode(), n.hashCode());
	}
	
	@org.junit.Test 
	public void canCompareNameObjectsUsingEqualsMethod() {
		Name n = new Name("Ln", "Fn", "Mn");
		Name o = new Name("Ln", "Fn", "Mn");
		Boolean areTheyEqual = n.equals(o);
		Assert.assertEquals(false, areTheyEqual);
	}
		
	
	/**
	 * Tests for ClientAccount class
	 */

	@org.junit.Test
	public void canCreateNewClientAccount() {
		Name n = new Name("Ln", "Fn");
		Address a = new Address("123 Sesame Street", "Seattle", StateCode.WA, "98101");	
		ClientAccount ca = new ClientAccount("someName", n, a);
		Assert.assertEquals("someName", ca.getName());
		Assert.assertEquals("Fn", ca.getContact().getFirstName());
		Assert.assertEquals("Ln", ca.getContact().getLastName());
		Assert.assertEquals(a.toString(), ca.getAddress().toString());
	}
	
	
	@org.junit.Test
	public void canGetNameForClientAccount() {
		Name n = new Name("Ln", "Fn");
		Address a = new Address("123 Sesame Street", "Seattle", StateCode.WA, "98101");	
		ClientAccount ca = new ClientAccount("someName", n, a);
		Assert.assertEquals("someName", ca.getName());
	}
	
	@org.junit.Test
	public void canGetContactForClientAccount() {
		Name n = new Name("Ln", "Fn");
		Address a = new Address("123 Sesame Street", "Seattle", StateCode.WA, "98101");	
		ClientAccount ca = new ClientAccount("someName", n, a);
		Assert.assertEquals("Fn", ca.getContact().getFirstName());
		Assert.assertEquals("Ln", ca.getContact().getLastName());
	}
	
	@org.junit.Test
	public void canSetContactForClientAccount() {
		Name n = new Name("Ln", "Fn");
		Name o = new Name("Ln1", "Fn1");
		Address a = new Address("123 Sesame Street", "Seattle", StateCode.WA, "98101");	
		ClientAccount ca = new ClientAccount("someName", n, a);
		ca.setContact(o);
		Assert.assertEquals("Fn1", ca.getContact().getFirstName());
		Assert.assertEquals("Ln1", ca.getContact().getLastName());
	}
	
	@org.junit.Test
	public void canGetCorrectValueOfIsBillableForClientAccount() {
		Name n = new Name("Ln", "Fn");
		Address a = new Address("123 Sesame Street", "Seattle", StateCode.WA, "98101");	
		ClientAccount ca = new ClientAccount("someName", n, a);
		Assert.assertEquals(true, ca.isBillable());
	}
	
	@org.junit.Test 
	public void canSetAndGetAddressForClientAccount() {
		Name n = new Name("Ln", "Fn");
		Address a = new Address("123 Sesame Street", "Seattle", StateCode.WA, "98101");	
		Address b = new Address("456 SomeOther Street", "Los Angeles", StateCode.CA, "90001");
		ClientAccount ca = new ClientAccount("someName", n, a);
		ca.setAddress(b);
		Assert.assertEquals(b.toString(), ca.getAddress().toString());
	}
	
	/**
	 * Tests for Consultant class
	 */
	
	@org.junit.Test 
	public void canCreateNewConsultant() {
		Name n = new Name("Ln", "Fn");
		Consultant c = new Consultant(n);
		Assert.assertEquals("Fn", c.getName().getFirstName());
		Assert.assertEquals("Ln", c.getName().getLastName());
	}
	
	@org.junit.Test 
	public void canGetConsultantName() {
		Name n = new Name("Ln", "Fn");
		Consultant c = new Consultant(n);
		Assert.assertEquals("Fn", c.getName().getFirstName());
		Assert.assertEquals("Ln", c.getName().getLastName());
	}
	
	/**
	 * Tests for ConsultantTime class
	 */
	
	@org.junit.Test 
	public void canCreateNewConsultantTime() {
		java.time.LocalDate date = LocalDate.now();
		Name n = new Name("Ln", "Fn");
		Consultant c = new Consultant(n);
		Address a = new Address("123 Sesame Street", "Seattle", StateCode.WA, "98101");	
		ClientAccount ca = new ClientAccount("cca", n, a);
		ConsultantTime ct = new ConsultantTime(date, ca, Skill.PROJECT_MANAGER, 1);
		Assert.assertEquals(LocalDate.now(), ct.getDate());
		Assert.assertEquals(ca, ct.getAccount());
		Assert.assertEquals(Skill.PROJECT_MANAGER, ct.getSkill());
		Assert.assertEquals(1, ct.getHours());
	}
	
	@org.junit.Test 
	public void canGetDateForConsultantTime() {
		java.time.LocalDate date = LocalDate.now();
		Name n = new Name("Ln", "Fn");
		Consultant c = new Consultant(n);
		Address a = new Address("123 Sesame Street", "Seattle", StateCode.WA, "98101");	
		ClientAccount ca = new ClientAccount("cca", n, a);
		ConsultantTime ct = new ConsultantTime(date, ca, Skill.PROJECT_MANAGER, 1);
		Assert.assertEquals(date, ct.getDate());
	}
	
	@org.junit.Test 
	public void canSetDateForConsultantTime() {
		java.time.LocalDate date = LocalDate.now();
		java.time.LocalDate date1 = LocalDate.of(2002, 05, 01);
		Name n = new Name("Ln", "Fn");
		Consultant c = new Consultant(n);
		Address a = new Address("123 Sesame Street", "Seattle", StateCode.WA, "98101");	
		ClientAccount ca = new ClientAccount("cca", n, a);
		ConsultantTime ct = new ConsultantTime(date, ca, Skill.PROJECT_MANAGER, 1);
		ct.setDate(date1);
		Assert.assertEquals(date1, ct.getDate());
	}
	
	@org.junit.Test 
	public void canGetAccountForConsultantTime() {
		java.time.LocalDate date = LocalDate.now();
		Name n = new Name("Ln", "Fn");
		Consultant c = new Consultant(n);
		Address a = new Address("123 Sesame Street", "Seattle", StateCode.WA, "98101");	
		ClientAccount ca = new ClientAccount("cca", n, a);
		ConsultantTime ct = new ConsultantTime(date, ca, Skill.PROJECT_MANAGER, 1);
		Assert.assertEquals(ca, ct.getAccount());
	}
	
	@org.junit.Test 
	public void canSetAccountForConsultantTime() {
		java.time.LocalDate date = LocalDate.now();
		Name n = new Name("Ln", "Fn");
		Consultant c = new Consultant(n);
		Address a = new Address("123 Sesame Street", "Seattle", StateCode.WA, "98101");	
		ClientAccount ca = new ClientAccount("cca", n, a);
		ClientAccount ca1 = new ClientAccount("cca1", n, a);
		ConsultantTime ct = new ConsultantTime(date, ca, Skill.PROJECT_MANAGER, 1);
		ct.setAccount(ca1);
		Assert.assertEquals(ca1, ct.getAccount());
	}
	
	@org.junit.Test
	public void consultantTimeIsBillable() {
		java.time.LocalDate date = LocalDate.now();
		Name n = new Name("Ln", "Fn");
		Address a = new Address("123 Sesame Street", "Seattle", StateCode.WA, "98101");	
		ClientAccount ca = new ClientAccount("cca", n, a);
		ConsultantTime ct = new ConsultantTime(date, ca, Skill.PROJECT_MANAGER, 1);
		Assert.assertEquals(true, ct.isBillable());
	}
	
	@org.junit.Test
	public void consultantTimeIsNotBillable() {
		java.time.LocalDate date = LocalDate.now();
		Name n = new Name("Ln", "Fn");
		ConsultantTime ct = new ConsultantTime(date, NonBillableAccount.SICK_LEAVE, Skill.PROJECT_MANAGER, 1);
		Assert.assertEquals(false, ct.isBillable());
	}
	
	@org.junit.Test
	public void canGetHoursForConsultantTime() {
		java.time.LocalDate date = LocalDate.now();
		Name n = new Name("Ln", "Fn");
		Consultant c = new Consultant(n);
		ConsultantTime ct = new ConsultantTime(date, NonBillableAccount.SICK_LEAVE, Skill.PROJECT_MANAGER, 1);
		Assert.assertEquals(1, ct.getHours());
	}
	
	@org.junit.Test 
	public void canSetHoursForConsultantTime() {
		java.time.LocalDate date = LocalDate.now();
		Name n = new Name("Ln", "Fn");
		Consultant c = new Consultant(n);
		ConsultantTime ct = new ConsultantTime(date, NonBillableAccount.SICK_LEAVE, Skill.PROJECT_MANAGER, 1);
		ct.setHours(2);
		Assert.assertEquals(2, ct.getHours());
	}
	
	@org.junit.Test 
	public void canGetSkillForConsultantTime() {
		java.time.LocalDate date = LocalDate.now();
		Name n = new Name("Ln", "Fn");
		Consultant c = new Consultant(n);
		ConsultantTime ct = new ConsultantTime(date, NonBillableAccount.SICK_LEAVE, Skill.PROJECT_MANAGER, 1);
		Assert.assertEquals(Skill.PROJECT_MANAGER, ct.getSkill());
	}
	
	/**
	 * Tests for TimeCard class
	 */
	
	@org.junit.Test 
	public void canCreateNewTimeCard() {
		java.time.LocalDate date = LocalDate.now();
		Name n = new Name("Ln", "Fn");
		Consultant c = new Consultant(n);
		TimeCard tc = new TimeCard(c, date);
		Assert.assertEquals(c, tc.getConsultant());
		Assert.assertEquals(date, tc.getWeekStartingDay());
	}
	
	@org.junit.Test 
	public void canGetConsultantForTimeCard() {
		java.time.LocalDate date = LocalDate.now();
		Name n = new Name("Ln", "Fn");
		Consultant c = new Consultant(n);
		TimeCard tc = new TimeCard(c, date);
		Assert.assertEquals(c, tc.getConsultant());
	}
	
	@org.junit.Test 
	public void canAddConsultantTimeToTimeCard() {
		java.time.LocalDate date = LocalDate.now();
		Name n = new Name("Ln", "Fn");
		Address a = new Address("123 Sesame Street", "Seattle", StateCode.WA, "98101");	
		ClientAccount ca = new ClientAccount("cca", n, a);
		Consultant c = new Consultant(n);
		ConsultantTime ct = new ConsultantTime(date, ca, Skill.PROJECT_MANAGER, 1);
		TimeCard tc = new TimeCard(c, date);
		tc.addConsultantTime(ct);
		Assert.assertEquals(1, tc.getConsultingHours().size());
	}
	
	@org.junit.Test 
	public void canAddNonBillableTimeToTimeCard() {
		java.time.LocalDate date = LocalDate.now();
		Name n = new Name("Ln", "Fn");
		Consultant c = new Consultant(n);
		ConsultantTime ct = new ConsultantTime(date, NonBillableAccount.SICK_LEAVE, Skill.PROJECT_MANAGER, 1);
		TimeCard tc = new TimeCard(c, date);
		tc.addConsultantTime(ct);
		Assert.assertEquals(false, ct.isBillable());
		Assert.assertEquals(1, tc.getTotalNonBillableHours());
	}
	
	@org.junit.Test 
	public void canAddBillableTimeToTimeCard() {
		java.time.LocalDate date = LocalDate.now();
		Name n = new Name("Ln", "Fn");
		Address a = new Address("123 Sesame Street", "Seattle", StateCode.WA, "98101");	
		ClientAccount ca = new ClientAccount("cca", n, a);
		Consultant c = new Consultant(n);
		ConsultantTime ct = new ConsultantTime(date, ca, Skill.PROJECT_MANAGER, 1);
		TimeCard tc = new TimeCard(c, date);
		tc.addConsultantTime(ct);
		Assert.assertEquals(true, ct.isBillable());
		Assert.assertEquals(1, tc.getTotalBillableHours());
		Assert.assertEquals("cca", ct.getAccount().getName().toString());
	}
	
	@org.junit.Test 
	public void canGetTotalNonBillableTimeOnTimeCard() {
		java.time.LocalDate date = LocalDate.now();
		Name n = new Name("Ln", "Fn");
		Consultant c = new Consultant(n);
		ConsultantTime ct = new ConsultantTime(date, NonBillableAccount.SICK_LEAVE, Skill.PROJECT_MANAGER, 1);
		TimeCard tc = new TimeCard(c, date);
		tc.addConsultantTime(ct);
		Assert.assertEquals(1, tc.getTotalNonBillableHours());
	}
	
	@org.junit.Test 
	public void canGetTotalBillableHoursOnTimeCard() {
		java.time.LocalDate date = LocalDate.now();
		Name n = new Name("Ln", "Fn");
		Address a = new Address("123 Sesame Street", "Seattle", StateCode.WA, "98101");	
		ClientAccount ca = new ClientAccount("cca", n, a);
		Consultant c = new Consultant(n);
		ConsultantTime ct = new ConsultantTime(date, ca, Skill.PROJECT_MANAGER, 1);
		TimeCard tc = new TimeCard(c, date);
		tc.addConsultantTime(ct);
		Assert.assertEquals(1, tc.getTotalBillableHours());
	}
	
	@org.junit.Test 
	public void canGetTotalHoursOnTimeCard() {
		java.time.LocalDate date = LocalDate.now();
		Name n = new Name("Ln", "Fn");
		Address a = new Address("123 Sesame Street", "Seattle", StateCode.WA, "98101");	
		ClientAccount ca = new ClientAccount("cca", n, a);
		Consultant c = new Consultant(n);
		ConsultantTime ct = new ConsultantTime(date, ca, Skill.PROJECT_MANAGER, 1);
		ConsultantTime ct1 = new ConsultantTime(date, NonBillableAccount.SICK_LEAVE, Skill.PROJECT_MANAGER, 1);
		TimeCard tc = new TimeCard(c, date);
		tc.addConsultantTime(ct);
		tc.addConsultantTime(ct1);
		Assert.assertEquals(2, tc.getTotalHours());
	}
	
	@org.junit.Test 
	public void canGetConsultingHoursOnTimeCard() {
		java.time.LocalDate date = LocalDate.now();
		Name n = new Name("Ln", "Fn");
		Address a = new Address("123 Sesame Street", "Seattle", StateCode.WA, "98101");	
		ClientAccount ca = new ClientAccount("cca", n, a);
		Consultant c = new Consultant(n);
		ConsultantTime ct = new ConsultantTime(date, ca, Skill.PROJECT_MANAGER, 1);
		TimeCard tc = new TimeCard(c, date);
		tc.addConsultantTime(ct);
		Assert.assertEquals(1, tc.getConsultingHours().size());
	}
	
	@org.junit.Test 
	public void canAddBillableHoursForClient() {
		java.time.LocalDate date = LocalDate.now();
		Name n = new Name("Ln", "Fn");
		Address a = new Address("123 Sesame Street", "Seattle", StateCode.WA, "98101");	
		ClientAccount ca = new ClientAccount("cca", n, a);
		Consultant c = new Consultant(n);
		ConsultantTime ct = new ConsultantTime(date, ca, Skill.PROJECT_MANAGER, 1);
		ConsultantTime ct1 = new ConsultantTime(date, NonBillableAccount.SICK_LEAVE, Skill.PROJECT_MANAGER, 1);
		TimeCard tc = new TimeCard(c, date);
		tc.addConsultantTime(ct);
		tc.addConsultantTime(ct1);
		Assert.assertEquals(1, tc.getBillableHoursForClient("cca").size());
	}
	
	@org.junit.Test 
	public void canGetBillableHoursForClient() {
		java.time.LocalDate date = LocalDate.now();
		Name n = new Name("Ln", "Fn");
		Address a = new Address("123 Sesame Street", "Seattle", StateCode.WA, "98101");	
		ClientAccount ca = new ClientAccount("cca", n, a);
		ClientAccount ca1 = new ClientAccount("cca1", n, a);
		Consultant c = new Consultant(n);
		ConsultantTime ct = new ConsultantTime(date, ca, Skill.PROJECT_MANAGER, 1);
		ConsultantTime ct1 = new ConsultantTime(date, NonBillableAccount.SICK_LEAVE, Skill.PROJECT_MANAGER, 1);
		ConsultantTime ct2 = new ConsultantTime(date, ca1, Skill.SOFTWARE_ENGINEER, 1);
		TimeCard tc = new TimeCard(c, date);
		tc.addConsultantTime(ct);
		tc.addConsultantTime(ct1);
		tc.addConsultantTime(ct2);
		tc.getBillableHoursForClient("cca");
		Assert.assertEquals(2, tc.getTotalBillableHours());
	}
	
	@org.junit.Test 
	public void canGetWeekStartingDayOnTimeCard() {
		java.time.LocalDate date = LocalDate.now();
		Name n = new Name("Ln", "Fn");
		Address a = new Address("123 Sesame Street", "Seattle", StateCode.WA, "98101");	
		ClientAccount ca = new ClientAccount("cca", n, a);
		Consultant c = new Consultant(n);
		ConsultantTime ct = new ConsultantTime(date, ca, Skill.PROJECT_MANAGER, 1);
		TimeCard tc = new TimeCard(c, date);
		tc.addConsultantTime(ct);
		Assert.assertEquals(date, tc.getWeekStartingDay());
	}
	
	/**
	 * Tests for Skill enum
	 */
	
	@org.junit.Test 
	public void canSetSkill() {
		java.time.LocalDate date = LocalDate.now();
		Name n = new Name("Ln", "Fn");
		Address a = new Address("123 Sesame Street", "Seattle", StateCode.WA, "98101");	
		ClientAccount ca = new ClientAccount("cca", n, a);
		ConsultantTime ct = new ConsultantTime(date, ca, Skill.PROJECT_MANAGER, 1);
		Assert.assertEquals("Project Manager", ct.getSkill().toString());
	}
	
	/**
	 * Tests for NonBillableAccount enum
	 */
	
	@org.junit.Test 
	public void canSetNonBillableAccount() {
		java.time.LocalDate date = LocalDate.now();
		Name n = new Name("Ln", "Fn");
		ConsultantTime ct = new ConsultantTime(date, NonBillableAccount.SICK_LEAVE, Skill.PROJECT_MANAGER, 1);
		Assert.assertEquals("Sick Leave", ct.getAccount().toString());
	}
	
	/**
	 * Tests for the Address class
	 */
	
	@org.junit.Test 
	public void canCreateNewAddressAndGetEachAddressObjectProperty() {
		Address a = new Address("123 Sesame Street", "Seattle", StateCode.WA, "98101");
		Assert.assertEquals("123 Sesame Street", a.getStreetNumber());
		Assert.assertEquals("Seattle", a.getCity());
		Assert.assertEquals(StateCode.WA, a.getState());
		Assert.assertEquals("98101", a.getPostalCode());
	}
	
	/**
	 * Tests for the InvoiceLineItem class
	 */
	
	@org.junit.Test 
	public void canCreateNewInvoiceLineItem() {
		java.time.LocalDate date = LocalDate.now();
		Name n = new Name("Ln", "Fn");
		Consultant c = new Consultant(n);
		InvoiceLineItem ilt = new InvoiceLineItem(date, c, Skill.PROJECT_MANAGER, 1);
		Assert.assertEquals(Skill.PROJECT_MANAGER, ilt.getSkill());
		Assert.assertEquals(1, ilt.getHours());
		Assert.assertEquals(c.getName(), ilt.getConsultant().getName());
	}
	
	@org.junit.Test
	public void canGetInvoiceLineItemConsultant() {
		java.time.LocalDate date = LocalDate.now();
		Name n = new Name("Ln", "Fn");
		Consultant c = new Consultant(n);
		InvoiceLineItem ilt = new InvoiceLineItem(date, c, Skill.PROJECT_MANAGER, 1);
		Assert.assertEquals(c.getName(), ilt.getConsultant().getName());
	}
	
	@org.junit.Test 
	public void canGetInvoiceLineItemSkill() {
		java.time.LocalDate date = LocalDate.now();
		Name n = new Name("Ln", "Fn");
		Consultant c = new Consultant(n);
		InvoiceLineItem ilt = new InvoiceLineItem(date, c, Skill.PROJECT_MANAGER, 1);
		Assert.assertEquals(Skill.PROJECT_MANAGER, ilt.getSkill());
	}
	
	@org.junit.Test 
	public void canGetInvoiceLineItemHours() {
		java.time.LocalDate date = LocalDate.now();
		Name n = new Name("Ln", "Fn");
		Consultant c = new Consultant(n);
		InvoiceLineItem ilt = new InvoiceLineItem(date, c, Skill.PROJECT_MANAGER, 1);
		Assert.assertEquals(1, ilt.getHours());
	}
	
	@org.junit.Test 
	public void canGetInvoiceLineItemCharge() {
		java.time.LocalDate date = LocalDate.now();
		Name n = new Name("Ln", "Fn");
		Consultant c = new Consultant(n);
		InvoiceLineItem ilt = new InvoiceLineItem(date, c, Skill.PROJECT_MANAGER, 2);
		Assert.assertEquals(500, ilt.getCharge());
	}
	
	
	/**
	 * Tests for Invoice class
	 */
	@org.junit.Test 
	public void canCreateNewInvoice() {
		Name n = new Name("Ln", "Fn");
		Address a = new Address("123 Sesame Street", "Seattle", StateCode.WA, "98101");	
		ClientAccount ca = new ClientAccount("cca", n, a);
		Invoice i = new Invoice(ca, java.time.Month.APRIL, 2000);
		Assert.assertEquals(ca.toString(), i.getClientAccount().toString());
		Assert.assertEquals(java.time.Month.APRIL, i.getInvoiceMonth());
	}
	
	@org.junit.Test 
	public void canGetStartDateForInvoice() {
		Name n = new Name("Ln", "Fn");
		Address a = new Address("123 Sesame Street", "Seattle", StateCode.WA, "98101");	
		ClientAccount ca = new ClientAccount("cca", n, a);
		Invoice i = new Invoice(ca, java.time.Month.APRIL, 2000);
		Assert.assertEquals(java.time.Month.APRIL, i.getInvoiceMonth());
	}
	
	@org.junit.Test 
	public void canGetInvoiceMonth() {
		Name n = new Name("Ln", "Fn");
		Address a = new Address("123 Sesame Street", "Seattle", StateCode.WA, "98101");	
		ClientAccount ca = new ClientAccount("cca", n, a);
		Invoice i = new Invoice(ca, java.time.Month.APRIL, 2000);
		Assert.assertEquals(java.time.Month.APRIL, i.getInvoiceMonth());
	}
	
	@org.junit.Test 
	public void canGetInvoiceClientAccount() {
		Name n = new Name("Ln", "Fn");
		Address a = new Address("123 Sesame Street", "Seattle", StateCode.WA, "98101");	
		ClientAccount ca = new ClientAccount("cca", n, a);
		Invoice i = new Invoice(ca, java.time.Month.APRIL, 2000);
		Assert.assertEquals(ca.toString(), i.getClientAccount().toString());
	}
	
	@org.junit.Test 
	public void canAddLineItemsToInvoice() {
		java.time.LocalDate date = LocalDate.of(2000, 4, 3);
		Name n = new Name("Ln", "Fn");
		Address a = new Address("123 Sesame Street", "Seattle", StateCode.WA, "98101");	
		ClientAccount ca = new ClientAccount("cca", n, a);
		Consultant c = new Consultant(n);
		ConsultantTime ct = new ConsultantTime(date, ca, Skill.PROJECT_MANAGER, 8);
		ConsultantTime ct2 = new ConsultantTime(date, NonBillableAccount.SICK_LEAVE, Skill.PROJECT_MANAGER, 2);
		InvoiceLineItem ilt = new InvoiceLineItem(date, c, Skill.PROJECT_MANAGER, 16);
		TimeCard tc = new TimeCard(c, date);
		Invoice i = new Invoice(ca, java.time.Month.APRIL, 2000);
		tc.addConsultantTime(ct);
		tc.addConsultantTime(ct2);
		i.extractLineItems(tc);
		Assert.assertEquals(1, i.getLineItemCount());
	}
	
	/**
	 * Tests for StateCode enum
	 */
	@org.junit.Test
	public void canSetStateCodeWA() {
		Address a = new Address("123 Sesame Street", "Seattle", StateCode.WA, "98101");	
		Assert.assertEquals(StateCode.WA, a.getState());
	}
	
	@org.junit.Test
	public void canSetStateCodeCA() {
		Address a = new Address("123 Sesame Street", "Los Angeles", StateCode.CA, "98101");	
		Assert.assertEquals(StateCode.CA, a.getState());
	}
	
}
