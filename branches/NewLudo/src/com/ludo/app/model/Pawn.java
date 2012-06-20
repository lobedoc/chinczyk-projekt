package com.ludo.app.model;

import java.io.Serializable;
import java.util.ArrayList;
import com.ludo.app.observer.PawnObserver;
import com.ludo.app.observer.PawnSubject;

public class Pawn implements PawnSubject, Serializable{
	
	private transient ArrayList<PawnObserver> observer = new ArrayList<PawnObserver>();
	
	private int startId;
	private int campId;
	private int[] houseLocation;
	private String path;
	private int actualyPosition;
	private int targetPosition;
	private int lastPosition;
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
			observer.remove(o);
		
	}
	
	@Override
	public void notifyObserver() {
		// TODO Auto-generated method stub
		for(int i = 0; i < observer.size(); i++){
			PawnObserver po = observer.get(i);
			po.changeBoxPawn();
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

	public int[] getHouseLocation() {
		return houseLocation;
	}

	public void setHouseLocation(int[] houseLocation) {
		this.houseLocation = houseLocation;
	}
	
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public boolean move(int movement){
		if(!canMove(movement)){
			targetPosition = (actualyPosition + movement)%63;
			targetPosition-= startId;
			
			if(targetPosition >4)return false;
			else{
			int a=houseLocation[targetPosition];
			moveTo(a);
			return true;}
		}
		else{
		targetPosition = (actualyPosition + movement)%63;
		moveTo(targetPosition);
		return true;
		}
	}
	public boolean canMove(int movement){
		targetPosition = (actualyPosition + movement)%63;
		if(actualyPosition < startId){
			targetPosition = (actualyPosition + movement)%63;
			if(targetPosition >= startId)
			return false;}
		return true;
	}
	private void moveTo(int movement){
		lastPosition = actualyPosition;
		actualyPosition = movement;
		notifyObserver();
	}
	public void setPosition(){
		notifyObserver();
	}
	public void moveFromBase(int movement) {
		if (movement == 6) {
			 actualyPosition = startId;
			 notifyObserver();
		}
	}
	public int getLastPosition(){
		return lastPosition;
	}
}
