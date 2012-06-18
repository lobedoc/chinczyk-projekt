package com.ludo.app.model.location.camp;


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
	public int getColor() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public String getPath() {
		// TODO Auto-generated method stub
		return "src/com/ludo/app/resources/images/redPawn.png";
	}
}
