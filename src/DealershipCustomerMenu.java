import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 *Author: Shaharyar
 *Date: January 13, 2020
 *Description: This is the dealership menu where the cutsomer can look for cars and book appointments to get car services done. 
 */
/*
 *Method List: 
 */
public class DealershipCustomerMenu extends JPanel implements ActionListener {

	// Declaring private variables (class data)
	//creates custom colors

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Color black = new Color(45, 41, 38);          
	private Color blue = new Color (137, 207, 240);
	private Color White = new Color (245, 245, 245);
	private JTextArea title,sign, customerInfo; // Creating Text Fields
	private JButton carSelect, bookService, displayCustomerInfo; // Creating Jbuttons
	private Customer c; // declaring Customer and CustomerAccount objects arrays
	//private CustomerAccount ca[];
	private Car ca;
	private JTextField make, model,year,price; 
     
  
	public DealershipCustomerMenu (int index) throws NumberFormatException, IOException {
		
			c = new Customer(); // created a new customer 
			ca = new Car();
			//record[] = new String[size];
            String record = Files.readAllLines(Paths.get("customerInfoFile.txt")).get(index);
			System.out.println(record);
			c.customerProcess(record);

		setBackground(blue);  //sets background to blue and uses no layout manager
		setLayout(null);
		title = new JTextArea("Welcome To SC Automotive " + c.getFirstName());
		title.setFont(new Font("Bernard MT Condensed", Font.ROMAN_BASELINE, 22)); 
		title.setBounds(145, 15, 600, 30);        //sets text field location
		title.setBackground(blue);              //sets colour to green
		title.setEditable(false);
		title.setForeground(White);              
		add(title);     
					 
		sign = new JTextArea("Car Details:");
		sign.setFont(new Font("Bernard MT Condensed", Font.ROMAN_BASELINE, 22)); 
		sign.setBounds(10, 50, 150, 30);        //sets text field location
		sign.setBackground(blue);              //sets colour to green
		sign.setEditable(false);
		sign.setForeground(White);              
		add(sign);     
	                         
		customerInfo = new JTextArea("Customer Information: \n" +
				"First name: " + c.getFirstName() + "\n" +
				"Last name: " + c.getLastName() + "\n" +
				"Adress: " + c.getAddress() + "\n" +
				"Email Adress: " + c.getEmailAdd() + "\n" +
				"Phone number: " + c.getPhone() + "\n" +
				"Username: " + c.getUsername());

		//creates buttons
		carSelect = new JButton("Select Car");              
		bookService = new JButton("Book a Service");
		displayCustomerInfo = new JButton("Display Info");

		//adds and customizes exit button
		carSelect.setBounds(30, 400, 200, 30);                        
		carSelect.setFont(new Font("Sans-serif", Font.BOLD, 12));
		carSelect.setBackground(White);
		carSelect.setForeground(black);
		carSelect.setBorderPainted(true);
		add(carSelect);

		bookService.setBounds(300, 400, 200, 30);                      //sets button location
		bookService.setFont(new Font("Sans-serif", Font.BOLD, 12));    //sets button font
		bookService.setBackground(White);                              //sets button color
		bookService.setForeground(black);                              //sets button text color
		bookService.setBorderPainted(true);                           
		add(bookService);                                              

		displayCustomerInfo.setBounds(10, 10, 120, 30);        
		displayCustomerInfo.setFont(new Font("Sans-serif", Font.BOLD, 12));    
		displayCustomerInfo.setBackground(White);                             
		displayCustomerInfo.setForeground(black);                            
		displayCustomerInfo.setBorderPainted(true);                           
		add(displayCustomerInfo);                                              

		customerInfo.setBorder(new LineBorder(Color.BLACK));
		customerInfo.setEditable(true);
		customerInfo.setFont(new Font("Sans-serif", Font.PLAIN, 12));    //sets button font
		JScrollPane jp = new JScrollPane(customerInfo, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jp.setBounds(320, 48, 200, 200);
		add(jp);                

		make = new JTextField("Enter Make");     
		make.setEditable(true);
		make.setBounds(10, 85, 180, 35);      
		make.setBackground(White);            
		make.setForeground(black);              
		add(make);                 

		model = new JTextField("Enter Model");     
		model.setEditable(true);
		model.setBounds(10, 125, 180, 35);      
		model.setBackground(White);            
		model.setForeground(black);              
		add(model);                 

		year = new JTextField("Enter Year");     
		year.setEditable(true);
		year.setBounds(10, 165, 180, 35);      
		year.setBackground(White);            
		year.setForeground(black);              
		add(year);                 

		price = new JTextField("Enter price");     
		price.setEditable(true);
		price.setBounds(10, 205, 180, 35);      
		price.setBackground(White);            
		price.setForeground(black);              
		add(price);                 

		//makes the program listen to button actions
		bookService.addActionListener(this);
		carSelect.addActionListener(this);
		displayCustomerInfo.addActionListener(this);
		make.addActionListener(this);
		year.addActionListener(this);
		model.addActionListener(this);
		price.addActionListener(this);

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		JFrame testFrame = new JFrame();                              //creates new frame
		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     //sets frame to exit on close
     	// self testing
		testFrame.getContentPane().add(new DealershipCustomerMenu(2));              
		testFrame.setSize(540, 500);                                  //sets size location and visible to true
		testFrame.setLocation(350, 200);
		testFrame.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent evt) {

		if (evt.getSource() == carSelect) {
			// creates a car object for the car that has been selected.
			//	Car c2 = new Car(Make.getText(),Model.getText(),Year.getText(),Price.getText());
			//	Car c = new Car();
			// add the car selcted to the acount object
			ca.setMake(make.getText());
			ca.setModel(model.getText());
			ca.setYear(Integer.parseInt(year.getText()));
			ca.setPrice(Integer.parseInt(price.getText()));

			customerInfo.append("\n" +
			        "Order Information:" + "\n" +
					"Car Make: " + ca.getMake() + "\n" +
					"Car Model: " + ca.getModel() + "\n" +
					"Car Year: " + ca.getYear() + "\n" +
					"Car Price: " + "$" + ca.getPrice());
			customerInfo.update(customerInfo.getGraphics());

			try {
			
				//file reader get first line. and add the new line
				FileWriter fw = new FileWriter("AccountOutputInfo.txt", true);
                PrintWriter output = new PrintWriter(fw);
			
				output.println(c.getFirstName() + " "+  c.getLastName() + " has ordered a " + ca.getYear() + " " +ca.getMake() +" "+ca.getModel() + " (Price: $" + ca.getPrice() +") [Phone Number: " + c.getPhone() +"] " + "[Email:" + c.getEmailAdd() +"]");

				// close file
				output.close();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "AccountOutputInfo.txt not found");
			}
		
		}

		else if (evt.getSource() == bookService) {

			//  open GUI for services NOT copleted
		}
		else if (evt.getSource() == displayCustomerInfo) {
			JOptionPane.showMessageDialog(customerInfo, customerInfo);
		}

	}



}
