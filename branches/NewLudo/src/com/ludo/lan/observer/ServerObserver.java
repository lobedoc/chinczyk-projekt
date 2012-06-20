package com.ludo.lan.observer;

import com.ludo.app.control.Player;
import com.ludo.app.model.Pawn;

public interface ServerObserver {
	
	public void updatePlayerList(int color);
	public void updatePawn(int player, int p0, int p1, int p2, int p3);
}
