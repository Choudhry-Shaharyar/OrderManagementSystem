/**
 * Author: Shaharyar Choudhry
 * Date: January 15, 2019
 * Description: Car class that is used to create car objects. Has price, make, model, and year as attributes
 */

/*
 * Method List:
 * public Car() // default constructor and initalizes variables
 * public Car (String make, String model, int year, int price) // overloaded constructor: Must input String make, String model, int year, int price
 * public void carProcess(String record) // assigns attributes with values inputted by the user through spliting an array
 * Getters and Setters:
 * public String getMake()
 * public void setMake(String make)
 * public String getModel()
 * public void setModel(String model)
 * public int getPrice()
 * public void setPrice(int price)
 * public int getYear()
 * public void setYear(int year)
 * public String toString() // toString Method: Diplays all the attributes of the object as a String
 * public static void main(String[] args) // self testing main method
 */

public class Car {

	// Declaring private variables (class data)
	private String make, model;
	private int price, year;

	/**
	 * Defualt constructor that initalizes attributes
	 */
	public Car() {
		this.price = 50000;
		this.make = "BMW";
		this.model = "M6";
		this.year = 2019;

	}

	// Overloaded constructor
	public Car (String make, String model, int year, int price) {
		this.price = price;
		this.make = make;
		this.model = model;
		this.year = year;

	}

	// assigns attributes with values inputted by the user through spliting an array
	public void carProcess(String record) {
		String carInfo[];
		carInfo = record.split(",");
		this.price = Integer.parseInt(carInfo[0]);
		this.make = carInfo[1];
		this.model = carInfo[2];
		this.year = Integer.parseInt(carInfo[3]);

	}

	// Getter and setter methods

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}



	// toString: converts info to a string
	@Override
	public String toString() {
		return "Car [make=" + make + ", model=" + model + ", price=" + price + ", year=" + year + "]";
	}

	/**
	 * Self testing main Method
	 */
	public static void main(String[] args) {
		Car c = new Car(); // declaring and creating a car object

		// Tetsing getters, setters, and toString method
		System.out.println(c.toString());
		System.out.println(c.getMake());
		System.out.println(c.getModel());
		System.out.println(c.getPrice());
		System.out.println(c.getYear());
		c.setMake("Mdoel x");
		System.out.println(c.getMake());

		// Testing of the overloaded constructor giving it a string of car data
		String carInfo = "80000,BMW,M8,2020";
		c.carProcess(carInfo);
		System.out.println(c.toString());
	}

}
