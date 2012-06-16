package com.ludo.app.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;

import com.ludo.app.control.ControlGameInterface;
import com.ludo.app.control.Player;
import com.ludo.app.model.Pawn;
import com.ludo.app.observer.PawnObserver;
import com.ludo.lan.control.GameControl;
import com.ludo.lan.observer.ClientObserver;
import com.ludo.lan.server.ClientHandler;

public class BoardGame implements ActionListener,PawnObserver{
	
	private JButton joinYellow;
	private JButton joinRed;
	private JButton joinGreen;
	private JButton joinBlue;
	
	private ArrayList<Pawn> pawns;
	public BoardGame(){
		pawns = new ArrayList<Pawn>();
	}
	public void addPawn(Pawn p){
		pawns.add(p);
	}
	@Override
	public void changeBoxPawn(int position) {
		// TODO Auto-generated method stub
		for(int i = 0; i < pawns.size(); i++){
			Pawn p = pawns.get(i);
			System.out.println("Aktualna pozycja: " + p.getActualyPosition() + " kolor pionka: " + p.getPawnColor());
			//Box[position].add(p);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == joinYellow){
			//control.createYellowPlayer();
		}
		if(e.getSource() == joinRed){
			//control.createRedPlayer();
		}
		if(e.getSource() == joinGreen){
			//control.createRedPlayer();
			
		}
	}
	
	
}
