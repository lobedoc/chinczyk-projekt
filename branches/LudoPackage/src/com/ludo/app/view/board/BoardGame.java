package com.ludo.app.view.board;

import javax.swing.JFrame;

import com.ludo.app.control.BoardControlInterface;



public class BoardGame{

	private BoardControlInterface control;
	private JFrame frame;
	public BoardGame(BoardControlInterface control){
		this.control = control;
	}
	
	public void createView(){
		frame = new JFrame();
		
	}
}
