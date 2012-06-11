package com.ludo.game.board;

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
