package com.ludo.app.view.board;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.ludo.app.control.BoardControlInterface;
import com.ludo.app.view.board.box.BlueBox;
import com.ludo.app.view.board.box.Box;
import com.ludo.app.view.board.box.GreenBox;
import com.ludo.app.view.board.box.RedBox;
import com.ludo.app.view.board.box.WhiteBox;
import com.ludo.app.view.board.box.YellowBox;



public class BoardGame implements ActionListener{

	private BoardControlInterface control;
	private Box[] box = new Box[96];
	private JFrame view;
	private JButton buttonJoinYellow;
	private JButton buttonJoinRed;
	private JButton buttonJoinGreen;
	private JButton buttonJoinBlue;
	private JButton buttonRoll;
	private JButton buttonSend;
	private JTextField fieldMsg;
	private JTextArea areaMsg;
	public BoardGame(BoardControlInterface control){
		this.control = control;
	}
	
	public void createView(){
		view = new JFrame();
		view.setPreferredSize(new Dimension(800, 600));
		view.setMinimumSize(new Dimension(800, 600));
		view.setLayout(new BorderLayout());
		Dimension dialogSize = 	view.getSize();		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();  
		if(dialogSize.height > screenSize.height) 
			dialogSize.height = screenSize.height;
		if(dialogSize.width > screenSize.width)
			dialogSize.height = screenSize.width;
		view.setLocation((screenSize.width-dialogSize.width)/2,   
						(screenSize.height-dialogSize.height)/2);
		view.setResizable(false);
		createControlElements();
		view.add(panelRight(), BorderLayout.EAST);
		view.add(panelBoard(), BorderLayout.CENTER);

		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.setVisible(true);
	}
	private void createControlElements(){
		buttonJoinYellow = new JButton("Dołącz");
		buttonJoinRed = new JButton("Dołącz");
		buttonJoinGreen = new JButton("Dołącz");
		buttonJoinBlue = new JButton("Dołącz");
		buttonRoll = new JButton("Rzuć kostka");
		buttonSend = new JButton("Wyślij");
		fieldMsg = new JTextField(10);
		areaMsg = new JTextArea(15,2);
		 areaMsg.setBorder(new CompoundBorder(
	                new LineBorder(Color.BLACK),
	                new EmptyBorder(1, 3, 1, 1)));
		areaMsg.setLineWrap(true);
		areaMsg.setWrapStyleWord(true);
		areaMsg.setText( "This is an editable JTextArea. " +
    "A text area is a \"plain\" text component, " +
    "which means that although it can display text " +
    "in any font, all of the text is in the same font.");
		areaMsg.setEditable(false);
	}
	private void initBox(){
		for(int i = 0; i < box.length; i++){
			if(i == 0 || i == 80 || i == 81 || i == 82 || i == 83 || i == 64 || i == 65 || i == 66 || i == 67)
				box[i] = new YellowBox();
			else if(i == 16 || i == 84 || i == 85 || i == 86 || i == 87 || i == 68 || i == 69 || i == 70 || i == 71)
				box[i] = new RedBox();
			else if(i == 32 || i == 88 || i == 89 || i == 90 || i == 91 || i == 72 || i == 73 || i == 74 || i == 75)
				box[i] = new GreenBox();
			else if(i == 48 || i == 92 || i == 93 || i == 94 || i == 95 || i == 76 || i == 77 || i == 78 || i == 79)
				box[i] = new BlueBox();
			else
				box[i] = new WhiteBox();
		}
	}
	private JPanel panelRight(){
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(panelRightUp(), BorderLayout.NORTH);
		panel.setPreferredSize(new Dimension(150, panel.getHeight()));
		panel.add(panelRightDown(), BorderLayout.CENTER);
		return panel;
	}
	private JPanel panelRightUp(){
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setLayout(new GridLayout(4,2,5,5));
		JLabel labelYellow = new JLabel("Żółty:", SwingConstants.RIGHT);
		labelYellow.setForeground(Color.YELLOW);
		JLabel labelRed = new JLabel("Czerwony:", SwingConstants.RIGHT);
		labelRed.setForeground(Color.RED);
		JLabel labelGreen = new JLabel("Zielony:", SwingConstants.RIGHT);
		labelGreen.setForeground(Color.GREEN);
		JLabel labelBlue = new JLabel("Niebieski:", SwingConstants.RIGHT);
		labelBlue.setForeground(Color.BLUE);
		
		panel.add(labelYellow);
		panel.add(buttonJoinYellow);
		panel.add(labelRed);
		panel.add(buttonJoinRed);
		panel.add(labelGreen);
		panel.add(buttonJoinGreen);
		panel.add(labelBlue);
		panel.add(buttonJoinBlue);
		return panel;
	}
	private JPanel panelRightDown(){
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		JPanel panelDown = new JPanel();
		panelDown.setLayout(new GridLayout(1,2,5,5));
		panelDown.add(fieldMsg);
		panelDown.add(buttonSend);
		JScrollPane scrollPane = new JScrollPane(areaMsg); 
		panel.add(scrollPane, BorderLayout.CENTER);
		panel.add(panelDown, BorderLayout.SOUTH);
		return panel;
	}
	private JPanel panelBoard(){
		initBox();
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		SpringLayout lay = new SpringLayout();
		
		panel.setLayout(lay);
		int w = view.getWidth();
		for(int i = 0; i < box.length; i++)
			panel.add(box[i]);

		lay.putConstraint(SpringLayout.WEST, box[0], w/3 + 60, SpringLayout.WEST,
				panel);
		lay.putConstraint(SpringLayout.NORTH, box[0], 25, SpringLayout.NORTH,
				panel);
		/* zolty domek */
		lay.putConstraint(SpringLayout.WEST, box[64], 60, SpringLayout.WEST,
				box[1]);
		lay.putConstraint(SpringLayout.NORTH, box[64], 0, SpringLayout.NORTH,
				box[1]);
		lay.putConstraint(SpringLayout.WEST, box[65], 60, SpringLayout.WEST,
				box[64]);
		lay.putConstraint(SpringLayout.NORTH, box[65], 0, SpringLayout.NORTH,
				box[64]);
		lay.putConstraint(SpringLayout.WEST, box[66], 0, SpringLayout.WEST,
				box[64]);
		lay.putConstraint(SpringLayout.NORTH, box[66], 60, SpringLayout.NORTH,
				box[64]);
		lay.putConstraint(SpringLayout.WEST, box[67], 0, SpringLayout.WEST,
				box[65]);
		lay.putConstraint(SpringLayout.NORTH, box[67], 60, SpringLayout.NORTH,
				box[65]);
		
		// czerwony domek
		
		lay.putConstraint(SpringLayout.WEST, box[68], 60, SpringLayout.WEST,
				box[29]);
		lay.putConstraint(SpringLayout.NORTH, box[68], 0, SpringLayout.NORTH,
				box[29]);
		lay.putConstraint(SpringLayout.WEST, box[69], 60, SpringLayout.WEST,
				box[68]);
		lay.putConstraint(SpringLayout.NORTH, box[69], 0, SpringLayout.NORTH,
				box[68]);
		lay.putConstraint(SpringLayout.WEST, box[70], 0, SpringLayout.WEST,
				box[68]);
		lay.putConstraint(SpringLayout.NORTH, box[70], -60, SpringLayout.NORTH,
				box[68]);
		lay.putConstraint(SpringLayout.WEST, box[71], 0, SpringLayout.WEST,
				box[69]);
		lay.putConstraint(SpringLayout.NORTH, box[71], -60, SpringLayout.NORTH,
				box[69]);
		
		// zielony domek
		
		lay.putConstraint(SpringLayout.WEST, box[72], -60, SpringLayout.WEST,
				box[33]);
		lay.putConstraint(SpringLayout.NORTH, box[72], 0, SpringLayout.NORTH,
				box[33]);
		lay.putConstraint(SpringLayout.WEST, box[73], -60, SpringLayout.WEST,
				box[72]);
		lay.putConstraint(SpringLayout.NORTH, box[73], 0, SpringLayout.NORTH,
				box[72]);
		lay.putConstraint(SpringLayout.WEST, box[74], 0, SpringLayout.WEST,
				box[72]);
		lay.putConstraint(SpringLayout.NORTH, box[74], -60, SpringLayout.NORTH,
				box[72]);
		lay.putConstraint(SpringLayout.WEST, box[75], 0, SpringLayout.WEST,
				box[73]);
		lay.putConstraint(SpringLayout.NORTH, box[75], -60, SpringLayout.NORTH,
				box[73]);
		
		// niebieski domek
		
		lay.putConstraint(SpringLayout.WEST, box[76], -60, SpringLayout.WEST,
				box[61]);
		lay.putConstraint(SpringLayout.NORTH, box[76], 0, SpringLayout.NORTH,
				box[61]);
		lay.putConstraint(SpringLayout.WEST, box[77], -60, SpringLayout.WEST,
				box[76]);
		lay.putConstraint(SpringLayout.NORTH, box[77], 0, SpringLayout.NORTH,
				box[76]);
		lay.putConstraint(SpringLayout.WEST, box[78], 0, SpringLayout.WEST,
				box[76]);
		lay.putConstraint(SpringLayout.NORTH, box[78], 60, SpringLayout.NORTH,
				box[76]);
		lay.putConstraint(SpringLayout.WEST, box[79], 0, SpringLayout.WEST,
				box[77]);
		lay.putConstraint(SpringLayout.NORTH, box[79], 60, SpringLayout.NORTH,
				box[77]);
		
		
		for(int i = 1; i <= 7; i++){
				lay.putConstraint(SpringLayout.NORTH, box[i], 30, SpringLayout.NORTH,
						box[i-1]);
				lay.putConstraint(SpringLayout.WEST, box[i], 0, SpringLayout.WEST,
						box[0]);
		}
		for(int i = 8; i <= 14; i++ ){
			lay.putConstraint(SpringLayout.NORTH, box[i], 0, SpringLayout.NORTH,
					box[7]);
			lay.putConstraint(SpringLayout.WEST, box[i], 30, SpringLayout.WEST,
					box[i-1]);
		}
		for(int i = 15; i <= 16; i++){
			lay.putConstraint(SpringLayout.NORTH, box[i], 30, SpringLayout.NORTH,
					box[i-1]);
			lay.putConstraint(SpringLayout.WEST, box[i], 0, SpringLayout.WEST,
					box[14]);
		}
		for(int i = 17; i <= 23; i++ ){
			lay.putConstraint(SpringLayout.NORTH, box[i], 0, SpringLayout.NORTH,
					box[16]);
			lay.putConstraint(SpringLayout.WEST, box[i], -30, SpringLayout.WEST,
					box[i-1]);
		}
		for(int i = 24; i <= 30; i++){
			lay.putConstraint(SpringLayout.NORTH, box[i], 30, SpringLayout.NORTH,
					box[i-1]);
			lay.putConstraint(SpringLayout.WEST, box[i], 0, SpringLayout.WEST,
					box[23]);
		}
		for(int i = 31; i <= 32; i++ ){
			lay.putConstraint(SpringLayout.NORTH, box[i], 0, SpringLayout.NORTH,
					box[30]);
			lay.putConstraint(SpringLayout.WEST, box[i], -30, SpringLayout.WEST,
					box[i-1]);
		}
		for(int i = 33; i <= 39; i++){
			lay.putConstraint(SpringLayout.NORTH, box[i], -30, SpringLayout.NORTH,
					box[i-1]);
			lay.putConstraint(SpringLayout.WEST, box[i], 0, SpringLayout.WEST,
					box[32]);
		}
		for(int i = 40; i <= 46; i++ ){
			lay.putConstraint(SpringLayout.NORTH, box[i], 0, SpringLayout.NORTH,
					box[39]);
			lay.putConstraint(SpringLayout.WEST, box[i], -30, SpringLayout.WEST,
					box[i-1]);
		}
		for(int i = 47; i <= 48; i++){
			lay.putConstraint(SpringLayout.NORTH, box[i], -30, SpringLayout.NORTH,
					box[i-1]);
			lay.putConstraint(SpringLayout.WEST, box[i], 0, SpringLayout.WEST,
					box[46]);
		}
		for(int i = 49; i <= 55; i++ ){
			lay.putConstraint(SpringLayout.NORTH, box[i], 0, SpringLayout.NORTH,
					box[48]);
			lay.putConstraint(SpringLayout.WEST, box[i], 30, SpringLayout.WEST,
					box[i-1]);
		}
		for(int i = 56; i <= 62; i++){
			lay.putConstraint(SpringLayout.NORTH, box[i], -30, SpringLayout.NORTH,
					box[i-1]);
			lay.putConstraint(SpringLayout.WEST, box[i], 0, SpringLayout.WEST,
					box[55]);
		}
		for(int i = 63; i <= 63; i++ ){
			lay.putConstraint(SpringLayout.NORTH, box[i], 0, SpringLayout.NORTH,
					box[62]);
			lay.putConstraint(SpringLayout.WEST, box[i], 30, SpringLayout.WEST,
					box[i-1]);
		}
		
		// zolty koniec
		lay.putConstraint(SpringLayout.NORTH, box[80], 30, SpringLayout.NORTH,
				box[63]);
		lay.putConstraint(SpringLayout.WEST, box[80], 0, SpringLayout.WEST,
				box[63]);
		for(int i = 81; i <= 83; i++){
			lay.putConstraint(SpringLayout.NORTH, box[i], 30, SpringLayout.NORTH,
					box[i-1]);
			lay.putConstraint(SpringLayout.WEST, box[i], 0, SpringLayout.WEST,
					box[i-1]);
		}
		
		// czerwony koniec
		
		lay.putConstraint(SpringLayout.NORTH, box[84], 0, SpringLayout.NORTH,
				box[15]);
		lay.putConstraint(SpringLayout.WEST, box[84], -30, SpringLayout.WEST,
				box[15]);
		for(int i = 85; i <= 87; i++){
			lay.putConstraint(SpringLayout.NORTH, box[i], 0, SpringLayout.NORTH,
					box[i-1]);
			lay.putConstraint(SpringLayout.WEST, box[i], -30, SpringLayout.WEST,
					box[i-1]);
		}
		
		// zielony koniec
		
		lay.putConstraint(SpringLayout.NORTH, box[88], -30, SpringLayout.NORTH,
				box[31]);
		lay.putConstraint(SpringLayout.WEST, box[88], 0, SpringLayout.WEST,
				box[31]);
		for(int i = 89; i <= 91; i++){
			lay.putConstraint(SpringLayout.NORTH, box[i], -30, SpringLayout.NORTH,
					box[i-1]);
			lay.putConstraint(SpringLayout.WEST, box[i], 0, SpringLayout.WEST,
					box[i-1]);
		}
		
		// niebieski koniec
		
		lay.putConstraint(SpringLayout.NORTH, box[92], 0, SpringLayout.NORTH,
				box[47]);
		lay.putConstraint(SpringLayout.WEST, box[92], 30, SpringLayout.WEST,
				box[47]);
		for(int i = 93; i <= 95; i++){
			lay.putConstraint(SpringLayout.NORTH, box[i], 0, SpringLayout.NORTH,
					box[i-1]);
			lay.putConstraint(SpringLayout.WEST, box[i], 30, SpringLayout.WEST,
					box[i-1]);
		}
		return panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
