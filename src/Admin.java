/**
 * Author: Shaharyar Choudhry
 * Date: January 8, 2019
 * Description: Admin class that is used to create admin objects. Has username and password as attributes
 */

/*
 * Method List:
 * public Admin() // default constructor and initalizes variables
 * public void AdminProcess(String record) // assigns attributes with values inputted by the user through spliting an array
 * Getters and Setters:
 * public String getKey()
 * public void setKey(String key)
 * public String toString() // toString Method: Diplays all the attributes of the object as a String
 * public static void main(String[] args) // self testing main method
 */


public class Admin{

	// class data
	// declaring private variables Username and password
	private String username;
	private String password;

	/**
	 * Main Constructor:
	 * Initalizing attributes
	 */
	public Admin() {
		this.username = "Sharry009";
		this.password = "password";
	}
	// assigns attributes with values inputted by the user through spliting an array
	public void AdminProcess(String record) {
		
		String adminInfo[];
		adminInfo = record.split(",");
		this.setUsername(adminInfo[0]);
		this.setPassword(adminInfo[1]);
	}
	// getters and setters

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Admin [USERNAME=" + getUsername() + ", PASSWORD=" + getPassword()
				+ "]";
	}


	/**
	 * Main Method: Self-Testing main method 
	 */
	public static void main(String[] args)  {

		Admin a = new Admin(); //Declared and created a new Admin object 
		System.out.println(a.toString()); // Tetsign toString Method

		Admin adm = new Admin(); // Declared and created a new Admin object 

		// Testign getters and setters
		System.out.println("Username: " + adm.getUsername());
		String newUsername = "Bill2020";
		adm.setUsername(newUsername);
		System.out.println("New Username: " + adm.getUsername());

		// Testing of the overloaded constructor giving it a string of admin data
		String adminInformation = "michael9898, passwor321";

		adm.AdminProcess(adminInformation); // Testing AdminProcess() method

		// Testing toString Method
		System.out.println(adm.toString());




	}


}

