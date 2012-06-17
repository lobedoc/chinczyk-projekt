package com.ludo.app.control;

import com.ludo.lan.client.ServerHandler;
import com.ludo.lan.observer.ServerObserver;

public class HumanPlayer extends Player implements ServerObserver{
	
	private ServerHandler handler;
	public HumanPlayer(){
		super();
	}
	
	@Override
	public void updatePawn(Player player) {
		// TODO Auto-generated method stub
		this.pawnPlayer = player.getPawns();
	}

	public ServerHandler getHandler() {
		return handler;
	}

	public void setHandler(ServerHandler handler) {
		this.handler = handler;
	}

	@Override
	public void sendReady() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateRedButton() {
		// TODO Auto-generated method stub
		
	}
	

}
