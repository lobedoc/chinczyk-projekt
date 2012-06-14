package com.ludo.app.run;

import com.ludo.app.control.ControlGame;
import com.ludo.app.control.ControlGameInterface;
import com.ludo.app.view.BoardGame;

public class RunLudo {
	
	public static void main(String args[]){
		ControlGameInterface game = new ControlGame();
		game.createRedPlayer();
		game.rollDice();
	}
}
