package com.ludo.game.other;

import java.awt.Color;

public abstract class Player {

	protected Pawn[] pawn = new Pawn[4];
	private Color playerColor;
	private String playerName;
	
	public Player(String name, Color color) {
		this.playerName = name;
		this.playerColor = color;
		for(int i = 0; i < pawn.length; i++){
			pawn[i] = new Pawn();
			pawn[i].setColorPawn(color);
		}

		
	}
	public Pawn getPawn(int i){
		return pawn[i];
	}
	public Pawn[] getPawns(){
		return pawn;
	}
	public void setPawnCamp(Camp camp){
		int[] campId = camp.getCampLocation();
		int start = camp.getStart();
		for(int i = 0; i < campId.length; i++){
			pawn[i].setCampId(campId[i]);
			pawn[i].setStartId(start);
		}
	}
	public void setPlayerColor(Color color){
		this.playerColor = color;
		for(int i = 0; i < pawn.length; i++)
			pawn[i].setColorPawn(color);
	}
	public Color getPlayerColor(){
		return playerColor;
	}
	public void setPlayerName(String name){
		this.playerName = name;
	}
	
	public String getPlayerName(){
		return playerName;
	}
	
}
