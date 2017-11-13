package ovning2;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MinKomponent extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String kod;
	
	public MinKomponent(){
		super();
		this.setLayout(new GridLayout(4,3));
		kod = "";
		String knapptext = "123456789*0#";
		
		for (int i = 0; i < knapptext.length(); i++){
			JButton enKnapp = new JButton(knapptext.substring(i, i+1));
			this.add(enKnapp);
			enKnapp.addActionListener(this);
		}
	}
	
	public String geKod(){
		return kod;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String instruktion = e.getActionCommand();
		if(instruktion.equals("*")){
			kod = "";
		}else if(instruktion.equals("#")){
			System.out.println(kod);
		}else{
			kod += instruktion;
		}
	}
	
	public static void main(String[] args){
		JFrame frame = new JFrame("MinKomponent");
		MinKomponent komponent = new MinKomponent();
		
		frame.add(komponent);
		frame.setSize(200, 150);
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
