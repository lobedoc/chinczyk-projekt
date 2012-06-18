package com.ludo.app.control;

import com.ludo.lan.client.ServerHandler;
import com.ludo.lan.observer.ServerObserver;

public class HumanPlayer extends Player{
	
	private ServerHandler handler;
	public HumanPlayer(){
		super();
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
	

}
