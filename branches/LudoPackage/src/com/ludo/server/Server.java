package com.ludo.server;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {

	private ServerSocket socket;
	
	public Server(int port){
		try {
			socket = new ServerSocket(port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
