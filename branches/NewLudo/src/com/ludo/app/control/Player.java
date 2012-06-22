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
	private int numberRoll;
	private String name;
	protected Random r = new Random();
	public Player(String name){
		this.name = name;
		for(int i = 0; i < pawnPlayer.length; i++)
			pawnPlayer[i] = new Pawn();
	}
	public Pawn[] getPawns(){
		return pawnPlayer;
	}
	public int[] getHouse(){
		return pawnPlayer[0].getHouseLocation();
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
		this.pawnPlayer[pawn].setActualyPosition(position);
	}
	public void setPawnLastPosition(int pawn, int position){
		this.pawnPlayer[pawn].setLastPosition(position);
	}
	public int getPawnLastPosition(int pawn){
		return pawnPlayer[pawn].getLastPosition();
	}
	public int getColor(){
		return playerColor;
	}
	public void movePawn(int pawn){
		pawnPlayer[pawn].move(numberRoll);
		numberRoll = 0;
	}
	public void movePawnBase(int pawn){
		pawnPlayer[pawn].moveFromBase(6);
		numberRoll = 0;
	}
	public void setPawns(Pawn[] pawns){
		this.pawnPlayer = pawns;
	}
	public int getRoll(){
		return numberRoll;
	}
	public void rollDice(){
		numberRoll = r.nextInt(6)+1;
	}
	public abstract void sendReady();
	public String getName() {
		return name;
	}
	
}
