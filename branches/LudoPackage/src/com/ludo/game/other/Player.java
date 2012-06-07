package com.ludo.game.other;

import java.awt.Color;

public abstract class Player {

	private Cube cube;
	protected Pawn[] pawn = new Pawn[4];
	private Color playerColor = Color.RED;
	private String playerName = "Player";
	
	public Player(Cube cube) {
		this.cube = cube;
		for(int i = 0; i < pawn.length; i++)
			pawn[i] = new Pawn(playerColor);
	}
	
	public void setPlayerColor(Color color){
		this.playerColor = color;
		for(int i = 0; i < pawn.length; i++)
			pawn[i].setPawnColor(color);
	}
	public Color getPlayerColor(){
		return playerColor;
	}
	public int rollDice(){
		return cube.rollDice();
	}
	public void setPlayerName(String name){
		this.playerName = name;
	}
	
	public String getPlayerName(){
		return playerName;
	}
	
}
