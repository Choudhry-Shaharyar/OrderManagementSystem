/**
 * Author: Shaharyar Choudhry
 * Date: January 12, 2019
 * Description: Customer class that is used to create customer objects. Contains firstName, LastName, emailAddress, address, password, username and phone number as attributes,
 */
/*
 * Method List:
 * public Customer() // default constructor, creates a cutsomer object with intialized attributes
 * public void customerProcess(String record) // assigns attributes with values inputed by the user through splitting an array
 * public String getFirstName() // Getter and setter methods
 * public String getLastName() 
 * public String getAddress() 
 * public integer getPhone() 
 * public String getEmailAdd()
 * public void setUpdatedFirstName(String firstName) // Setters
 * public void setUpdatedLastName(String lastName)
 * public void setEmailAdd(String email)
 * public void setUpdatedAddress(String address)
 * public void setUpdatedPhone(long phone)
 * public String toString() // toString Method: Diplays all the attributes of the object as a String
 * public static void main(String[] args) // self testing main method
 */

public class Customer extends Admin{ // Inheritance
	// class data
	private String firstName, lastName;
	private String address, emailAdd; 	// declaring private variables firstName, LastName, Address, etc.
	private long phone;		
	//	private Car car;

  //private Customer a;
	/**
	 * Default Constructor:
	 * Initialize attributes 
	 */
	public Customer() {
		super();
		this.firstName = "Sharry";
		this.lastName = "Mehmi";  		//Setting computer given variables 
		this.address = "6 Dawes R";
		this.phone = 647939823;
		this.emailAdd = "shaharyar@hotmail.ca";
	}


	// assigns attributes with values inputted by the user through spliting an array
	public void customerProcess(String record) {
		String customerInfo[];
		customerInfo = record.split(",");
		this.setUsername(customerInfo[0]);
		this.setPassword(customerInfo[1]);
		this.firstName = customerInfo[2];
		this.lastName = customerInfo[3];
		this.address = customerInfo[4];
		this.emailAdd = customerInfo[5];
		this.phone  = Long.parseLong(customerInfo[6]);

	}
	
	// Getters and setters

	public void setUpdatedFirstName(String firstName) {
		this.firstName = firstName;

	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setUpdatedLastName(String lastName) {
		this.lastName = lastName;

	}

	public String getLastName() {
		return this.lastName;
	}

	public String getEmailAdd() {
		return emailAdd;
	}

	public void setEmailAdd(String email) {
		emailAdd = email;
	}


	public void setUpdatedAddress(String address) {
		this.address = address;

	}

	public String getAddress() {
		return this.address;
	}


	public void setUpdatedPhone(long phone) {
		this.phone = phone;
	}

	public long getPhone() {
		return this.phone;
	}



	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", emailAdd="
				+ emailAdd + ", phone=" + phone + ", Username=" + getUsername() + ", Password="
				+ getPassword() + "]";
	}


	/**
	 * Main Method: Self-Testing main method 
	 */
	public static void main(String[] args)  {

		Customer a = new Customer(); // created a new customer 
		System.out.println( a.toString());

		// Testing Getters and Setters

		Customer customerA = new Customer(); // created a new customer 
		System.out.println("Name: " + customerA.getFirstName());
		System.out.println("Last Name: " + customerA.getLastName());
		System.out.println("Address: " + customerA.getAddress());
		System.out.println("Phone Number: " + customerA.getPhone());

		System.out.println("Email: " + customerA.getEmailAdd());

		System.out.println("Main Constructor Data: " + customerA.toString() + "\n");

		Customer b = new Customer();
		b.setUpdatedAddress("34 Dawes Rd");
		b.setUpdatedFirstName("John");
		b.setUpdatedLastName("Cranberry");
		b.setUpdatedPhone(23232);		

		System.out.println(b.getFirstName());
		System.out.println(b.getLastName());
		System.out.println(b.getAddress());
		System.out.println(b.getPhone());


		// Testing of the overloaded constructor giving it a string of customer data
		String customerInformation = "Zora009,password, Zora,Mehmi,6 Dawes Rd, 592819@pdsb.net,9056668888";

		Customer c = new Customer();
		c.customerProcess(customerInformation);

		System.out.println(c.toString());

		// Testing the overload constructor as-well with applying changes to existing customer
		String customerInfo = "Sharry009,password,Shaharyar,Choudhry,6 Dawes Rd, 592819@pdsb.net,9054787777";
		Customer d = new Customer();
		d.customerProcess(customerInfo);

		d.setUpdatedAddress("43 Dawes Rd");
		d.setUpdatedPhone(9056767743L);

		System.out.println(d.toString());
		d.setUsername("nick009");
		System.out.println(d.getUsername());


	}




}

