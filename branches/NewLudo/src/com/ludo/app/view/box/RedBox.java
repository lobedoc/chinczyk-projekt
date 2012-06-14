package com.ludo.app.view.box;

import java.awt.Color;
import java.awt.Graphics;

public class RedBox extends Box{
	
	public RedBox(){
		colorBox = Color.RED;
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
	}
}
