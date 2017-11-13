package ovning2;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MinKomponent2 extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String kod;
	private JTextField visaKod;
	
	public MinKomponent2(){
		super();
		
		//	this.setLayout(new GridLayout(2,1));
		this.setLayout(new BorderLayout());
		kod="";
		JPanel topp = new JPanel();
		topp.setLayout(new GridLayout(4,3));
		String knapptext="123456789*0#";

		for(int i =0;i<knapptext.length();i++){
		    JButton enKnapp = new JButton(knapptext.substring(i,i+1));
		    topp.add(enKnapp);
		    enKnapp.addActionListener(this);
		}
		
		this.add(topp);
		visaKod=new JTextField();
		visaKod.setEditable(false);
		this.add(visaKod,BorderLayout.SOUTH);
		
	}
	
	public String geKod(){
		return kod;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String instruktion= e.getActionCommand();
		if (instruktion.equals("*")){
			kod="";
		    }
		else if (instruktion.equals("#")){
		    String tmp="";
		    for (int i = 0; i < kod.length();i++){
			tmp+=kod.charAt(kod.length()-(i+1));
		    }
		    kod=tmp;
		}
		else{
		    kod+=instruktion;
		}
		visaKod.setText(kod);
	}
	
	 public static void main(String[] args){
			JFrame fonster = new JFrame();
			MinKomponent2 panel = new MinKomponent2();
			fonster.add(panel);
			fonster.setSize(220,150);
			fonster.setVisible(true);

			fonster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 }
}
