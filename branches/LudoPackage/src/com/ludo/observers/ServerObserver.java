package com.ludo.observers;

import com.ludo.game.other.Player;

public interface ServerObserver {

	public void updatePawn(Player player);
	public void updateGameStarting();
	public void updateGameEnding();
}
