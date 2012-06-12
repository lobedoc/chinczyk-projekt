package com.ludo.app.view.board;

import java.awt.Dimension;

import javax.swing.JPanel;

import com.ludo.app.view.board.box.Box;

public abstract class House extends JPanel{

	protected Box[] box;
	
	public House(){
		
	}
	private Dimension getBoxSize(){
		return new Dimension(120,120);
	}
	public Box getBox(int i){
		return box[i];
	}
}
