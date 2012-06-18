package com.ludo.app.control;


import java.io.Serializable;
import java.util.Random;

import com.ludo.app.model.location.camp.Camp;
import com.ludo.app.model.location.house.House;
import com.ludo.app.model.Pawn;

public abstract class Player implements Serializable {
	private final int PAWN_SIZE = 4;
	protected Pawn[] pawnPlayer = new Pawn[PAWN_SIZE];
	private int playerColor;
	private Random r = new Random();
	private int numberRoll ;
	public Player(){
		for(int i = 0; i < pawnPlayer.length; i++)
			pawnPlayer[i] = new Pawn();
	}
	public Pawn[] getPawns(){
		return pawnPlayer;
	}
	public void setCamp(Camp camp){
		int[] campId = camp.getCampLocation();
		playerColor = camp.getColor();
		int start = camp.getStart();
		for(int i = 0; i < campId.length; i++){
			pawnPlayer[i].setCampId(campId[i]);
			pawnPlayer[i].setActualyPosition(campId[i]);
			pawnPlayer[i].setStartId(start);
			pawnPlayer[i].setPath(camp.getPath());
		}
	}
	public void setHouse(House house){
		for(int i = 0; i < pawnPlayer.length; i++){
			int[] location = house.getHouseLocation();
			pawnPlayer[i].setHouseLocation(location);
		}
	}
	public Pawn getPawn(int i){
		return pawnPlayer[i];
	}
	
	public int getColor(){
		return playerColor;
	}
	public void movePawn(int pawn){
		pawnPlayer[pawn].move(numberRoll);
	}
	public void rollDice(){
		numberRoll = r.nextInt(6)+1;
		System.out.println("wyrzucono:" + numberRoll);
	}
	public abstract void sendReady();
}
