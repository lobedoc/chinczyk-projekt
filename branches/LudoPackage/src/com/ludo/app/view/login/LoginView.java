package com.ludo.app.view.login;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class LoginView extends JDialog implements ActionListener{

	private JTextField fieldName;
	private JButton buttonSingle;
	private JButton buttonMulti;
	private JButton buttonExit;
	public LoginView(){
		fieldName = new JTextField(15);
		buttonSingle = new JButton("Pojedyńcza gra");
		buttonMulti = new JButton("Gra wieloosobowa");
		buttonExit = new JButton("Zakończ");
		this.setLayout(new BorderLayout());
		this.setMinimumSize(new Dimension(450, 100));
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
	}
	private JPanel buttonPanel(){
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1,3,5,0));
		panel.add(buttonSingle);
		panel.add(buttonMulti);
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
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
