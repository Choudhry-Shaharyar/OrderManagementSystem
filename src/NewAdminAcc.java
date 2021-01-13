import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



    public class NewAdminAcc extends JPanel implements ActionListener {

        /**
         *
         */
        private static final long serialVersionUID = 1L;
        // declaring private variables and objects (Encapsulation/Bundling Data)
        private	Color black = new Color(45, 41, 38);           
        private	Color White = new Color (245, 245, 245);		
        private	Color Green = new Color (0, 164, 0);				
        private JTextField username, password;
        private JButton signUp;
        int size;
        public NewAdminAcc() throws NumberFormatException, IOException {
       
            setLayout(null); // setting layout to null
    
    
            username = new JTextField("Enter username");     
            username.setEditable(true);
            username.setBounds(180, 100, 180, 35);        
            username.setBackground(White);             
            username.setForeground(black);              
            add(username);                              
    
            password = new JTextField("Enter password");     
            password.setEditable(true);
            password.setBounds(180, 140, 180, 35);        
            password.setBackground(White);          
            password.setForeground(black);            
            add(password);                             
    
    
    
            // desiging and adding buttons
            //create button
            signUp = new JButton("Sign Up");              
    
            signUp.setBounds(180, 200, 180, 30);      
            // sets position
            signUp.setFont(new Font("Sans-serif", Font.BOLD,  12)); // sets font
            signUp.setBackground(Green); // sets color
            signUp.setForeground(White);  
            signUp.setBorderPainted(true);
            add(signUp); // adding text field
            add(signUp);
                    
            //makes the program listen to button actions
    
            signUp.addActionListener(this);                 
            username.addActionListener(this); 
            password.addActionListener(this);
        
            
            ImagePicture background = new ImagePicture(new ImageIcon("SCdealership.png")); // setting background
            background.setSize(500, 700);
            background.setBounds(-125,0,900,600);
            add(background); // adds picture to frame
    
    
        }
    
    
        public static void main(String[] args) throws NumberFormatException, IOException {
    
    
            JFrame testFrame = new JFrame("SC Dealership.INC");                              //creates new frame and adds PhraseUI panel
            testFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);     //sets frame to exit on close
            testFrame.getContentPane().add(new NewAdminAcc());               //adds new panel
            testFrame.setSize(540, 500);                                  //sets size location and visible to true
            testFrame.setLocation(400, 200);
            testFrame.setVisible(true);
        }
    
    
        @Override
        public void actionPerformed(ActionEvent evt) {
            if (evt.getSource() == signUp) {
         
                try {

                   String confirm = JOptionPane.showInputDialog(null, "To confirm your account enter Y" + "\n" + "To decline enter any other key");

                   if(confirm.equalsIgnoreCase("y") == true){

                    //file reader get first line. and add the new line
                    FileWriter fw = new FileWriter("AdminInfo.txt", true);
                    PrintWriter output = new PrintWriter(fw);
                

                    output.println(username.getText() + ","+ password.getText());
                    // close file
                    output.close();

                    JOptionPane.showMessageDialog(null,"Account Created");
                 
                }
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "AccountOutputInfo.txt not found");
                }
            
            }
    
        }
    
    
    
     
    }
    
    
    

