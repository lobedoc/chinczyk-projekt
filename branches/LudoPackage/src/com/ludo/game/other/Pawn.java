package com.ludo.game.other;

import java.awt.Color;

public class Pawn {

	private Color pawnColor;
	private int x;
	private int y;
	public Pawn(Color color){
		this.pawnColor = color;
	}
	public void setPawnX(int x){
		this.x = x;
	}
	public void setPawnY(int y){
		this.y = y;
	}
	public void movePawn(int x, int y){
		this.x = this.x + x;
		this.y = this.y + y;
	}
	
	public void setPawnColor(Color color){
		this.pawnColor = color;
	}
}
