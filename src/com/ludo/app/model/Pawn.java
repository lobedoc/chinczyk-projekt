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
	
	private int actualPosition;
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
			po.changeBoxPawn(actualPosition);
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
	
	public int getActualPosition() {
		return actualPosition;
	}

	public void setActualPosition(int actualPosition) {
		this.actualPosition = actualPosition;
	}

	public Color getPawnColor() {
		return pawnColor;
	}

	public void setPawnColor(Color pawnColor) {
		this.pawnColor = pawnColor;
	}

}
