package com.ludo.lan.client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import com.ludo.lan.task.ThreadManager;

public class Client {

	public void connect(String ip){
		try {
			Socket clientSocket = new Socket(ip, 8125);
			ServerHandler serverHandler = new ServerHandler(clientSocket);
			ThreadManager.getInstance().execute(serverHandler);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
