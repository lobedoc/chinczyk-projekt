package com.ludo.app.view.lan;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.ludo.app.control.Player;
import com.ludo.app.view.BoardGame;
import com.ludo.lan.client.Client;
import com.ludo.lan.client.ServerHandler;
import com.ludo.lan.control.GameControl;
import com.ludo.lan.observer.ServerObserver;
import com.ludo.lan.server.Server;
import com.ludo.lan.task.ThreadManager;

// usunieta bedzie ta klasa 
public class JoinHost extends JFrame implements ActionListener{

	private JButton host;
	private JButton connect;
	private JButton testowy;
	private ServerHandler handler;
	private ImageIcon serwerIcon,connectIcon;
	public JoinHost(){
		this.setMinimumSize(new Dimension(200,200));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		serwerIcon = new ImageIcon("src/com/ludo/app/resources/images/serwer.jpg");
		connectIcon = new ImageIcon("src/com/ludo/app/resources/images/connect.jpg");
		host = new JButton(serwerIcon);
		connect = new JButton(connectIcon);
		host.addActionListener(this);
		testowy = new JButton("Testowy");
		connect.addActionListener(this);
		testowy.addActionListener(this);
		this.setLayout(new BorderLayout());
		this.add(flowPanel(), BorderLayout.CENTER);
	}
	private JPanel flowPanel(){
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.add(host);
		panel.add(connect);
		panel.add(testowy);
		return panel;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == host){
			Server server = new Server();
			ThreadManager.getInstance().execute(server);
			host.setEnabled(false);
		}
		if(e.getSource() == connect){
			Client client = new Client();
			client.connect("62.108.173.153");
			handler = client.getHandler();
		}
		if(e.getSource() == testowy){
			BoardGame boardGame = new BoardGame();
			boardGame.createView();
			boardGame.setHandler(handler);
		}
	
	}

}
