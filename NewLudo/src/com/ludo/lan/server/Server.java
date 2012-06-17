package com.ludo.lan.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.ludo.lan.control.GameControl;
import com.ludo.lan.control.TCPGameControl;
import com.ludo.lan.task.Task;

public class Server extends Task{
	private ServerSocket serverSocket;
	private GameControl gameControl = new TCPGameControl();
	public Server(){
			try {
				serverSocket = new ServerSocket(8125);
				System.out.println("Odpalono serwer");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

	@Override
	protected void task() {
		// TODO Auto-generated method stub
		try {
			Socket in = serverSocket.accept();
			ClientHandler handler = new ClientHandler(in);
			gameControl.addClient(handler);
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
