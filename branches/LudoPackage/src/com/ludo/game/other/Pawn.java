package com.ludo.game.other;

import java.io.Serializable;

import javax.swing.JComponent;

public class Pawn extends JComponent implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6728120083942141197L;
	private int blockId; //pozycja startowa danego pionka
	private int actualyPosition = 0;
	private int targetPosition = 0;
	
	public Pawn(){
		
	}
	public void setBlockId(int id){
		blockId = id;
	}
	public int getBlockId(){
		return blockId;
	}
	public boolean canMove(int movement){
		targetPosition = (actualyPosition + movement)%63;
		if(targetPosition > blockId)
			return false;
		return true;
	}
	public boolean move(int movement){
		if(!canMove(movement)){
			targetPosition=actualyPosition - blockId;
			targetPosition +=68;
			targetPosition -=2;
			targetPosition -=64;
			//redCamp.camp(targetPosition);
			return true;
		}
		else{
		targetPosition = (actualyPosition + movement)%63;
		moveTo(targetPosition);
		return true;
		}
	}
	
	private void moveTo(int movement){
		//wyrysowanie pionka do poruszania sie
	}
	private void moveFromBase(int movement) {
		if (movement != 6) {
			 moveTo(blockId);
		}
	}
}
