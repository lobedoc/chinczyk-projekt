package com.ludo.game.board;

import java.awt.Color;
import java.awt.Graphics;

public class BlueBox extends Box{

	public BlueBox(){
		colorBox = Color.BLUE;
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
	}
}
