package com.ludo.app.model;

import java.awt.Color;

public class BlueCamp implements Camp{

	@Override
	public int[] getCampLocation() {
		// TODO Auto-generated method stub
		return new int[] {76, 77, 78, 79};
	}

	@Override
	public int getStart() {
		// TODO Auto-generated method stub
		return 48;
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return Color.BLUE;
	}

}
