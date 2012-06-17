package com.ludo.lan.observer;

import com.ludo.app.control.Player;

public interface ServerObserver {
	
	public void updatePawn(Player player);
	public void updateRedButton(Player player);
}
