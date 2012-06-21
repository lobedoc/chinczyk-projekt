package com.ludo.app.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.ludo.app.view.lan.JoinHost;
import com.ludo.lan.client.Client;
import com.ludo.lan.client.ServerHandler;
import com.ludo.lan.server.Server;
import com.ludo.lan.task.ThreadManager;

public class MainWindow extends JFrame implements ActionListener {

	private JButton singlePlayerButton,multiPlayerButton,exitButton,infoButton;
	private ImageIcon singleIcon,multiIcon,exitIcon,infoIcon;
	private ServerHandler handler;
	public MainWindow(){
		singleIcon = new ImageIcon("src/com/ludo/app/resources/images/singleplayer.jpg");
		multiIcon = new ImageIcon("src/com/ludo/app/resources/images/multiplayer.jpg");
		exitIcon = new ImageIcon("src/com/ludo/app/resources/images/close.jpg");
		infoIcon = new ImageIcon("src/com/ludo/app/resources/images/info.jpg");
		singlePlayerButton = new JButton(singleIcon);
		multiPlayerButton = new JButton(multiIcon);
		infoButton = new JButton(infoIcon);
		infoButton.addActionListener(this);
		multiPlayerButton.addActionListener(this);
		exitButton = new JButton(exitIcon);
		exitButton.addActionListener(this);
		singlePlayerButton.addActionListener(this);
		JPanel imagePanel = new ImagePanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setMinimumSize(new Dimension(575,453));
        this.setLayout(new BorderLayout());
        GridBagLayout layout = new GridBagLayout();
        imagePanel.setOpaque(true);
        imagePanel.setLayout(layout);
        imagePanel.add(flowPanel());
		this.add(imagePanel);
	}
	
	private JPanel flowPanel(){
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4,1));
		panel.add(singlePlayerButton);
		panel.add(multiPlayerButton);
		panel.add(exitButton);
		panel.add(infoButton);
		return panel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == singlePlayerButton){
			Server server = new Server();
			ThreadManager.getInstance().execute(server);
			Client client = new Client();
			client.connect("localhost");
			handler = client.getHandler();
			BoardGame boardGame = new BoardGame();
			boardGame.createView();
			boardGame.setHandler(handler);
		}
		if(e.getSource() == multiPlayerButton){
			JoinHost h = new JoinHost();
			h.setVisible(true);
		}
		if(e.getSource() == exitButton){
			System.exit(0);
		}
	}
}
