import javax.swing.JOptionPane;

/**
 * Author: Shaharyar Choudhry
 * Date: January 12, 2019
 * Description: CustomerAccount class that is used to create CustomerAccount objects. Uses a car and customer object to make an CustomerCustomerAccount object
 */
/*
Method list:
public CustomerCustomerAccount () // Default constructor
public CustomerCustomerAccount (Customer buyer, Car car) // Overloaded Constructor: user inputs a customer and car object 
public String toString() // toString Method: Diplays all the attributes of the object as a String
public Car getCar() // getters and setters
public void setCar(Car car)
public Customer getBuyer()
public void setBuyer(Customer buyer)
public static void main (String args[]) // self testing main method
 */

public class CustomerAccount extends Customer { // extends it to get the getters and setters (a[index].getUsername() ??

	// Encapsulation Examples (class data)
	// declaring private variables (objects) 
	private Car car;
	private Customer buyer;
	
	// Default Constructor
	public CustomerAccount() {
		super();

		this.car= null;
		this.buyer = null;
	}
///////////////////////////////////////// idk how to work this// might not need his class then
	// overloaded Constructor
	// Initializing attributes
	public CustomerAccount(Customer buyers, Car cars) {
		super();
		
		  this.car=cars;
		  this.buyer=buyers;
		 
		/*
		this.car.setMake(cars.getMake());
		this.car.setModel(cars.getModel());
		this.car.setPrice(cars.getPrice());
		this.car.setYear(cars.getYear());

		this.buyer.setEmailAdd(buyers.getEmailAdd());
		this.buyer.setUpdatedAddress(buyers.getAddress());
		this.buyer.setUpdatedFirstName(buyers.getFirstName());
		this.buyer.setUpdatedLastName(buyers.getLastName());
		this.buyer.setUpdatedPhone(buyers.getPhone());
		this.buyer.setPassword(buyers.getPassword());
		this.buyer.setUsername(buyers.getUsername());
*/
	}

	// getters and setters
	public Car getCar() { 
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Customer getBuyer() {
		return buyer;
	}


	public void setBuyer(Customer buyer) {
		this.buyer = buyer;
	}


	@Override
	public String toString() {
		return "CustomerAccount [Car=" + getCar() + ", FirstName=" + getFirstName() + ", LastName="
				+ getLastName() + ", EmailAdd=" + getEmailAdd() + ", Address=" + getAddress()
				+ ", Phone=" + getPhone() + ", Username=" + getUsername() + ", Password=" + getPassword()
				+ "]";
	}

	/**
	 * self testing main method
	 */
	public static void main(String[] args) { 


		String customerInfo = "Sharry009,password,Shaharyar,Choudhry,6 Dawes Rd, 592819@pdsb.net,9054787777";

		Customer c = new Customer(); // creating a customer object
		c.customerProcess(customerInfo);

		Car car = new Car("Honda","Civic",50000, 2019); // creating a car object
		Car car2 = new Car("Tesla","Model X",50000, 2019); // creating a car object
		CustomerAccount acc = new CustomerAccount(c,  car); // creating CustomerAccount object song th eoverloaded constructor.

		JOptionPane.showMessageDialog(null,acc.getLastName());
		// testing getters, setters, and the toString Method
		System.out.println(car.getMake());
		System.out.println(acc.getBuyer());
		acc.setCar(car2);
		acc.setEmailAdd("bils@Gamil.ca");
		acc.setCar(car);
		System.out.println(acc.getEmailAdd());
		System.out.println(acc.toString());
		JOptionPane.showMessageDialog(null,acc.toString());

	}



}
