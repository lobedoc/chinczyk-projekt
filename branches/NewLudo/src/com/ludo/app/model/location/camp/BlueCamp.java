package com.ludo.app.model.location.camp;


public class BlueCamp implements Camp{

	@Override
	public int[] getCampLocation() {
		// TODO Auto-generated method stub
		return new int[] {76, 77, 78, 79};
	}

	@Override
	public int getStart() {
		// TODO Auto-generated method stub
		return 52;
	}

	@Override
	public int getColor() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public String getPath() {
		// TODO Auto-generated method stub
		return "src/com/ludo/app/resources/images/bluePawn.png";
	}

}
