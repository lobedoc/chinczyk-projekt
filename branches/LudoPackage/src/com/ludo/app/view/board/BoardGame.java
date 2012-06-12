package com.ludo.app.view.board;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import com.ludo.app.control.BoardControlInterface;
import com.ludo.app.view.board.box.BlueBox;
import com.ludo.app.view.board.box.Box;
import com.ludo.app.view.board.box.GreenBox;
import com.ludo.app.view.board.box.RedBox;
import com.ludo.app.view.board.box.WhiteBox;
import com.ludo.app.view.board.box.YellowBox;



public class BoardGame{

	private BoardControlInterface control;
	private Box[] box = new Box[95];
	private JFrame view;
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
		view.add(panelBoard(), BorderLayout.CENTER);
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.setVisible(true);
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
	public JPanel panelBoard(){
		initBox();
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		SpringLayout lay = new SpringLayout();
		panel.setLayout(lay);
		int h = view.getHeight();
		int w = view.getWidth();
		for(int i = 0; i < box.length; i++)
			panel.add(box[i]);

		lay.putConstraint(SpringLayout.WEST, box[0], w/2+30, SpringLayout.WEST,
				panel);
		lay.putConstraint(SpringLayout.NORTH, box[0], 25, SpringLayout.NORTH,
				panel);
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
		return panel;
	}
	
}
