package com.ludo.app.view.board.box;
import java.awt.Color;
import java.awt.Graphics;

public class WhiteBox extends Box{
	
	public WhiteBox(){
		colorBox = Color.WHITE;
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
	}
}
