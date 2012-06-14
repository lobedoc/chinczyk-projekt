package com.ludo.app.model;

import java.awt.Color;

public class RedCamp implements Camp{

	@Override
	public int[] getCampLocation() {
		// TODO Auto-generated method stub
		return new int[] {68, 69, 70, 71};
	}

	@Override
	public int getStart() {
		// TODO Auto-generated method stub
		return 16;
	}
 
	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return Color.RED;
	}
}
