package com.ludo.app.view;

import java.util.ArrayList;

import com.ludo.app.control.ControlGameInterface;
import com.ludo.app.model.Pawn;
import com.ludo.app.observer.PawnObserver;

public class BoardGame implements PawnObserver{
	ArrayList<Pawn> pawn;
	public BoardGame(ArrayList<Pawn> pawn, ControlGameInterface control){
		
	}
	@Override
	public void changeBoxPawn(int position) {
		// TODO Auto-generated method stub
		
	}

}
