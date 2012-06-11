package com.ludo.game.other;

import java.io.Serializable;

import javax.swing.JComponent;

public class Pawn extends JComponent implements Serializable{

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
