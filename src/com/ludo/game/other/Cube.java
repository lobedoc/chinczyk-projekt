package com.ludo.game.other;

public abstract class Cube {

	Roll roll;
	
	public Cube(){
		
	}
	
	public int rollDice(){
		return roll.roll();
	}
}
