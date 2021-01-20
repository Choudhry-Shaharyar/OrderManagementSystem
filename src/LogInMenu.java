import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 *Author: Shaharyar Choudhry
 *Date: Jan 13, 2020
 *Description: GUI where the user can login. Either a customer or admin can log in.
 *Reads from files to confirm password and username of admin or customer. After Entering login information
 *program opens up the dealership where the user can get a car and book a service. Admin can display information of cars and customer files.
 */

/*
 * Method List: 
 * public static int verifyLoginUpdated(String username, String key, String pathfile) // Method that has an int id and string key as an input and verify if they are in the file and are corresponding to each other. User also inputs the files needed to read from.
 * public static int linearSearch(String array[], String searchKey) // has an array and key as input. returns index. Searches what is inputted.
 */

public class LogInMenu extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	// declaring private variables and objects (Encapsulation/Bundling Data)
	private	Color black = new Color(45, 41, 38);           
	private	Color White = new Color (245, 245, 245);		
	private	Color Green = new Color (0, 164, 0);				
	private JTextField adminPin, adminUsername, customerPassword, customerUsername;  
	private JButton adminLogin, customerLogin, createNewAcc, createNewAcc2;     
	private int index;
	private int index2;
        int size;
	private JLabel admLogin, cusLogin;
	private	BufferedReader fr;
	public LogInMenu() throws NumberFormatException, IOException {

		setLayout(null); // setting layout to null
		//creates buttons 
		adminLogin = new JButton("Login");              
		customerLogin = new JButton("Login");
		createNewAcc = new JButton("Create New Account");
		createNewAcc2 = new JButton("Create New Account");

		adminLogin.setBounds(33, 220, 180, 30);              // sets position
		adminLogin.setFont(new Font("Sans-serif", Font.BOLD, 12)); // sets font
		adminLogin.setBackground(Color.blue); // sets color
		adminLogin.setForeground(White);  
		adminLogin.setBorderPainted(true);
		add(adminLogin); // adding text field

		customerLogin.setBounds(310, 220, 180, 30);       
		customerLogin.setFont(new Font("Sans-serif", Font.BOLD, 12));    
		customerLogin.setBackground(Color.BLUE);                               
		customerLogin.setForeground(White);                             
		customerLogin.setBorderPainted(true);                          
		add(customerLogin);                                              

		createNewAcc.setBounds(310, 260, 180, 30);              // sets position
		createNewAcc.setFont(new Font("Sans-serif", Font.BOLD, 12)); // sets font
		createNewAcc.setBackground(Green); // sets color
		createNewAcc.setForeground(White);  
		createNewAcc.setBorderPainted(true);
		add(createNewAcc); // adding text field

		createNewAcc2.setBounds(33, 260, 180, 30);              // sets position
		createNewAcc2.setFont(new Font("Sans-serif", Font.BOLD, 12)); // sets font
		createNewAcc2.setBackground(Green); // sets color
		createNewAcc2.setForeground(White);  
		createNewAcc2.setBorderPainted(true);
		add(createNewAcc2); // adding text field

		// creating and adding text fields
		adminPin = new JTextField("Enter pin");     
		adminPin.setEditable(true);
		adminPin.setBounds(33, 170, 180, 35);        
		adminPin.setBackground(White);             
		adminPin.setForeground(black);              
		add(adminPin);                              

		adminUsername = new JTextField("Enter username");     
		adminUsername.setEditable(true);
		adminUsername.setBounds(33, 130, 180, 35);        
		adminUsername.setBackground(White);          
		adminUsername.setForeground(black);            
		add(adminUsername);                             

                customerPassword = new JTextField("Enter password");     
		customerPassword.setEditable(true);
		customerPassword.setBounds(310, 170, 180, 35);      
		customerPassword.setBackground(White);            
		customerPassword.setForeground(black);              
		add(customerPassword);                            

		customerUsername = new JTextField("Enter Username");     
		customerUsername.setEditable(true);
		customerUsername.setBounds(310, 130, 180, 35);    
		customerUsername.setBackground(White);              
		customerUsername.setForeground(black);              
		add(customerUsername);                              

		// desiging and adding buttons
		admLogin = new JLabel("Admin Login");
		admLogin.setFont(new Font("Serif", Font.CENTER_BASELINE, 20));
		admLogin.setForeground(White); 
		admLogin.setBounds(35,100, 400, 20);

		cusLogin = new JLabel("Customer Login");
		cusLogin.setFont(new Font("Serif", Font.CENTER_BASELINE, 20));
		cusLogin.setBounds(315,100, 400, 20);
		cusLogin.setForeground(White); 

		add(cusLogin);
		add(admLogin);

      		customerLogin.addActionListener(this);                      
		adminLogin.addActionListener(this); 
		customerPassword.addActionListener(this);
		customerUsername.addActionListener(this);
		createNewAcc.addActionListener(this);
		createNewAcc2.addActionListener(this);
		adminPin.addActionListener(this);
		adminUsername.addActionListener(this);

		// setting background
		ImagePicture background = new ImagePicture(new ImageIcon("SCdealership.png"));
		background.setSize(500, 700);
		background.setBounds(-125,0,900,600);
		add(background); // adds picture to frame
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		JFrame testFrame = new JFrame("SC Dealership.Inc");           //creates new frame and adds PhraseUI panel
		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     //sets frame to exit on close
		testFrame.getContentPane().add(new LogInMenu());              //adds new panel
		testFrame.setSize(540, 500);                                  //sets size location and visible to true
		testFrame.setLocation(350, 200);
		testFrame.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent evt) {
		if (evt.getSource() == customerLogin) { // if user clicks cutsomerLogin

			// Declaring and intializing username and pin
			String password = customerPassword.getText(); // stores typed text into password variable
			String username = customerUsername.getText();  // stores typed text into username variable

			try {  // using files for customers
				// new method
				index = VerifyLogin.verifyLoginUpdated2(username, password, "CustomerInfoFile.txt");
				
			} 
			catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			if(index < 0) { // if the index is negative it means the password or username is wrong
				customerPassword.setText("Try Again");
				customerUsername.setText("Try Again");
			}

			else if (index >= 0){ // if index is equal to or greater than 0 it means the password and username are correct

				JOptionPane.showMessageDialog(null, "Going to Menu GUI....");

				JFrame testFrame = new JFrame("Customer Menu");       
				testFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

				try {
					new DealershipCustomerMenu(index);
					testFrame.add(new DealershipCustomerMenu(index)); 
					// calling the DealerShipCustumerGUI class so the user can pick a car or book a service
				} catch (NumberFormatException | IOException e1) {                      
					e1.printStackTrace();
				}             
				testFrame.setSize(540, 500);    //sets size, location, and visible to true
				testFrame.setLocation(350, 200);
				testFrame.setVisible(true);
			}
		}

	    else if (evt.getSource() == adminLogin) {

			String username = adminUsername.getText();  // Declaring and initializing username and pin to what the user has entered in the JTextFields
			String pin = adminPin.getText(); 

			try { // calling verifyLoginUpdated method to see if the username and pin entered is correct and exists
				index2 = VerifyLogin.verifyLoginUpdated2(username, pin, "AdminInfo.txt");
               		        System.out.println(index2);
			} 
			catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}


			if(index2 < 0) { //  entered info is wrong

				adminPin.setText("Try Again");
				adminUsername.setText("Try Again");
			}

			else if (index2 >= 0) { // entered info is right

				
				JOptionPane.showMessageDialog(null, "Going to Admin GUI....");

				JFrame testFrame = new JFrame("Admin Menu");        
				testFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);     //sets frame to exit on close
				try {
					new adminGUI(index2);
					testFrame.add(new adminGUI(index2)); // calling the DealerShipCustumerGUI class so the user can pick a car or book a service
					
				} catch (NumberFormatException e1) {											
					e1.printStackTrace();

				} catch (IOException e) {
					e.printStackTrace();
				
				}
				testFrame.setSize(725, 500);    //sets size, location, and visible to true
				testFrame.setLocation(350, 200);
				testFrame.setVisible(true);
			}
			
		}

		else if (evt.getSource() == createNewAcc){

			JOptionPane.showMessageDialog(null, "Going to OpenAccount GUI....");

				JFrame testFrame = new JFrame("Create a New Account");        
				testFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);     //sets frame to exit on close
				try {
					new OpenAccountGUI();
					testFrame.add(new OpenAccountGUI()); // calling the DealerShipCustumerGUI class so the user can pick a car or book a service
				} catch (NumberFormatException | IOException e1) { 
					e1.printStackTrace();
				}             
				testFrame.setSize(540, 500);    //sets size, location, and visible to true
				testFrame.setLocation(350, 200);
				testFrame.setVisible(true);
		} 
		else if (evt.getSource() == createNewAcc2){

			JOptionPane.showMessageDialog(null, "Going to OpenAdminAcc GUI....");

			JFrame testFrame = new JFrame("Create a New Account");        
			testFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);     //sets frame to exit on close
			try {
				new OpenAccountGUI();
				testFrame.add(new NewAdminAcc()); // calling the DealerShipCustumerGUI class so the user can pick a car or book a service
			} catch (NumberFormatException | IOException e1) {  
	
				e1.printStackTrace();

			}             
			testFrame.setSize(550, 500);    //sets size, location, and visible to true
			testFrame.setLocation(350, 200);
	  		testFrame.setVisible(true);
		}
	}
}



