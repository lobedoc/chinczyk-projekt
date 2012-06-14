package com.ludo.app.view;

import java.util.ArrayList;

import javax.swing.Box;

import com.ludo.app.control.ControlGameInterface;
import com.ludo.app.model.Pawn;
import com.ludo.app.observer.PawnObserver;

public class BoardGame implements PawnObserver{
	private ArrayList<Pawn> pawns;
	public BoardGame(ControlGameInterface control){
		pawns = new ArrayList<Pawn>();
	}
	public void addPawn(Pawn p){
		pawns.add(p);
	}
	@Override
	public void changeBoxPawn(int position) {
		// TODO Auto-generated method stub
		for(int i = 0; i < pawns.size(); i++){
			Pawn p = pawns.get(i);
			System.out.println("Aktualna pozycja: " + p.getActualyPosition() + " kolor pionka: " + p.getPawnColor());
			//Box[position].add(p);
		}
	}

}
