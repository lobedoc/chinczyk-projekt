package com.ludo.lan.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import com.ludo.app.control.Player;
import com.ludo.lan.head.Head;
import com.ludo.lan.head.HeadButton;
import com.ludo.lan.observer.ClientObserver;
import com.ludo.lan.observer.ClientSubject;
import com.ludo.lan.task.Task;

public class ClientHandler extends Task implements ClientSubject{
	
	private ArrayList<ClientObserver> observer = new ArrayList<ClientObserver>();
	private Socket socket;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	private Player player;
	private int i = 0;
	private Head head = new HeadButton();
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
		for(int i = 0; i < observer.size(); i++){
			ClientObserver co = observer.get(i);
			//co.updateGui();
		}
	}

	@Override
	protected void task() {
		// TODO Auto-generated method stub
		
		Head h;

		try {
			h = (Head) in.readObject();

			int value = h.getID();
			switch(value){
			
			case 0x1: 
				System.out.println("Kliknieto") ;
				head = (HeadButton)h;
				for(int i = 0; i < observer.size(); i++){
					ClientObserver co = observer.get(i);
					co.updateGui();
					}
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
	public void changeButton(){
		try {
			out.writeObject(head);
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
}
