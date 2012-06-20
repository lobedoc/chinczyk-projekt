package com.ludo.lan.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import com.ludo.app.control.Player;
import com.ludo.lan.head.Head;
import com.ludo.lan.head.HeadConst;
import com.ludo.lan.head.PawnHead;
import com.ludo.lan.head.PlayerHead;

import com.ludo.lan.observer.ServerObserver;
import com.ludo.lan.observer.ServerSubject;
import com.ludo.lan.task.Task;

public class ServerHandler extends Task implements ServerSubject{

	private ObjectOutputStream out;
	private ObjectInputStream in;
	private Socket socket;
	
	private Head headPlayer;
	private Head headPawn;

	
	private ArrayList<ServerObserver> observer = new ArrayList<ServerObserver>();
	public ServerHandler(Socket socket){
		this.socket = socket;

	}
	

	@Override
	protected void task() {
		// TODO Auto-generated method stub
		Head h;
		try {
			h = (Head) in.readObject();
			int value = h.getID();
			switch(value){	
			case HeadConst.PLAYER: 
				Player p = (Player) h.getObject();
				p.getColor(); p.getPawns();
				addPlayer(p.getColor());
				break;
			case HeadConst.PAWN:
				Player pawn = (Player) h.getObject();
				pawnIncoming(pawn);
				break;
		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
		
	}
	private void pawnIncoming(Player p){
		int p0 = p.getPawnPosition(0);
		int l0 = p.getPawnLastPosition(0);
		int p1 = p.getPawnPosition(1);
		int l1 = p.getPawnLastPosition(1);
		int p2 = p.getPawnPosition(2);
		int l2 = p.getPawnLastPosition(2);
		int p3 = p.getPawnPosition(3);
		int l3 = p.getPawnLastPosition(3);
		changePawns(p.getColor(), p0, p1, p2, p3, l0, l1, l2, l3);
	}
	public void changePawns(int player, int p0, int p1, int p2, int p3, int l0, int l1, int l2, int l3){
		for(ServerObserver ob : observer)
			ob.updatePawn(player, p0, p1, p2, p3, l0, l1, l2, l3);
	}
	@Override
	protected void taskStream() {
		try {
			out = new ObjectOutputStream(socket.getOutputStream());
			in = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void registerObserver(ServerObserver o) {
		// TODO Auto-generated method stub
		observer.add(o);
	}
	
	public void sendPlayer(Player player){
		try {
			if(headPlayer == null){
				headPlayer = new PlayerHead();
				headPlayer.setObject(player);
			}
			else{
			headPlayer.setObject(player);
			}
			out.writeObject(headPlayer);
			out.flush();
			out.reset();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void notifyObserver() {
		// TODO Auto-generated method stub

		
	}
	public void sendPawn(Player player){
		int c = player.getColor();
		if(headPawn == null){
			headPawn = new PawnHead();
			headPawn.setObject(player);
		}
		else{
			headPawn.setObject(player);
		}
		try {
			out.writeObject(headPawn);
			out.flush();
			out.reset();
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void addPlayer(int color){
		for(ServerObserver ob : observer)
			ob.updatePlayerList(color);
	}
}
