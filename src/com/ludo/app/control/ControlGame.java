package com.ludo.app.control;

import java.util.LinkedList;
import java.util.Random;

import com.ludo.app.model.BlueCamp;
import com.ludo.app.model.Camp;
import com.ludo.app.model.GreenCamp;
import com.ludo.app.model.Pawn;
import com.ludo.app.model.RedCamp;
import com.ludo.app.model.YellowCamp;
import com.ludo.app.view.BoardGame;


public class ControlGame implements ControlGameInterface{
	private LinkedList<Player> playerList = new LinkedList<Player>();
	private Player redPlayer;
	private Player yellowPlayer;
	private Player greenPlayer;
	private Player bluePlayer;
	
	private BoardGame view;
	
	public ControlGame(){
		
		view = new BoardGame(this);
	}
	@Override
	public void rollDice() {
		Random random = new Random();
		redPlayer.getPawns()[0].moveFromBase(6);
		redPlayer.getPawns()[0].move(62);
		redPlayer.getPawns()[0].move(1);


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
		playerList.add(greenPlayer);
		
	}
	@Override
	public void joinBluePlayer() {
		playerList.add(bluePlayer);
		
	}
	@Override
	public void joinYellowPlayer() {
		playerList.add(yellowPlayer);
		
	}

	private void addPawn(Player player){
		Pawn[] pawns = player.getPawns();
		for(int i = 0; i < pawns.length; i++){
			view.addPawn(pawns[i]);
			pawns[i].registerObserver(view);
		}
	}
	public Player createRedPlayer(){
		redPlayer = new HumanPlayer();
		redPlayer.setCamp(new RedCamp());
		addPawn(redPlayer);
		return redPlayer;
	}
	@Override
	public Player createYellowPlayer() {
		yellowPlayer = new HumanPlayer();
		yellowPlayer.setCamp(new YellowCamp());
		addPawn(yellowPlayer);
		return yellowPlayer;
	}
	@Override
	public Player createGreenPlayer() {
		greenPlayer = new HumanPlayer();
		greenPlayer.setCamp(new GreenCamp());
		addPawn(greenPlayer);
		return greenPlayer;
	}
	@Override
	public Player createBluePlayer() {
		bluePlayer = new HumanPlayer();
		bluePlayer.setCamp(new BlueCamp());
		addPawn(bluePlayer);
		return bluePlayer;
	}
}
