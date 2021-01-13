import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;
// https://gist.github.com/0wlbear/8e0d24abe8fdd7133c96
public class VerifyLogin {

public static void main(String[] args) throws NumberFormatException, IOException {
int idx;
String us = "sharry009";
String ps = "password";
idx = verifyLoginUpdated2(us, ps, "CustomerInfoFile.txt");
System.out.println("The index is " + idx);
}
    
 public static int verifyLoginUpdated2(String username, String password, String filePath) throws NumberFormatException, IOException { 

     //String searchFor = username + "," + password;
     //System.out.println(searchFor);

    int index= 0;
    int count = 0;
    String info;
   // boolean works = false;
        try {
            BufferedReader fr;
            fr = new BufferedReader(new FileReader(filePath)); // CustomerInfo.txt is the file being read from
            while (((info = fr.readLine()) != null)) {
                // System.out.println(line);
              
             
              String[] custArray = info.split(",");
              
              System.out.println(custArray[0] + " " + custArray[1]); //Just to verify that file is being read
             
              System.out.println("----------------------------------");
              
              if (username.equalsIgnoreCase(custArray[0]) && password.equalsIgnoreCase(custArray[1]))
              {
                
                  index = count; // login successful index is found
                JOptionPane.showMessageDialog(null,"Login Successfull");
                fr.close();
                return index;
            
              } 

      
              count = count + 1;
              
             
            }
            
            fr.close();
        } catch (FileNotFoundException e) {
          JOptionPane.showMessageDialog(null,filePath + " is not Found"); // displays this message if file is not found.
          //System.exit(0);
        }catch (Exception e) {
      
        }
            
            return -1;
    }
}   
           