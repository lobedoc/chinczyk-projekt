package com.ludo.game.board;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.ludo.game.other.Pawn;

public abstract class Box extends JPanel{

	protected int id;
	protected Color colorBox;
	public Box(){
		this.setLayout(new FlowLayout());
		this.setMinimumSize(getBoxSize());
		this.setMaximumSize(getBoxSize());
		this.setPreferredSize(getBoxSize());
	}
	
	public void addPawn(Pawn pawn){
		pawn.setBlockId(id);
		this.add(pawn);
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
