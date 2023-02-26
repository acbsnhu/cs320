package main;

import java.util.ArrayList;	// needed for arraylist to store data

public class ContactService {
	
	// needed variables for creating objects of Contact class
	public static String publicId;
	public String publicFirstName;
	public String publicLastName;
	public String publicPhoneNumber;
	public String publicAddress;
	
	// create a structure to store data of contacts
	public static ArrayList<ContactClass> contactList = new ArrayList<ContactClass>(0);
	
	// generate unique Id
	public static String generateUniqueId() {
		// placeholder string
		String uniqueId;
		// start with a 10-digit number if list is empty
		if (contactList.isEmpty()) {
			publicId = "1000000001";
		}
		//gets the latest value, therefore highest, in the arraylist if it is not empty
		else {
			int arraySize = contactList.size();
			publicId = contactList.get(arraySize - 1).getId();
		}
		// convert string to int for creation of next value
		int tempInt = Integer.valueOf(publicId);
		// add 1 to make next value unique
		tempInt += 1;
		// convert back to string to store
		uniqueId = Integer.toString(tempInt);
		return uniqueId;
	}
	
	// creation of a Contact object and adding it to the arraylist
	public static void addContact(String firstName, String lastName, String phoneNumber, String address) {
		String id = generateUniqueId();
		ContactClass Contact1 = new ContactClass(id, firstName, lastName, phoneNumber, address);
		contactList.add(Contact1);
	}
	// add a contact as a whole manually for testing 
	public static void addContact(ContactClass newContact) {
		String tempId = newContact.getId();
		for (int i = 0; i < contactList.size(); i++) {
			if (tempId.equals(contactList.get(i).getId())) {
				throw new IllegalArgumentException("Contact ID Must Be Unique");
			}
		}
		contactList.add(newContact);
	}
	
	// updater methods for fields that can be updated
	public static void updateFirstName(String uniqueId, String publicFirstName) {
		for (int i = 0; i < contactList.size(); i++) {
			if (uniqueId.compareTo(contactList.get(i).getId()) == 0) {
			contactList.get(i).setFirstName(publicFirstName);
			}
		}
	}
	public static void updateLastName(String uniqueId, String publicLastName) {
		for (int i = 0; i < contactList.size(); i++) {
			if (uniqueId.compareTo(contactList.get(i).getId()) == 0) {
			contactList.get(i).setLastName(publicLastName);
			}
		}
	}
	public static void updatePhoneNum(String uniqueId, String publicPhone) {
		for (int i = 0; i < contactList.size(); i++) {
			if (uniqueId.compareTo(contactList.get(i).getId()) == 0) {
			contactList.get(i).setPhoneNumber(publicPhone);
			}
		}
	}
	public static void updateAddress(String uniqueId, String publicAddress) {
		for (int i = 0; i < contactList.size(); i++) {
			if (uniqueId.compareTo(contactList.get(i).getId()) == 0) {
			contactList.get(i).setAddress(publicAddress);
			}
		}
	}
	// delete a contact from the list
	public static void deleteContact(String uniqueId) {
		for (int i = 0; i < contactList.size(); i++) {
			if (uniqueId.compareTo(contactList.get(i).getId()) == 0) {
				int position = i;
				// removes contact from list thereby deleting it since they are only
				// stored in the list
				contactList.remove(position);
			}
		}
	}
	// quick search function for testing
	public static int searchContact(String uniqueId) {
		int result = 0;
		for (int i = 0; i < contactList.size(); i++) {
			if (uniqueId.compareTo(contactList.get(i).getId()) == 0) {
				result = 1;
			}
			else {
				result = 2;
			}
		}
		return result;
	}
	// quick find index function
	public static int findIndex(String uniqueId) {
		int result = 0;
		for (int i = 0; i < contactList.size(); i++) {
			if (uniqueId.compareTo(contactList.get(i).getId()) == 0) {
				result = i;
			}
		}
		return result;
	}
		
}