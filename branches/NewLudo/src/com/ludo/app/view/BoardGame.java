package com.ludo.app.view;

import java.util.ArrayList;

import javax.swing.Box;

import com.ludo.app.control.ControlGameInterface;
import com.ludo.app.model.Pawn;
import com.ludo.app.observer.PawnObserver;

public class BoardGame implements PawnObserver{
	ArrayList<Pawn> pawn;
	public BoardGame(ControlGameInterface control){
		
	}
	public void addPawn(Pawn p){
		pawn.add(p);
	}
	@Override
	public void changeBoxPawn(int position) {
		// TODO Auto-generated method stub
		for(int i = 0; i < pawn.size(); i++){
			Pawn p = pawn.get(i);
			//Box[position].add(p);
		}
	}

}
