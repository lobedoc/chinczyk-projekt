package com.ludo.app.control;

import java.awt.Color;
import java.io.Serializable;

import com.ludo.app.model.location.camp.Camp;
import com.ludo.app.model.location.house.House;
import com.ludo.app.model.Pawn;

public abstract class Player implements Serializable {
	private final int PAWN_SIZE = 4;
	protected Color colorPlayer;
	protected Pawn[] pawnPlayer = new Pawn[PAWN_SIZE];
	
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
		colorPlayer = camp.getColor();
		for(int i = 0; i < campId.length; i++){
			pawnPlayer[i].setCampId(campId[i]);
			pawnPlayer[i].setActualyPosition(campId[i]);
			pawnPlayer[i].setStartId(start);
			pawnPlayer[i].setPawnColor(colorPlayer);
		}
	}
	public void setHouse(House house){
		for(int i = 0; i < pawnPlayer.length; i++){
			int[] location = house.getHouseLocation();
			pawnPlayer[i].setHouseLocation(location);
		}
	}
	public Color getColorPlayer() {
		return colorPlayer;
	}
	
	public abstract void sendReady();
}
