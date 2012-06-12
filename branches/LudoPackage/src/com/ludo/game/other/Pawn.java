package com.ludo.game.other;

import java.io.Serializable;

import javax.swing.JComponent;

public class Pawn extends JComponent implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6728120083942141197L;
	private int startId; //pozycja startowa danego pionka
	private int campId;
	private int actualyPosition = 0;
	private int targetPosition = 0;
	
	public Pawn(){
		
	}
	public void setCampId(int id){
		campId = id;
	}
	public int getCampId(){
		return campId;
	}
	public void setStartId(int id){
		startId = id;
	}
	public int getStartId(){
		return startId;
	}
	public int getActualyPosition() {
		return actualyPosition;
	}
	public void setActualyPosition(int actualyPosition) {
		this.actualyPosition = actualyPosition;
	}
	public boolean canMove(int movement){
		targetPosition = (actualyPosition + movement)%63;
		if(targetPosition > startId)
			return false;
		return true;
	}
	public boolean move(int movement){
		if(!canMove(movement)){
			targetPosition=actualyPosition - startId;
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
		if (movement == 6) {
			 moveTo(startId);
		}
	}
}
