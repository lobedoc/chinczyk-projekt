package com.ludo.app.model.location.camp;


import java.awt.Color;

public class GreenCamp implements Camp{

	@Override
	public int[] getCampLocation() {
		// TODO Auto-generated method stub
		return new int[] {72,73,74,75};
	}

	@Override
	public int getStart() {
		// TODO Auto-generated method stub
		return 36;
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return Color.GREEN;
	}

	@Override
	public String getPath() {
		// TODO Auto-generated method stub
		return "src/com/ludo/app/resources/images/greenPawn.png";
	}
}
