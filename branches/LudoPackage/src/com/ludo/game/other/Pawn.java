package com.ludo.game.other;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.io.Serializable;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class Pawn extends JPanel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6728120083942141197L;
	private int startId; //pozycja startowa danego pionka
	private int campId;
	private Color colorPawn;
	private int actualyPosition = 0;
	private int targetPosition = 0;
	
	public Pawn(){
		this.setMinimumSize(new Dimension(15,15));
		this.setPreferredSize(new Dimension(15,15));
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
	public void setColorPawn(Color color){
		this.colorPawn = color;
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
	public void paintComponent(Graphics g){
		 Graphics2D g2 = (Graphics2D)g;
		 g2.setColor(colorPawn);
		 Shape circle = new Ellipse2D.Double(0,0,15,15);

		 g2.fill(circle);
		 g2.setColor(Color.BLACK);
		 g2.draw(circle);
	}
}
