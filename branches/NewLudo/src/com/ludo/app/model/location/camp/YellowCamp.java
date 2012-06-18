package com.ludo.app.model.location.camp;



public class YellowCamp implements Camp{

	@Override
	public int[] getCampLocation() {
		// TODO Auto-generated method stub
		return new int[] {64, 65, 66, 67};
	}

	@Override
	public int getStart() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public int getColor() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public String getPath() {
		// TODO Auto-generated method stub
		return "src/com/ludo/app/resources/images/yellowPawn.png";
	}
}
