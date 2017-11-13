package laboration3;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
class RPSSkel extends JFrame implements ActionListener{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Gameboard myboard, computersboard;
    int counter; // To count ONE ... TWO  and on THREE you play
    Socket socket;
    BufferedReader in;
    PrintWriter out;
    JButton closebutton;
	AudioInputStream audioInputStream;
	Clip clip;
	Boolean sound = true;


    RPSSkel () throws UnknownHostException, IOException, LineUnavailableException {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		String inputName = JOptionPane.showInputDialog("Enter your name:");
		
		closebutton = new JButton("Close");
		closebutton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
					in.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.exit(0);
			}
		});
		
		   
		
		JButton soundbutton = new JButton("Sound is on");
		soundbutton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(soundbutton.getText().equals("Sound is on")){
					clip.stop();
					sound = false;
					soundbutton.setText("Sound is off");
				}else{
					sound = true;
					soundbutton.setText("Sound is on");
				}
			}
		});
		
		//Ny gameboard med actionlistener implementerad i denna klass
		myboard = new Gameboard(inputName, this); 
		//nyttgameboard utan actionlistener
		computersboard = new Gameboard("Computer");
		
		//connecta till servern, in/ut connection
		socket = new Socket("localhost",4444);
	    in=new BufferedReader
	        (new InputStreamReader(socket.getInputStream()));
	    out=new PrintWriter(socket.getOutputStream());
		out.println(inputName); out.flush();
		System.out.println(in.readLine());

	    JPanel boards = new JPanel();
		boards.setLayout(new GridLayout(1,2));
		boards.add(myboard);
		boards.add(computersboard);
		
		JPanel settings = new JPanel(new GridLayout(2,1));
		add(boards, BorderLayout.CENTER);
		settings.add(soundbutton);
		add(settings, BorderLayout.SOUTH);
		settings.add(closebutton, BorderLayout.SOUTH);
		setSize(300, 550);
		setVisible(true);
    }
    
    private String play(String val) throws IOException{
    	out.println(val); out.flush();
    	String svar = in.readLine();
    	return svar;
    }

    public static void main (String[] u) throws UnknownHostException, IOException, LineUnavailableException {
    	new RPSSkel();
    }
    //metod som kollar vem som vann och returnerar en lista med vinnare/forlorare samt spelar ratt ljud
    private String[] state(String playerChoice, String computerChoice) throws IOException, LineUnavailableException{
    	String[] winnerLoser = {"Player", "Computer"};
    	if(playerChoice.equals(computerChoice)){
    		winnerLoser[0] = "Draw";
    		winnerLoser[1] = "Draw";
    		if(sound){
    			playSound("draw.wav");
        		
    		}
    	}else if(playerChoice.equals("PASE") && computerChoice.equals("STEN") || playerChoice.equals("SAX") && computerChoice.equals("PASE") || playerChoice.equals("STEN") && computerChoice.equals("SAX")){
    		winnerLoser[0] = "Winner";
    		winnerLoser[1] = "Loser";
    		if(sound){
    			playSound("win.wav");
    		}
    		myboard.wins();
    	}else{
    		computersboard.wins();
    		if(sound){
    			playSound("lose.wav");
    		}
    		winnerLoser[0] = "Loser";
    		winnerLoser[1] = "Winner";
    	}
    	return winnerLoser;
    }
    
	@Override
	public void actionPerformed(ActionEvent e) {
		counter++;
		myboard.resetColor();
		computersboard.resetColor();
		if(counter == 3){
			counter = 0;
			// mark det klickade alternativet gult och kom ihag det valda alternativet.
			myboard.markPlayed(e.getActionCommand());
			
			try {
				//be servern om ett svar
				String svar = play(e.getActionCommand());
				//mark datorns valda alternativ i datorns gameboard
				computersboard.markPlayed(svar);
				System.out.println("Computer: " + svar + "Player: " + e.getActionCommand());
				//index 0 ar spelaren index 1 ar datorn won/lost
				String[] winner = state(e.getActionCommand(), svar);
				//satter valda alternativ for spelare/dator
				myboard.setUpper(e.getActionCommand());
				computersboard.setUpper(svar);
				//satter vem som vann/forlorade under knapparna
				myboard.setLower(winner[0]);
				computersboard.setLower(winner[1]);
			} catch (IOException | LineUnavailableException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else{
			if(counter == 1){
				myboard.setLower("ETT");
				computersboard.setLower("ETT");
			}else{
				myboard.setLower("TVÅ");
				computersboard.setLower("TVÅ");
			}
		}
		
	}
	
	private void playSound(String filename) throws IOException, LineUnavailableException{
		try {
			audioInputStream = AudioSystem.getAudioInputStream(new File("src/resources/" + filename).getAbsoluteFile());
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
			
		} catch (UnsupportedAudioFileException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}

