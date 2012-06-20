package com.ludo.lan.observer;


import com.ludo.app.control.Player;
import com.ludo.app.model.Pawn;

public interface ClientObserver {
	
	public void joinPlayer(Player player);
	public void changePawn(Player p);
	public void sendCurrentRound(int i);
}
