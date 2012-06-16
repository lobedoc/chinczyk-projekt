package com.ludo.app.view.lan;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.ludo.lan.client.Client;
import com.ludo.lan.client.ServerHandler;
import com.ludo.lan.observer.ServerObserver;
import com.ludo.lan.server.Server;
import com.ludo.lan.task.ThreadManager;

// usunieta bedzie ta klasa 
public class JoinHost extends JFrame implements ActionListener, ServerObserver{

	private JButton host;
	private JButton connect;
	private JButton testowy;
	private ServerHandler handler;
	private Client client;
	public JoinHost(){
		this.setMinimumSize(new Dimension(200,100));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		host = new JButton("Hostuj");
		connect = new JButton("Polacz");
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
			client = new Client();
			client.connect("62.108.173.153");
			handler = client.getHandler();
			handler.registerObserver(this);
		}
		if(e.getSource() == testowy){
			testowy.setEnabled(false);
			handler.sendButtonValue(testowy.isEnabled());
		}
	}
	@Override
	public void setButtonValue(boolean e) {
		// TODO Auto-generated method stub
		testowy.setEnabled(e);
		
	}
}
