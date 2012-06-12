package com.ludo.app.view.board;

import java.awt.BorderLayout;
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

		int h = view.getHeight();
		int w = view.getWidth();

		panel.add(box[63]);
		return panel;
	}
}
