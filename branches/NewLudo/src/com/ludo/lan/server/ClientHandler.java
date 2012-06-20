package com.ludo.lan.server;

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
import com.ludo.lan.observer.ClientObserver;
import com.ludo.lan.observer.ClientSubject;
import com.ludo.lan.task.Task;

public class ClientHandler extends Task implements ClientSubject{
	
	private ArrayList<ClientObserver> observer = new ArrayList<ClientObserver>();
	private Socket socket;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	public ClientHandler(Socket socket){
		this.socket = socket;
	}
	
	@Override
	public void registerObserver(ClientObserver o) {
		// TODO Auto-generated method stub
		observer.add(o);
		
	}

	@Override
	public void notifyObserver() {
		// TODO Auto-generated method stub
		}

	@Override
	protected void task() {
		// TODO Auto-generated method stub
		
		Head h;

		try {
			h = (Head) in.readObject();

			int value = h.getID();			
			Player p;
			switch(value){

			case HeadConst.redPlayer: 
				p = (Player) h.getObject();
				System.out.println("Przyszedl player");
				notifyyy(p);
				break;
			case HeadConst.bluePlayer: 
				p = (Player) h.getObject();
				System.out.println("Przyszedl player");
				notifyyy(p);
				break;
			case HeadConst.yellowPlayer: 
				System.out.println("Przyszedl player");
				p = (Player) h.getObject();
				notifyyy(p);
				break;
			case HeadConst.greenPlayer: 
				System.out.println("Przyszedl player");
				p = (Player) h.getObject();
				notifyyy(p);
				break;
			case HeadConst.yellowPawn:
				p = (Player) h.getObject();
				changePawn(p);
				System.out.println("Przyszedl pionek");
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
	}
	public void changePawn(Player p){
		for(ClientObserver ob: observer)
			ob.changePawn(p);
	}
	public void notifyyy(Player p){
		for(ClientObserver ob: observer)
			ob.joinPlayer(p);
	}
	public void addPlayer(Player p){
		try {
			Head h = new RedPlayerHead();
			int c = p.getColor();
			switch(c){
			case 1:
				h = new YellowPlayerHead();
				break;
			case 2:
				h = new RedPlayerHead();
				break;
			case 3:
				h = new GreenPlayerHead();
				break;
			case 4:
				h = new BluePlayerHead();
				break;
			}
			h.setObject(p);
			out.writeObject(h);
			out.flush();
			out.reset();
		} catch (IOException e) {
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

	public void sendPawn(Player p) {
		// TODO Auto-generated method stub
		try {
			Head h = new YellowPawnHead();
			h.setObject(p);
			out.writeObject(h);
			out.flush();
			out.reset();
			} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
