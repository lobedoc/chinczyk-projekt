package com.ludo.app.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;

import com.ludo.app.observer.PawnObserver;
import com.ludo.app.observer.PawnSubject;

public class Pawn implements PawnSubject{
	
	private ArrayList<PawnObserver> observer = new ArrayList<PawnObserver>();
	
	private int startId;
	private int campId;

	private Color pawnColor;
	
	private int actualyPosition;
	private int targetPosition;
	
	@Override
	public void registerObserver(PawnObserver o) {
		// TODO Auto-generated method stub
		observer.add(o);
		
	}

	@Override
	public void removeObserver(PawnObserver o) {
		// TODO Auto-generated method stub
		int i = observer.indexOf(o);
		if( i >= 0)
			observer.remove(0);
		
	}
	
	@Override
	public void notifyObserver() {
		// TODO Auto-generated method stub
		for(int i = 0; i < observer.size(); i++){
			PawnObserver po = observer.get(i);
			po.changeBoxPawn(actualyPosition);
		}
			
	}

	public int getStartId() {
		return startId;
	}

	public void setStartId(int startId) {
		this.startId = startId;
	}

	public int getCampId() {
		return campId;
	}

	public void setCampId(int campId) {
		this.campId = campId;
	}
	
	public int getActualyPosition() {
		return actualyPosition;
	}

	public void setActualyPosition(int actualyPosition) {
		this.actualyPosition = actualyPosition;
	}

	public Color getPawnColor() {
		return pawnColor;
	}

	public void setPawnColor(Color pawnColor) {
		this.pawnColor = pawnColor;
	}

	public boolean move(int movement){
		if(!canMove(movement)){
			targetPosition=actualyPosition - startId;
			targetPosition +=68;
			targetPosition -=2;
			targetPosition -=64;
			return true;
		}
		else{
		targetPosition = (actualyPosition + movement)%63;
		moveTo(targetPosition);
		return true;
		}
	}
	public boolean canMove(int movement){
		targetPosition = (actualyPosition + movement)%63;
		if(targetPosition > startId)
			return false;
		return true;
	}
	private void moveTo(int movement){
		actualyPosition = movement + actualyPosition;
		notifyObserver();
	}
	public void moveFromBase(int movement) {
		if (movement == 6) {
			 moveTo(startId);
		}
	}
}
