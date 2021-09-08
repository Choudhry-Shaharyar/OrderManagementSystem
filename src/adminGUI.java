import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

/**
 *Author: Shaharyar
 *Date: January 13, 2020
 *Description: This is the dealership menu where the cutsomer can look for cars and book appointments to get car services done. 
 */

public class adminGUI extends JPanel implements ActionListener {

	// Declaring private variables (class data)
	// creates custom colors
	private static final long serialVersionUID = 1L;          
	private Color blue = new Color (137, 207, 240);
	private Color White = new Color (245, 245, 245);
	private JTextArea title, customerInfo; // Creating Text Fields
	private Admin admin; // declaring admin object

  
	public adminGUI (int index) throws NumberFormatException, IOException {

		
		admin = new Admin(); // created a new customer 	
        	String record = Files.readAllLines(Paths.get("adminInfo.txt")).get(index);
		System.out.println(record);
		admin.AdminProcess(record);

		setBackground(blue);  //sets background to blue and uses no layout manager
		setLayout(null);
		title = new JTextArea("Welcome To SC Automotive " + admin.getUsername());
		title.setFont(new Font("Bernard MT Condensed", Font.ROMAN_BASELINE, 22)); 
		title.setBounds(200, 15, 600, 30);        //sets text field location
		title.setBackground(blue);              //sets colour to green
		title.setEditable(false);
		title.setForeground(White);              
		add(title);     
                     
        String info;
        String data = "";
        try {
            BufferedReader fr;
            fr = new BufferedReader(new FileReader("AccountOutputInfo.txt")); // CustomerInfo.txt is the file being read from
            while (((info = fr.readLine()) != null)) {
                data =  info +  "\n"  + data;
            }
		
            fr.close();
        } catch (Exception e) {
        }
		
        customerInfo = new JTextArea(data);
		customerInfo.setBorder(new LineBorder(Color.BLACK));
		customerInfo.setEditable(true);
		customerInfo.setFont(new Font("Sans-serif", Font.PLAIN, 12));    //sets button font
		JScrollPane jp = new JScrollPane(customerInfo, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jp.setBounds(4, 50, 700, 300);
		add(jp);                
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		JFrame testFrame = new JFrame("Admin Menu");                              //creates new frame
		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     //sets frame to exit on close
		// self testing
		testFrame.getContentPane().add(new adminGUI(2));              
		testFrame.setSize(730, 500);                                  //sets size location and visible to true
		testFrame.setLocation(350, 200);
		testFrame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
    }

}

