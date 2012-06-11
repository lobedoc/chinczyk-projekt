package com.ludo.game.other;

import java.io.Serializable;

public class Pawn implements Serializable{

	private int blockId;
	
	public Pawn(){
		
	}
	public void setBlockId(int id){
		blockId = id;
	}
	public int getBlockId(){
		return blockId;
	}
	
}
