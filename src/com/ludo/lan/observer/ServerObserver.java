package com.ludo.lan.observer;

import com.ludo.app.control.Player;

public interface ServerObserver {
	
	public void updatePlayerList(Player incomingPlayer);
}
