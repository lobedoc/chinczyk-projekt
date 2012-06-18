package com.ludo.lan.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import com.ludo.app.control.Player;
import com.ludo.lan.head.BluePlayerHead;
import com.ludo.lan.head.GreenPlayerHead;
import com.ludo.lan.head.Head;
import com.ludo.lan.head.HeadConst;
import com.ludo.lan.head.RedPlayerHead;
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
			
			case HeadConst.redPlayer | HeadConst.greenPlayer | HeadConst.bluePlayer | HeadConst.yellowPlayer: 
				Player p = (Player) h.getObject();
				addPlayer(p);
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
	
	public void sendRedPlayer(Player player){
		redPlayer.setObject(player);
		try {
			out.writeObject(redPlayer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void sendBluePlayer(Player player){
		bluePlayer.setObject(player);
		try {
			out.writeObject(bluePlayer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void sendGreenPlayer(Player player){
		greenPlayer.setObject(player);
		try {
			out.writeObject(greenPlayer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void sendYellowPlayer(Player player){
		yellowPlayer.setObject(player);
		try {
			out.writeObject(yellowPlayer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void notifyObserver() {
		// TODO Auto-generated method stub

		
	}
	
	public void addPlayer(Player p){
		for( ServerObserver ob : observer)
			ob.updatePlayerList(p);
	}
}
