package com.ludo.lan.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import com.ludo.app.control.Player;
import com.ludo.app.model.Pawn;
import com.ludo.lan.head.BluePlayerHead;
import com.ludo.lan.head.GreenPlayerHead;
import com.ludo.lan.head.Head;
import com.ludo.lan.head.HeadConst;
import com.ludo.lan.head.RedPlayerHead;
import com.ludo.lan.head.YellowPawnHead;
import com.ludo.lan.head.YellowPlayerHead;

import com.ludo.lan.observer.ServerObserver;
import com.ludo.lan.observer.ServerSubject;
import com.ludo.lan.task.Task;

public class ServerHandler extends Task implements ServerSubject{

	private ObjectOutputStream out;
	private ObjectInputStream in;
	private Socket socket;
	private Head redPlayer = new RedPlayerHead();
	private Head yellowPlayer = new YellowPlayerHead();
	private Head greenPlayer = new GreenPlayerHead();
	private Head bluePlayer = new BluePlayerHead();
	
	private Head yellowPawn = new YellowPawnHead();
	
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
			Player p;
			
			//System.out.println("Przyszedł player: " + "Pozycja pionka 0: " + p.getPawnPosition(0) +  " Pozycja pionka 1: " + p.getPawnPosition(1));
			switch(value){	
			case HeadConst.redPlayer: 
				 p = (Player) h.getObject();
				 p.getColor(); p.getPawns();
				//addPlayer(p);
				System.out.println("Color playera: " + p.getColor());
				break;
			case HeadConst.bluePlayer: 
				 p = (Player) h.getObject();
				//addPlayer(p);
				System.out.println("Color playera: " + p.getColor());
				break;
			case HeadConst.yellowPlayer: 
				 p = (Player) h.getObject();
				addPlayer(p.getColor());
				System.out.println("Color playera: " + p.getColor());
				break;
			case HeadConst.greenPlayer: 
				 p = (Player) h.getObject();
				//addPlayer(p);
				System.out.println("Color playera: " + p.getColor());
				break;
			case HeadConst.yellowPawn:
				p = (Player) h.getObject();
				changePawns(p.getColor(), p.getPawnPosition(0), p.getPawnPosition(1), p.getPawnPosition(2), p.getPawnPosition(3));
				//System.out.println("Przyszedl pionek klient " + pawn.getActualyPosition());
		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
		
	}
	public void changePawns(int player, int p0, int p1, int p2, int p3){
		for(ServerObserver ob : observer)
			ob.updatePawn(player, p0, p1, p2, p3);
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
		int c = player.getColor();
		try {
			switch(c){
			case 1: yellowPlayer.setObject(player);
				out.writeObject(yellowPlayer);
				
				break;
			case 2: redPlayer.setObject(player);
				out.writeObject(redPlayer);
				break;
			case 3: greenPlayer.setObject(player);
				out.writeObject(greenPlayer);
				break;
			case 4: bluePlayer.setObject(player);
				out.writeObject(bluePlayer);
				break;
			}
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
		switch(c){
		case 1: yellowPawn.setObject(player);
		}
		try {
			out.writeObject(yellowPawn);
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
