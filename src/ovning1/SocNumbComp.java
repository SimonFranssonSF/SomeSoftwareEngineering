package ovning1;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

// Uppgift 2
public class SocNumbComp extends JTextField implements ActionListener { 
    // SocNumbComp = Social Number Component
    // extends TextField = inherit and become a textfield
    // Implements ActionListener = Add the behaviour of an actionlistener

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SocNumbComp() {
	super("Social Security:");
	setVisible(true);
	addActionListener(this);
	setPreferredSize(new Dimension(200, 30));
    }

    public boolean checkSum(String social){
	int mul = 2;
	int sum = 0;
	for(int index = 0; index < social.length(); index++){
	    String d = social.substring(index, index + 1);
	    Integer dig = Integer.parseInt(d);
	    Integer sum_dig = mul * dig;
	    if(sum_dig < 10){ // One digit
	    	sum += sum_dig;
	    }else{ // Two digits --> "18" = 1 + 8 = 9
	    	String s = sum_dig.toString();
	    	int res = Integer.parseInt(s.substring(0, 1)) + Integer.parseInt(s.substring(1, 2));
	    	sum += res;
	    }
	    mul = 3 - mul; 	// 3 - 2 = 1
	    // 3 - 1 = 2
	}
	
	if((sum % 10) == 0){ 	// Sum = alternating 1 and 2 times ALL digits of Social Security
	    return true;
	}		// A correct Social Security has a sum as a multiple of 10. 
	return false;
    }
	
    public String modify(){
	String social = this.getText();
	String modified = "";
	if(social.length() == 11){
	    modified = social.substring(0, 6) + social.substring(7);
	}
	if(social.length() == 10){
	    modified = social;
	}
	return modified;
    }
    
    @Override
	public void actionPerformed(ActionEvent e) {
    	System.out.println("1");
	    String mod = modify();
	    boolean correct = checkSum(mod); 
	    if(correct && mod.length() == 10){
	    	System.out.println("2");
		this.setText(mod);
	    }
	    else{
	    	System.out.println("3");

		this.setText("Not correct social sec");}
    }
}