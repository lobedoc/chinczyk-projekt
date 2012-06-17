package com.ludo.app.run;

import java.util.ResourceBundle.Control;

import com.ludo.app.control.ControlGame;
import com.ludo.app.control.ControlGameInterface;
import com.ludo.app.view.BoardGame;
import com.ludo.app.view.lan.JoinHost;
import com.ludo.lan.client.Client;
import com.ludo.lan.client.ServerHandler;
import com.ludo.lan.control.GameControl;
import com.ludo.lan.control.TCPGameControl;
import com.ludo.lan.server.Server;

public class RunLudo {
	
	public static void main(String args[]){
		//ControlGameInterface game = new ControlGame();
		//game.createRedPlayer();
		//game.rollDice();
		JoinHost h = new JoinHost();
		h.setVisible(true);
		//ControlGameInterface game = new ControlGame();

	}
}
