package com.ludo.app.view.board.box;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.util.ArrayDeque;

import javax.swing.JPanel;

import com.ludo.game.other.Pawn;

public abstract class Box extends JPanel{

	private int id;
	private static int idStatic = 0;
	protected Color colorBox;
	private Pawn pawnLast;
	private ArrayDeque<Pawn> arrayPawn = new ArrayDeque<Pawn>();
	public Box(){
		id = idStatic;
		idStatic++;
		this.setLayout(new FlowLayout());
		this.setMinimumSize(getBoxSize());
		this.setMaximumSize(getBoxSize());
		this.setPreferredSize(getBoxSize());
	}
	
	public Pawn addPawn(Pawn pawn){
		pawnLast = arrayPawn.pollLast();
		arrayPawn.addFirst(pawn);
		pawn.setActualyPosition(id);
		this.add(pawn);
		return pawnLast;
	}
	
	public int getBoxId(){
		return id;
	}
	public Color getBoxColor(){
		return colorBox;
	}
	private Dimension getBoxSize(){
		return new Dimension(30,30);
	}
	@Override
	protected void paintComponent(Graphics g){
		g.setColor(colorBox);
		g.fillRect(0, 0, 30, 30);
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, 30, 30);
	}
	
	
}
