package com.ludo.app.model.location.camp;


import java.awt.Color;

public class YellowCamp implements Camp{

	@Override
	public int[] getCampLocation() {
		// TODO Auto-generated method stub
		return new int[] {64, 65, 66, 67};
	}

	@Override
	public int getStart() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return Color.YELLOW;
	}
}
