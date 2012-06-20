package com.ludo.lan.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import com.ludo.app.control.Player;
import com.ludo.app.model.Pawn;
import com.ludo.lan.head.CurrentRoundHead;
import com.ludo.lan.head.Head;
import com.ludo.lan.head.HeadConst;
import com.ludo.lan.head.PawnHead;
import com.ludo.lan.head.PlayerHead;
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
			switch(value){

			case HeadConst.PLAYER: 
				Player player = (Player) h.getObject();
				System.out.println("Przyszedl player");
				joinPlayer(player);
				break;
			case HeadConst.PAWN:
				Player pawn = (Player) h.getObject();
				changePawn(pawn);
				break;
			case HeadConst.CURRENT:
				int j = (Integer) h.getObject();
				currentRound(j);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
	}
	private void clearSocket() throws IOException{
		out.flush();
		out.reset();
	}
	public void changePawn(Player p){
		for(ClientObserver ob: observer)
			ob.changePawn(p);
	}
	public void joinPlayer(Player p){
		for(ClientObserver ob: observer)
			ob.joinPlayer(p);
	}
	public void currentRound(int i){
		for(ClientObserver ob: observer)
			ob.sendCurrentRound(i);
	}
	public void sendCurrentRound(int i){
		i = i+1;
		if(i > 4)
			i = 1;
		try {
			Head currentHead = new CurrentRoundHead();
			currentHead.setObject(i);
			out.writeObject(currentHead);
			clearSocket();
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
	public void addPlayer(Player p){
		try{
			Head playerHead = new PlayerHead();
			playerHead.setObject(p);
			out.writeObject(playerHead);
			clearSocket();
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
			Head h = new PawnHead();
			h.setObject(p);
			out.writeObject(h);
			clearSocket();
			} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
