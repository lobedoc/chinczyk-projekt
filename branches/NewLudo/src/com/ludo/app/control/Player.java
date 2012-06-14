package com.ludo.app.control;

import com.ludo.app.model.Camp;
import com.ludo.app.model.Pawn;

public abstract class Player {
	private final int PAWN_SIZE = 4;
	private Pawn[] pawnPlayer = new Pawn[PAWN_SIZE];
	
	public Player(){
		for(int i = 0; i < pawnPlayer.length; i++)
			pawnPlayer[i] = new Pawn();
	}
	public Pawn[] getPawns(){
		return pawnPlayer;
	}
	public void setCamp(Camp camp){
		int[] campId = camp.getCampLocation();
		int start = camp.getStart();
		for(int i = 0; i < campId.length; i++){
			pawnPlayer[i].setCampId(campId[i]);
			pawnPlayer[i].setActualPosition(campId[i]);
			pawnPlayer[i].setStartId(start);
		}
	}
}
