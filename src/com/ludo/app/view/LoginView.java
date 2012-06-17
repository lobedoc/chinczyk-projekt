package com.ludo.app.view;

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

import com.ludo.app.control.ControlGame;

public class LoginView extends JDialog implements ActionListener{

	private JTextField fieldName;
	private JButton buttonSingle;
	private JButton buttonMulti;
	private JButton buttonExit;
	private ControlGame control;
	public LoginView(ControlGame control){
		this.control = control;
		fieldName = new JTextField(15);
		initListeners();
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
		this.setVisible(true);
	}
	private void initListeners(){
		buttonSingle = new JButton("Pojedyńcza gra");
		buttonMulti = new JButton("Gra wieloosobowa");
		buttonExit = new JButton("Zakończ");
		buttonSingle.addActionListener(this);
		buttonMulti.addActionListener(this);
		buttonExit.addActionListener(this);
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
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == buttonSingle){
			control.singlePlayer();
		}
		if(e.getSource() == buttonMulti){
			control.multiPlayer();
		}
		if(e.getSource() == buttonExit){
			System.exit(0);
		}
	}
	
	public String getText(){
		return fieldName.getText();
	}

}
