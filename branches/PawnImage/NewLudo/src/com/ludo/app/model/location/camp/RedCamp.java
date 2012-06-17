package com.ludo.app.model.location.camp;

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
		return 20;
	}
 
	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return Color.RED;
	}

	@Override
	public String getPath() {
		// TODO Auto-generated method stub
		return "src/com/ludo/app/resources/images/redPawn.png";
	}
}
