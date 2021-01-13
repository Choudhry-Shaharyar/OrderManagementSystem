import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author Shaharyar Choudhry
 * Description: It represents Picture Objects (EXAMPLE OF POLYMORPHISM). Creates an eye and changes it features
 * Date: October 22, 2019
 * Methods:
 * Picture() // sets and initializes default values for picture
 * Picture(int x, int y, int w, int h)  // inputs position, height, and width and changes the pictures location
 * paint(Graphics g) // paint method is used to paint and print different shapes
 * setC(Color c) // type in color and changes the color of the object
 * setC (int r, int g, int b) // type in color using number and changes the objects color
 * setxPos(int xPos) // sets x position of the object
 * setyPos(int yPos) // sets y position of the object
 * setMyWidth(int myWidth) // sets width of the object
 * setMyHeight(int myHeight) // sets height of the object
 */
public class Picture extends JComponent {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Private Instance data
	 */

	// declare attributes and color
	private Color c;
	private int xPos, yPos, myWidth, myHeight;

	/**
	 * The Default Constructor
	 */
	public Picture() {
		// Initialize data for a basic picture
		this.c = Color.RED;
		this.xPos = 0;
		this.yPos = 0;
		this.myWidth = 50;
		this.myHeight = 25;
		repaint();
	}

	// overloaded constructor to specify position and size
	public Picture(int x, int y, int w, int h) {
		this.c = Color.RED;
		this.xPos = x;
		this.yPos = y;
		this.myWidth = w;
		this.myHeight = h;
		repaint();
	}



	// paint method
	public void paint(Graphics g) {
		g.setColor(this.c);
		g.drawRect(this.xPos, this.yPos, this.myWidth, this.myHeight);
		g.drawOval(this.xPos, this.yPos, this.myWidth, this.myHeight);
		g.fillOval (this.xPos + ((this.myWidth / 8)* 3), this.yPos, this.myWidth/4, this.myHeight);
	}

	// getters and setters
	public Color getC() {
		return c;

	}
	// setter for color
	public void setC(Color c) {
		this.c = c;
		repaint();
	}
	// overloaded setC
	public void setC (int r, int g, int b) {
		this.c = new Color(r, g, b);
		repaint();
	}

	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
		repaint();
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
		repaint();
	}

	public int getMyWidth() {
		return myWidth;
	}

	public void setMyWidth(int myWidth) {
		this.myWidth = myWidth;
		repaint();
	}

	public int getMyHeight() {
		return myHeight;
	}

	public void setMyHeight(int myHeight) {
		this.myHeight = myHeight;
		repaint();
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {

		JFrame f = new JFrame("Testing Frame");

		// create picture object
		Picture p = new Picture(); // this will call instructor

		f.setSize(400, 350); // sets size of frame
		f.add(p); // add my object/picture to the frame
		f.setVisible(true);

		// create a picture at a specified position and size
		Picture p1 = new Picture(30,80,200,60); // setting size
		f.add(p1);
		f.setVisible(true);

		JOptionPane.showMessageDialog(null, "Wait");

		p.setC(Color.blue); // changing color to blue
		p.repaint();

		JOptionPane.showMessageDialog(null, "Wait");

		p.setxPos(250);
		p.repaint();

		JOptionPane.showMessageDialog(null, "Wait");
		int y = p1.getyPos();
		y = y * 2;  // changing y position of the picture
		p1.setyPos(y);


		JOptionPane.showMessageDialog(null, "Wait");
		p1.setMyHeight(30); // changing height of p1
		p1.setC(245,156, 255); // changing color


		JOptionPane.showMessageDialog(null, "hello");
		p1.setMyWidth(100);
		p1.setC(22,156, 255);

		JOptionPane.showMessageDialog(null, "changing X pos");
		p1.setxPos(300);

	}


}
