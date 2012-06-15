package com.ludo.lan.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.ludo.lan.task.Task;

public class Server extends Task{

	private ServerSocket serverSocket;
	
	public Server(){
			try {
				serverSocket = new ServerSocket(8125);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

	@Override
	public void task() {
		// TODO Auto-generated method stub
		try {
			Socket in = serverSocket.accept();
			ClientHandler handler = new ClientHandler(in);
			
			Thread.sleep(2000);
		}
		catch (InterruptedException e) {
				e.printStackTrace();
			}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
