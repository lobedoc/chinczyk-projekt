package com.ludo.app.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainWindow extends JFrame implements ActionListener {

	private JButton singlePlayerButton,multiPlayerButton,exitButton;
	private ImageIcon singleIcon,multiIcon,exitIcon;
	BufferedImage image;
	public MainWindow(){
		singleIcon = new ImageIcon("src/com/ludo/app/resources/images/singleplayer.jpg");
		multiIcon = new ImageIcon("src/com/ludo/app/resources/images/multiplayer.jpg");
		exitIcon = new ImageIcon("src/com/ludo/app/resources/images/close.jpg");
		singlePlayerButton = new JButton(singleIcon);
		multiPlayerButton = new JButton(multiIcon);
		multiPlayerButton.addActionListener(this);
		exitButton = new JButton(exitIcon);
		exitButton.addActionListener(this);
		singlePlayerButton.addActionListener(this);
		JPanel imagePanel = new ImagePanel();
		//imagePanel.setOpaque(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setMinimumSize(new Dimension(575,453));
        this.setLayout(new BorderLayout());
        imagePanel.setOpaque(false);
        imagePanel.add(flowPanel());
		this.add(imagePanel, BorderLayout.CENTER);
	}
	
	private JPanel flowPanel(){
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(singlePlayerButton,BorderLayout.NORTH);
		panel.add(multiPlayerButton,BorderLayout.CENTER);
		panel.add(exitButton,BorderLayout.SOUTH);
		//panel.setOpaque(false);
		return panel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
