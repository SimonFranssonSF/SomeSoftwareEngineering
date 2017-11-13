package laboration1;
import java.applet.Applet;
import java.awt.Color;
import java.awt.GridLayout;

import laboration1.buttons.MyButton;


public class LabApplet extends Applet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void init () {
		//Creates some MyButtons with actionListeners on its own
		MyButton button1 = new MyButton(Color.green, Color.red, "ON", "OFF" );
		MyButton button2 = new MyButton(Color.blue, Color.yellow, "Blue", "Yellow" );
		MyButton button3 = new MyButton(Color.white, Color.black, "Day", "Night" );
		MyButton button4 = new MyButton(Color.orange, Color.cyan, "Orange", "Cyan" );
		MyButton button5 = new MyButton(Color.pink, Color.gray , "Run", "Walk" );
		MyButton button6 = new MyButton(Color.DARK_GRAY , Color.MAGENTA, "Color1", "Color2" );
		
		//Specifies GridLayout
		setLayout(new GridLayout(3,2,3,3));
		
		//Adds the MyButtons
		add(button1);
		add(button2);
		add(button3);
		add(button4);
		add(button5);
		add(button6);
    }
}
