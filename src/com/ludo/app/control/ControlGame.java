package com.ludo.app.control;

import com.ludo.app.view.BoardGame;
import com.ludo.app.view.LoginView;

public class ControlGame implements ControlGameInterface{

	private BoardGame boardGame;
	private LoginView loginView;
	public ControlGame(){
		boardGame = new BoardGame();
		loginView = new LoginView(this);
	}
	
	@Override
	public void singlePlayer() {
		// TODO Auto-generated method stub
		loginView.setVisible(false);
		boardGame.createView();
	}

	@Override
	public void multiPlayer() {
		// TODO Auto-generated method stub
		
		System.out.println(loginView.getText());
	}

}
