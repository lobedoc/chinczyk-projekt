package com.ludo.app.control;

import java.awt.Color;

import com.ludo.app.view.board.BoardGame;
import com.ludo.game.other.HumanPlayer;
import com.ludo.game.other.Pawn;
import com.ludo.game.other.Player;
import com.ludo.game.other.RedCamp;

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
	@Override
	public void createRedPlayer(String name) {
		// TODO Auto-generated method stub
		Player player = new HumanPlayer(name, Color.RED);
		player.setPawnCamp(new RedCamp());
		Pawn[] redP = player.getPawns();
		for(int i = 0; i < redP.length; i++)
			boardView.addBox(redP[i].getCampId(), redP[i]);
		
	}

}
