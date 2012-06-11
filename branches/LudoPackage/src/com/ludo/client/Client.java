package com.ludo.client;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

import com.ludo.game.other.Player;

public class Client {

	public Client(){
		
	}
	
	public void connect(InetAddress add, int port){
		try {
			Socket socket = new Socket(add,port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
