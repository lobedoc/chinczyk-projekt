package com.ludo.main;

import java.awt.Color;


import com.ludo.app.control.BoardControl;
import com.ludo.app.control.BoardControlInterface;
import com.ludo.app.view.board.box.*;
import com.ludo.app.view.login.LoginView;


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
	
		BoardControlInterface create = new BoardControl();
		//LoginView v = new LoginView();
		//v.setVisible(true);
	}

}
