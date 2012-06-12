package com.ludo.app.view.board;

import java.awt.Color;
import java.awt.Graphics;

public class RedBox extends Box{
	
	public RedBox(){
		colorBox = Color.BLUE;
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
	}
}
