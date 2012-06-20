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
	protected Random r = new Random();
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
	public int getPawnPosition(int i){
		return pawnPlayer[i].getActualyPosition();
	}
	public void setPawnPosition(int pawn, int position){
		int actualy = this.pawnPlayer[pawn].getActualyPosition();
		this.pawnPlayer[pawn].setLastPosition(actualy);
		this.pawnPlayer[pawn].setActualyPosition(position);
	}
	public int getColor(){
		return playerColor;
	}
	public void movePawn(int pawn, int move){
		pawnPlayer[pawn].move(move);
	}
	public void setPawns(Pawn[] pawns){
		this.pawnPlayer = pawns;
	}
	public int rollDice(){
		int numberRoll = r.nextInt(6)+1;
		return numberRoll;
	}
	public abstract void sendReady();
}
