package com.ludo.app.control;

import com.ludo.app.view.board.BoardGame;
import com.ludo.game.other.Pawn;

public class BoardControl implements BoardControlInterface{

	private BoardGame boardView;
	
	public BoardControl(){
		boardView = new BoardGame(this);
		boardView.createView();
	}
	@Override
	public void rollDice() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void movePawn() {
		// TODO Auto-generated method stub
		
	}

}
