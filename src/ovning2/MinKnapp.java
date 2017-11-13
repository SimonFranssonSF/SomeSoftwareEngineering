package ovning2;

import javax.swing.ImageIcon;
import javax.swing.JButton;

class MinKnapp extends JButton{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static ImageIcon[] bilder ={null,new ImageIcon("src/resources/frog.gif"),new ImageIcon("src/resources/penguin.gif")} ;
    private int status;

    public MinKnapp(){
		super((ImageIcon)bilder[1]);
		setSize(50,50);
		status=1;
    }

    public void bytStatus(){
		setVisible(false);
		status=(status+1)%bilder.length;
		setIcon(bilder[status]);
		repaint();
		setVisible(true);
    }
	
}