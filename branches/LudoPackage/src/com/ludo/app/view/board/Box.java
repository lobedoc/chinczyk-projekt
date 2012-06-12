package com.ludo.app.view.board;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.ludo.game.other.Pawn;

public abstract class Box extends JPanel{

	private int id;
	private static int idStatic = 1;
	protected Color colorBox;
	public Box(){
		id = idStatic;
		idStatic++;
		this.setLayout(new FlowLayout());
		this.setMinimumSize(getBoxSize());
		this.setMaximumSize(getBoxSize());
		this.setPreferredSize(getBoxSize());
	}
	
	public void addPawn(Pawn pawn){
		pawn.setBlockId(id);
		this.add(pawn);
	}
	
	public int getBoxId(){
		return id;
	}
	public Color getBoxColor(){
		return colorBox;
	}
	private Dimension getBoxSize(){
		return new Dimension(50,50);
	}
	@Override
	protected void paintComponent(Graphics g){
		g.setColor(colorBox);
		g.fillRect(0, 0, 50, 50);
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, 50, 50);
	}
	
	
}
