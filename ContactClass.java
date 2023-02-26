package main;

public class ContactClass {
	private String id;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	
	
	public ContactClass(String id, String firstName, String lastName, String phoneNumber, String address) {
		if(id == null || id.length()>10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		if(firstName == null || firstName.length()>10) {
			throw new IllegalArgumentException("Invalid name");
		}
		if(lastName == null || lastName.length()>10) {
			throw new IllegalArgumentException("Invalid name");
		}
		if(phoneNumber == null || phoneNumber.length()!=10) {
			throw new IllegalArgumentException("Invalid phone number");
		}
		if(address == null || address.length()>30) {
			throw new IllegalArgumentException("Invalid address");
		}
		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	
	public String getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getAddress() {
		return address;
	}

	// setter methods for use by ContactService
		// no set methods for the contactId because it should not be updated
		public void setFirstName(String firstName) {
			if (firstName == null || firstName.length() > 10) {
				throw new IllegalArgumentException("Ivalid First Name");
			}
			this.firstName = firstName;
		}
		public void setLastName(String lastName) {
			if (lastName == null || lastName.length() > 10) {
				throw new IllegalArgumentException("Invalid Last Name");
			}
			this.lastName = lastName;
		}
		public void setPhoneNumber(String newPhone) {
			if (newPhone == null || newPhone.length() != 10) {
				throw new IllegalArgumentException("Inavlid Phone Number");
			}
			this.phoneNumber = newPhone;
		}
		public void setAddress(String newAddress) {
			if (newAddress == null || newAddress.length() > 30) {
				throw new IllegalArgumentException("Invalid Address");
			}
			this.address = newAddress;
		}
	
	
}