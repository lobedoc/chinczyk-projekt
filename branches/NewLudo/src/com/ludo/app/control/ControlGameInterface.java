package com.ludo.app.control;


public interface ControlGameInterface {
	
	public void rollDice();
	public boolean playGame();
	
	public void joinRedPlayer();
	public void joinGreenPlayer();
	public void joinBluePlayer();
	public void joinYellowPlayer();
	
	public Player createRedPlayer();
	public Player createYellowPlayer();
	public Player createGreenPlayer();
	public Player createBluePlayer();
}
