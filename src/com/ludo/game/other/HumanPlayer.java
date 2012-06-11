package com.ludo.game.other;

import java.awt.Color;

import com.ludo.observers.ServerObserver;

public class HumanPlayer extends Player implements ServerObserver{

	public HumanPlayer(String name, Color color) {
		super(name,color);
		
	}

	@Override
	public void updatePawn(Player player) {
		this.pawn = player.getPawns();
		
	}

	@Override
	public void updateGameStarting() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateGameEnding() {
		// TODO Auto-generated method stub
		
	}

}
