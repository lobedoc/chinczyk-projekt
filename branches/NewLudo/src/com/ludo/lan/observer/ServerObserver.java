package com.ludo.lan.observer;

import com.ludo.app.control.Player;
import com.ludo.app.model.Pawn;

public interface ServerObserver {
	
	public void updatePlayerList(int color, String name);
	public void updatePawn(int player, int p0, int p1, int p2, int p3, 
			int l0, int l1, int l2, int l3);
	
	public void currentRound(int i);
	public void updateMsg(String msg);
	public void updateGame();
}
