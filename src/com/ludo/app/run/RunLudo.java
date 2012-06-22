package com.ludo.app.run;


import com.ludo.app.view.MainWindow;
import com.ludo.app.view.lan.JoinHost;

public class RunLudo {
	
	public static void main(String args[]){
		//ControlGameInterface game = new ControlGame();
		//game.createRedPlayer();
		//game.rollDice();
		//JoinHost h = new JoinHost();
		//h.setVisible(true);
		//ControlGameInterface game = new ControlGame();
		try {	
	        javax.swing.SwingUtilities.invokeAndWait(new Runnable() {
	            public void run() {
	            	MainWindow main = new MainWindow();
	            }
	        });	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
