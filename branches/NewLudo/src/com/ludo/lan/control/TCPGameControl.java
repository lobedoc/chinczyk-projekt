package com.ludo.lan.control;


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.ludo.app.control.Player;
import com.ludo.app.model.Pawn;
import com.ludo.app.view.lan.JoinHost;
import com.ludo.lan.observer.ClientObserver;
import com.ludo.lan.server.ClientHandler;
import com.ludo.lan.task.ThreadManager;

public class TCPGameControl implements GameControl, ClientObserver{
	private List<ClientHandler> clientList = Collections.synchronizedList(new LinkedList<ClientHandler>());
	public TCPGameControl(){
	}
	public void addClient(ClientHandler handler) {
		// TODO Auto-generated method stub
		handler.registerObserver(this);
		clientList.add(handler);
		ThreadManager.getInstance().execute(handler);
		System.out.println("Ilosc klientow: " + clientList.size());
		
	}
	@Override
	public void joinPlayer(Player player) {
		// TODO Auto-generated method stub
		for(ClientHandler handler : clientList)
			handler.addPlayer(player);
	}
	@Override
	public void changePawn(Player p) {
		// TODO Auto-generated method stub
		for(ClientHandler handler : clientList)
			handler.sendPawn(p);
	}
	
	
	
	}
	
	
