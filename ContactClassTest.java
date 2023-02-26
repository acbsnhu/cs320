package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import main.ContactClass;

class ContactClassTest {

	@Test
	void testContactClass() {
		ContactClass contactClass = new ContactClass("12345", "Adam", "Benoit", "1234567890", "9 Washington Street");
		assertTrue(contactClass.getId().equals("12345"));
		assertTrue(contactClass.getFirstName().equals("Adam"));
		assertTrue(contactClass.getLastName().equals("Benoit"));
		assertTrue(contactClass.getPhoneNumber().equals("1234567890"));
		assertTrue(contactClass.getAddress().equals("9 Washington Street"));

	}
	
	@Test
	void testContactClassIdToLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new ContactClass("12345678900", "Adam", "Benoit", "1234567890", "9 Washington Street");
		});
	}
	
	@Test
	void testContactClassIdIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new ContactClass(null, "Adam", "Benoit", "1234567890", "9 Washington Street");
		});
	}

	@Test
	void testContactClassFirstNameToLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new ContactClass("12345", "AdamAdamAdam", "Benoit", "1234567890", "9 Washington Street");
		});
	}
	
	@Test
	void testContactClassFirstNameIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new ContactClass("12345", null, "Benoit", "1234567890", "9 Washington Street");
		});
	}
	
	@Test
	void testContactClassLastNameToLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new ContactClass("12345", "Adam", "BenoitBenoitBenoit", "1234567890", "9 Washington Street");
		});
	}
	
	@Test
	void testContactClassLastNameIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new ContactClass("12345", "Adam", null, "1234567890", "9 Washington Street");
		});
	}
	
	@Test
	void testContactClassPhoneNumberNotTenDig() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new ContactClass("12345", "Adam", "Benoit", "1", "9 Washington Street");
		});
	}
	
	@Test
	void testContactClassPhoneNumberIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new ContactClass("12345", "Adam", "Benoit", null, "9 Washington Street");
		});
	}
	
	@Test
	void testContactClassAddressToLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new ContactClass("12345", "Adam", "Benoit", "1234567890", "9 Washington Street 9 Washington Street 9 Washington Street");
		});
	}
	
	@Test
	void testContactClassAddressIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new ContactClass("12345", "Adam", "Benoit", "1234567890", null);
		});
	}
	
}
