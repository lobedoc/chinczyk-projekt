package com.ludo.lan.client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public void connect(String ip){
		try {
			Socket clientSocket = new Socket(ip, 8125);
			ServerHandler serverHandler = new ServerHandler(clientSocket);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
