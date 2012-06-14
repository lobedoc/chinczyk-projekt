package com.ludo.app.control;

import java.util.LinkedList;

import com.ludo.app.model.Camp;
import com.ludo.app.model.Pawn;
import com.ludo.app.model.RedCamp;
import com.ludo.app.view.BoardGame;


public class ControlGame implements ControlGameInterface{
	private LinkedList<Player> playerList = new LinkedList<Player>();
	private Player redPlayer;
	private Player yellowPlayer;
	private Player greenPlayer;
	private Player bluePlayer;
	
	private BoardGame view;
	
	public ControlGame(BoardGame view){
		
		view = new BoardGame(this);
	}
	@Override
	public void rollDice() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean playGame() {
		// TODO Auto-generated method 
		return false;
	}

	@Override
	public void joinRedPlayer() {
		playerList.add(redPlayer);
	}
	
	@Override
	public void joinGreenPlayer() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void joinBluePlayer() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void joinYellowPlayer() {
		// TODO Auto-generated method stub
		
	}

	private void addPawn(Player player){
		Pawn[] pawns = player.getPawns();
		for(int i = 0; i < pawns.length; i++){
			view.addPawn(pawns[i]);
		}
	}
	public Player createRedPlayer(){
		redPlayer = new HumanPlayer();
		redPlayer.setCamp(new RedCamp());
		addPawn(redPlayer);
		return redPlayer;
	}
}
