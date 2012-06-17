package com.ludo.app.run;

import com.ludo.app.control.ControlGame;
import com.ludo.app.control.ControlGameInterface;
import com.ludo.app.view.BoardGame;
import com.ludo.app.view.lan.JoinHost;
import com.ludo.lan.control.GameControl;
import com.ludo.lan.control.TCPGameControl;

public class RunLudo {
	
	public static void main(String args[]){
		//ControlGameInterface game = new ControlGame();
		//game.createRedPlayer();
		//game.rollDice();
		/*JoinHost h = new JoinHost();
		h.setVisible(true);*/
		BoardGame game = new BoardGame();
		game.createView();
		
	}
}
