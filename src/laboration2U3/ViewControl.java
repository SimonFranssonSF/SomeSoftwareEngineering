package laboration2U3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import laboration2.Boardgame;

//l�mpliga import-satser h�r
class ViewControl extends JFrame implements ActionListener {

 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Boardgame game;
	private int size;
	private Square[][] board;        
	private JLabel mess = new JLabel("Hej", JLabel.CENTER);
	private Container container;
	private JButton button1;
	private JComboBox<String> games;
	String gameNameVariable;

	private ViewControl (Boardgame gm, int n){ 
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Boardgame"); 
		container = getContentPane();
		game = gm;
		
		size = n;
		board = new Square[size][size];
		
		JPanel boardPanel = new JPanel(new GridLayout(size,size,1,1));
		boardPanel.setBackground(new Color(0x00000));
		
		//loopar ut squares (knappar) som ska presentera modellens spelplan.
		//alla index i status[][] som ar null representeras med en svart square, dom andra ar bla 
		for (int i = 0; i < size; i++){
			for (int j = 0; j < size; j++){
				String text;
				Color color;
				color = new Color(0x798795);
				//har andrar jag till iconimage ifall jag vill ha det istallet.
				text = game.getStatus(i, j);
				//System.out.println(text);
				
				
				if (text == null){
					color = new Color(0x00000);
				}
				Square ruta = new Square(text, color);
				
				ruta.setIndex(i, j);
				ruta.addActionListener(this);
				board[i][j] = ruta;
				boardPanel.add(ruta);
			}
		}
		Border blackline = BorderFactory.createLineBorder(Color.black);
		boardPanel.setBackground(new Color(0xB2BAD1));
		boardPanel.setBorder(blackline);
		
		
		//fult satt att kolla vilket spel som spelas, jag ville inte lagga till nagon variabel "Game name" i modellen
		if(board.length == 3){
			gameNameVariable = "TicTacToe";
		}else if (board.length == 8){
			gameNameVariable = "MockObjectModel";
		}else{
			gameNameVariable = "Fifteen Puzzle";
		}
		
		JPanel gameTitle = new JPanel();
		gameTitle.setBorder(blackline);
		gameTitle.setLayout(new BorderLayout());
		
		JPanel left = new JPanel();
		left.setLayout(new FlowLayout());
		JLabel gameName = new JLabel(gameNameVariable);
		gameName.setFont(new Font("Arial", Font.BOLD, 15));
		left.add(gameName);
		gameTitle.add(left, BorderLayout.CENTER);
		

		
		//south.add(right);
		//south.add(new JLabel(" Game:"));
		JPanel messagePanel = new JPanel();
		messagePanel.setBorder(blackline);
		mess.setText(game.getMessage());
		messagePanel.setLayout(new BorderLayout());
		messagePanel.setBackground(new Color(0x798795));
		messagePanel.setPreferredSize(new Dimension(230, 230));
		
		JPanel southgrid = new JPanel(new GridLayout(2,1,4,4));
		southgrid.setBackground(new Color(0x798795));
		String[] gamesAvailble = {"TicTacToe", "Fifteen Puzzle", "MockObjectModel"};
		games = new JComboBox<String>(gamesAvailble);
		games.setSelectedItem(gameNameVariable);
		games.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(games.getSelectedItem().toString().equals("TicTacToe")){
					String[] args = {"TicTacToe"};
					ViewControl.this.dispose();
					ViewControl.main(args);
				}else if(games.getSelectedItem().toString().equals("Fifteen Puzzle")){
					String[] args = {"Fifteen"};
					ViewControl.this.dispose();
					ViewControl.main(args);
				}else if(games.getSelectedItem().toString().equals("MockObjectModel")){
					String[] args = {"MockObjectModel"};
					ViewControl.this.dispose();
					ViewControl.main(args);
				}
			}
		});
		southgrid.add(games);
		
		JPanel south = new JPanel();
		button1 = new JButton("New Game");
		button1.setPreferredSize(new Dimension(10, 20));
		button1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String[] args = {gameNameVariable};
				ViewControl.this.dispose();
				ViewControl.main(args);
			}
		});
		southgrid.add(button1);
		south.setLayout(new BoxLayout(south, BoxLayout.Y_AXIS));
		south.add(southgrid);
		messagePanel.add(south, BorderLayout.SOUTH);
		
		JPanel north = new JPanel();
		north.setBackground(new Color(0x798795));
		north.add(mess, BorderLayout.CENTER);
		messagePanel.add(north, BorderLayout.CENTER);
		
		container.add(gameTitle, BorderLayout.NORTH);
		container.setBackground(new Color(0x798795));
		container.add(messagePanel, BorderLayout.EAST);
		container.add(boardPanel, BorderLayout.WEST);
		pack();
		
		//Centers the jFrame
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	}

	@Override
	//lyssnar pa knapparna och anropar modellernas metod "move(i,j)"
	public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
		container.setVisible(false);
		boolean status = false;
		Square klickad;
		for (int i = 0; i < size; i++){
			for (int j = 0; j < size; j++){
				if(board[i][j] .equals(e.getSource())){
					klickad = board[i][j];
					System.out.println("I: " + klickad.getIndexI());
					System.out.println("J: " + klickad.getIndexJ());
					status = game.move(i, j);
				}
			}
		}
		//om en flytt skett uppdatera bradet
		if (status == true){
			updateBoard();
		}
		mess.setText(game.getMessage());
		container.setVisible(true);
	}
	
	//uppdaterar board  f�r att efterlikna status i boardgame-klasserna
	private void updateBoard(){
		String ruta;
		Square bricka;
		for (int i = 0; i < size; i++){
			for (int j = 0; j < size; j++){
				ruta = game.getStatus(i, j);
				bricka = board[i][j];
				if(bricka.getText() != ruta){
					//har andrar jag texten ifall jag vill ha iconimage 
					bricka.setText(ruta);
					if(bricka.getText() == null){
						bricka.setBackground(new Color(0x00000));
					}else{
						bricka.setBackground(new Color(0x798795));
					}
				}
			}
		}
	}
	
	public static void main(String[] args){
		if(args.length != 0 && args[0].equals("TicTacToe")){
			Boardgame game = new TicTacToeModel(3);
			ViewControl frame = new ViewControl(game, 3);
			frame.setVisible(true);
		}else if(args.length != 0 && args[0].equals("Fifteen Puzzle")){
			Boardgame game = new FifteenModel(4);
			ViewControl frame = new ViewControl(game, 4);
			frame.setVisible(true);
		}else if(args.length != 0 && args[0].equals("MockObjectModel")){
			Boardgame game = new MockObjectModel(8);
			ViewControl frame = new ViewControl(game, 8);
			frame.setVisible(true);
		}else{
			Boardgame game = new FifteenModel(4);
			ViewControl frame = new ViewControl(game, 4);
			frame.setVisible(true);
		}
	}
 }