import java.awt.Font;
import java.awt.Graphics;
// import javax.swing.ImageIcon;
import javax.swing.JFrame;
// import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * @author Shaharyar Choudhry
 * Date: Oct 22, 2019
 * Description: Creates text and changes its font, position, size, title, and color.
 * Methods:
 * TextPicture() // initializes the xpos and ypos from picture class
 * TextPicture( String title, int x, int y) // declare title, x and y positions of the object to whatever the input says
 * setFont(Font f) // input font and methods adds it to the object
 * setTitle(String text) // inputs a strings and changes the previous title to the input
 * paint( Graphics  g) // overrides the paint from Picture class and paints the text, font, and string positions instead of shapes
 * 
 */
public class TextPicture extends Picture{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String text;
	private Font font;

	public TextPicture() {
		super(); // initailizes the xpos and ypos from picture class
		this.text = "hello";
		font = new Font("serif", Font.BOLD, 12);
		repaint();
	}
	public TextPicture( String title, int x, int y) {
		super();
		this.setxPos(x);
		this.setyPos(y);
		font = new Font("serif", Font.BOLD, 12);
		this.text = title;
		repaint();
	}

	public void setFont(Font f) {
		this.font = f;
		repaint();
	}

	public void setTitle(String text) {

		this.text= text;
		repaint();
	}
	// override the paint from Picture
	public void paint( Graphics  g) {

		g.setColor(this.getC());
		g.setFont(this.font);
		g.drawString(this.text,this.getxPos(),this.getyPos());	
	}



	/**
	 * @param args
	 */
	public static void main(String[] args) {

		JFrame f = new JFrame("Testing Frame"); // name of the frame
		f.setSize(300,300); //setting size of the frame to 300,300
		TextPicture d = new TextPicture("hello",250,150);	   

		f.add(d); // adds text picture to the frame
		f.setVisible(true);

		JOptionPane.showMessageDialog(null, "wait");  // setting new information after message "wait" is displayed
		d.setTitle("hello#2"); // setting title to "helllo#2"
		d.setC(54,110,113); // changing the color using (r, g, b)
		d.setxPos(54); // changing x position of object d
		d.setyPos(12); // changing y position of object d
		Font g = new Font("Arial", Font.PLAIN, 22); // adding font information to variable g
		d.setFont(g); // setting objects font to whatever is in Font g

		JOptionPane.showMessageDialog(null, "Wait"); // pause and then sets different values for testing

		d.setTitle("hello#3");
		d.setC(23,100,200);
		g = new Font("TimesRoman", Font.PLAIN, 42);
		d.setFont(g);
		d.setxPos(150);
		d.setyPos(120);

		JOptionPane.showMessageDialog(null, "Wait");

		d.setTitle("test#4");
		d.setC(93,44,2);
		g = new Font("Courier", Font.ITALIC, 17);
		d.setFont(g);
		d.setxPos(2);
		d.setyPos(200);

		JOptionPane.showMessageDialog(null, "Wait");
		g = new Font("Arial", Font.BOLD, 44);
		d.setFont(g);
		d.setC(200,55,55);
		d.setyPos(50);

	}

}
