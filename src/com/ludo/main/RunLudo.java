package com.ludo.main;

import java.awt.Color;

import com.ludo.game.board.BlueBox;
import com.ludo.game.board.Box;
import com.ludo.game.board.WhiteBox;
import com.ludo.game.board.YellowBox;
import com.ludo.game.other.Cube;
import com.ludo.game.other.HumanPlayer;
import com.ludo.game.other.Player;
import com.ludo.game.other.SixCube;

public class RunLudo {

	/**
	 * @param args
	 */
	/* liczenie krokow
	 * (id startowe + rzut kostka) % max id
	 * np (60 + 6) % 64 = 2 (jestem na id = 60, 6 na kostce wyrzucone ide na 2 pole)
	 * 
	 * wejscie do domku dla czerwonego
	 * stoi na polu 15 rzuca 4
	 * 15+4 = 19 przekroczenie domku
	 * 15 - 17 = -2
	 * -2 + 64 = 62 // 64 ilosc pol
	 * 62 + 4 = 66 // 4 wejscia do domku
	 * 66 - 64 = 2 // 2 miejsce w tabeli koncowych domkow
	 * tabela domku koncowego dla czerwonego
	 * int[] campRed = {85, 86, 87, 88};
	 * campRed[2] = 87; stawiamy pionek na 87 pole
	 */
	public static void main(String[] args) {
		Box[] box = new Box[100];
		
		for(int i = 0; i < box.length; i++){
			if(i%2 == 0)
				box[i] = new BlueBox();
			else if(i%3 == 0)
				box[i] = new YellowBox();
			else
				box[i] = new WhiteBox();
		}
		
		for(int i = 0; i < box.length; i++){
			Color c = box[i].getBoxColor();
			String name = "Kolor";
			if(Color.BLUE.equals(c))
				name = "Niebieski";
			if(Color.WHITE.equals(c))
				name = "Biały";
			if(Color.YELLOW.equals(c))
				name = "Żółty";
			
			System.out.println(box[i].getBoxId() + " " + name);
		}

	}

}
