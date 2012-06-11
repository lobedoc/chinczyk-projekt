package com.ludo.game.board;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.ludo.game.other.Pawn;

public abstract class Box extends JPanel{

	protected int id;
	protected Color colorBox;
	public Box(){
		this.setLayout(new FlowLayout());
	}
	
	public void addPawn(Pawn pawn){
		pawn.setBlockId(id);
		this.removeAll();
		this.add(pawn);
	}
	@Override
	protected void paintComponent(Graphics g){
		g.setColor(colorBox);
		g.fillRect(0, 0, 50, 50);
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, 50, 50);
	}
	
	
}
