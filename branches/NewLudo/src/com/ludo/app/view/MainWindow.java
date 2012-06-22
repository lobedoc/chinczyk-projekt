package com.ludo.app.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;

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
	private Font font;
	public MainWindow(){
		super("Chińczyk");
			InputStream inputStream = MainWindow.class.getResourceAsStream("/com/ludo/app/resources/jappernees.ttf");
		        try{
		           font = Font.createFont(Font.TRUETYPE_FONT, inputStream);
		        }
		        catch(Exception e){
		            System.out.println(e);
		        }
			Font font1 = font.deriveFont (20f);

		singlePlayerButton = new JButton("POJEDYNCZY GRACZ");
		singlePlayerButton.setFont(font1);
		multiPlayerButton = new JButton("GRA WIELOOSOBOWA");
		multiPlayerButton.setFont(font1);
		infoButton = new JButton("INFORMACJE");
		infoButton.setFont(font1);
		infoButton.addActionListener(this);
		multiPlayerButton.addActionListener(this);
		exitButton = new JButton("WYJDZ");
		exitButton.setFont(font1);
		exitButton.addActionListener(this);
		singlePlayerButton.addActionListener(this);
		JPanel imagePanel = new ImagePanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
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
			ServerHandler handler = client.getHandler();
			BoardGame boardGame = new BoardGame("Gracz");
			boardGame.createView();
			boardGame.setHandler(handler);
			this.setVisible(false);
		}
		if(e.getSource() == multiPlayerButton){
			/*JoinHost h = new JoinHost();
			h.setVisible(true);*/
			MultiplayerView view = new MultiplayerView();
			view.setVisible(true);
			this.setVisible(false);
			
		}
		if(e.getSource() == exitButton){
			System.exit(0);
		}
	}
}
