package com.ludo.lan.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.ludo.lan.task.Task;

public class ServerHandler extends Task {

	private ObjectOutputStream out;
	private ObjectInputStream in;
	private Socket socket;
	
	public ServerHandler(Socket socket){
		this.socket = socket;
		

	}
	
	@Override
	protected void task() {
		// TODO Auto-generated method stub
		
		
	
		
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
