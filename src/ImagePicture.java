import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author Shaharyar Choudhry
 * Date: Oct 24, 2019
 * Description: Draws Icons
 * Inherits from p
 * Methods:
 * ImagePicture(ImageIcon img) // inputs a image and sets its width and height and 
 * ImagePicture(ImageIcon img, int x, int y) // overloaded constructor to specify the location
 * paint( Graphics  g) // override the paint from Picture
 * 
 * 
 */
public class ImagePicture extends Picture {
	/*
	 * private data for ImagePicture
	 */

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon image;


	/**
	 * constructor for image only
	 */
	public ImagePicture(ImageIcon img) {
		super(); // calls Picture default constructor
		this.image = img;

		setMyWidth(img.getIconWidth()); // gets width and height by calling built in function from java
		setMyHeight(img.getIconHeight()); // getIconWidth and height are the methods built in from java
		repaint();
	}

	// overloaded constructor to specify the location
	public ImagePicture(ImageIcon img, int x, int y) {
		super(x, y, img.getIconWidth(), img.getIconHeight());
		this.image = img;
		repaint();
	}

	// override the paint from Picture
	public void paint( Graphics  g) {
		this.image.paintIcon(this,  g, getxPos(), getyPos());
	}

	/**
	 * @param args
	 * self-testing main 
	 */
	public static void main(String[] args) {
		// create a frame
		JFrame f = new JFrame();

		ImagePicture p = new ImagePicture(new ImageIcon("minion.png")); // creating minion picture

		f.setSize(400, 350);
		f.add(p); // adds picture to frame

		JOptionPane.showMessageDialog(null, "Wait"); 

		ImagePicture p1 = new ImagePicture(new ImageIcon("minion.png"), 100, 200); // changing position of minion
		f.add(p1);
		f.setVisible(true); // adds picture to srame and sets it visible

		JOptionPane.showMessageDialog(null, "Wait");

		p1.setyPos(20); // changing position of minion
		f.setVisible(true);;

	}

}
