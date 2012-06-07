package com.ludo.main;

import java.awt.Color;

import com.ludo.game.other.Cube;
import com.ludo.game.other.HumanPlayer;
import com.ludo.game.other.Player;
import com.ludo.game.other.SixCube;

public class RunLudo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Cube cube = new SixCube();
		Player player1 = new HumanPlayer(cube);
		Player player2 = new HumanPlayer(cube);
		player1.setPlayerName("Gracz1");
		player2.setPlayerName("Gracz2");
		player1.setPlayerColor(Color.GREEN);
		player1.setPlayerColor(Color.BLACK);

	}

}
