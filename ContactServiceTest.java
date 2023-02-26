package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import main.ContactClass;
import main.ContactService;

class ContactServiceTest {

	//create a contact and test values
	// this creates contacts with a unique ID using the ContactService addContact method
	@Test
	void testContactServiceClass() {
		ContactService.addContact("James", "Smith", "6618886118", 
				"123 Fake St. Encino, CA 91158");
		//System.out.println(ContactService.contactList.get(0).getId());	used for debugging
		assertTrue(ContactService.contactList.get(0).getId().equals("1000000002"));
		assertTrue(ContactService.contactList.get(0).getFirstName().equals("James"));
		assertTrue(ContactService.contactList.get(0).getLastName().equals("Smith"));
		assertTrue(ContactService.contactList.get(0).getPhoneNumber().equals("6618886118"));
		assertTrue(ContactService.contactList.get(0).getAddress().equals("123 Fake St. Encino, CA 91158"));
	}
	// confirm deletion of a contact
	@Test
	void testContactServiceDelete() {
		ContactService.addContact("James", "Smith", "6618886118", 
				"123 Fake St. Encino, CA 91158");
		int size = ContactService.contactList.size();
		//System.out.println(ContactService.contactList.get(size - 1).getId());
		ContactService.deleteContact("1000000003");
		//ContactService.searchContact("1000000003");
		//System.out.println(ContactService.contactList.get(1).getId());
		assertTrue(ContactService.searchContact("1000000003") == 2);
	}
	// update first name test
	@Test
	void testContactServiceUpdateFirstName() {
		ContactService.addContact("Jack", "Skellingto", "6618886118", "Halloween Ave.");
		int size = ContactService.contactList.size();
		System.out.println(ContactService.contactList.get(size - 1).getId());
		System.out.println(ContactService.contactList.get(size - 1).getFirstName());
		ContactService.updateFirstName("1000000003", "Mary");
		System.out.println(ContactService.contactList.get(size - 1).getFirstName());
		assertTrue(ContactService.contactList.get(size - 1).getFirstName().equals("Mary"));
	}
	// using 1000000003 to test the rest
	// test confirming update to last name
	@Test
	void testContactServiceUpdateLastName() {
		int size = ContactService.contactList.size();
		ContactService.updateLastName("1000000003", "Poppins");
		assertTrue(ContactService.contactList.get(size - 1).getLastName().equals("Poppins"));
	}
	// test confirming update to phone number
	@Test
	void testContactServiceUpdatePhone() {
		int target = 0;
		target = ContactService.findIndex("1000000003");
		ContactService.updatePhoneNum("1000000003", "8884446161");
		assertTrue(ContactService.contactList.get(target).getPhoneNumber().equals("8884446161"));
	}
	// test confirming update to address
	@Test
	void testContactServiceUpdateAddress() {
		int target = 0;
		target = ContactService.findIndex("1000000003");
		ContactService.updateAddress("1000000003", "456 Fake St. Acton, CA 91542");
		assertTrue(ContactService.contactList.get(target).getAddress().equals("456 Fake St. Acton, CA 91542"));
	}

	@Test
	void testContactService() {
		ContactClass contactClass = new ContactClass("12345", "Adam", "Benoit", "1234567890", "9 Washington Street");
		assertTrue(contactClass.getId().equals("12345"));
		assertTrue(contactClass.getFirstName().equals("Adam"));
		assertTrue(contactClass.getLastName().equals("Benoit"));
		assertTrue(contactClass.getPhoneNumber().equals("1234567890"));
		assertTrue(contactClass.getAddress().equals("9 Washington Street"));

	}
}