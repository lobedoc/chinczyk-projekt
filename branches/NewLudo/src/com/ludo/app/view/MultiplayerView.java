package com.ludo.app.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.ludo.lan.client.Client;
import com.ludo.lan.client.ServerHandler;
import com.ludo.lan.server.Server;
import com.ludo.lan.task.ThreadManager;


public class MultiplayerView extends JDialog implements ActionListener{

	private JTextField fieldName;
	private JButton buttonHost;
	private JButton buttonConnect;
	private JButton buttonExit;
	private Font font;
	public MultiplayerView(){
		InputStream inputStream = MainWindow.class.getResourceAsStream("/com/ludo/app/resources/jappernees.ttf");
        try{
           font = Font.createFont(Font.TRUETYPE_FONT, inputStream);
        }
        catch(Exception e){
            System.out.println(e);
        }
        font = font.deriveFont (20f);
		fieldName = new JTextField(15);
		initListeners();
		this.setLayout(new BorderLayout());
		this.setMinimumSize(new Dimension(500, 130));
		Dimension dialogSize = 	this.getSize();		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();  
		if(dialogSize.height > screenSize.height) 
			dialogSize.height = screenSize.height;
		if(dialogSize.width > screenSize.width)
			dialogSize.height = screenSize.width;
		this.setLocation((screenSize.width-dialogSize.width)/2,   
						(screenSize.height-dialogSize.height)/2);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.add(fieldPanel(), BorderLayout.CENTER);
		this.add(buttonPanel(), BorderLayout.SOUTH);
		this.setVisible(true);
	}
	private void initListeners(){
		buttonHost = new JButton("Host");
		buttonHost.setFont(font);
		buttonConnect = new JButton("Polacz");
		buttonConnect.setFont(font);
		buttonExit = new JButton("Wyjdz");
		buttonExit.setFont(font);
		buttonHost.addActionListener(this);
		buttonConnect.addActionListener(this);
		buttonExit.addActionListener(this);
	}
	private JPanel buttonPanel(){
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1,3,5,0));
		panel.add(buttonHost);
		panel.add(buttonConnect);
		panel.add(buttonExit);
		return panel;
	}
	private JPanel fieldPanel(){
		JPanel panel = new JPanel(new FlowLayout());
		JLabel labelName = new JLabel("Nick gracza:", SwingConstants.RIGHT);
		panel.add(labelName);
		panel.add(fieldName);
		return panel;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == buttonHost){
				Server server = new Server();
				ThreadManager.getInstance().execute(server);
				this.setVisible(false);
				Client client = new Client();
				client.connect("localhost");
				ServerHandler handler = client.getHandler();
				BoardGame boardGame = new BoardGame(fieldName.getText());
				boardGame.createView();
				boardGame.setHandler(handler);	
				this.setVisible(false);
			}
		if(e.getSource() == buttonConnect){
			Client client = new Client();
			String str = JOptionPane.showInputDialog(null, "Podaj ip serwera: ", 
					 "", 1);
				client.connect(str);
				if(client.getConnected())
				{
					ServerHandler handler = client.getHandler();
					BoardGame boardGame = new BoardGame(fieldName.getText());
					boardGame.createView();
					boardGame.setHandler(handler);	
					this.setVisible(false);
				}
				else{
					JOptionPane.showMessageDialog(this,
						    "Nie połączono z serwerem!",
						    "Błąd połączenia",
						    JOptionPane.ERROR_MESSAGE);
				}
		}
		if(e.getSource() == buttonExit){
			System.exit(0);
		}
	}
	
	public String getText(){
		return fieldName.getText();
	}

}
