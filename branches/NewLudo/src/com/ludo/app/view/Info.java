package com.ludo.app.view;

import java.awt.*;
import java.awt.event.*;
import java.io.InputStream;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

public class Info extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel l0, l1, l2, l3, l4, l5, l6;
	private JLabel lBorder, lIcon;
	private JLabel yellow, red, green, blue;
	private JButton jBOk;
	private Font font1 = new Font("TimesRoman", Font.PLAIN, 22);
	private Font font2 = new Font("TimesRoman", Font.PLAIN, 12);
	private Font font3 = new Font("TimesRoman", Font.BOLD, 12);
	private Font font4 = new Font("TimesRoman", Font.PLAIN, 12);
	private Border line = null;
	private Font font;
	
	/**
	 * Konstruktor bezparametryczny klasy <code>AboutWindow</code>
	 */
	public Info() {
		this.setTitle("Informacje o autorach");
		this.setModal(true);
		this.setSize(360,240);
		this.setResizable(false);
		
		// obsluga zdarzenia okna
		this.addWindowListener	(new WindowAdapter(){ 
			// obsluga wcisniecia przycisku zamkniecia okna
			public void windowClosing(WindowEvent e){ 
				setVisible(false);				
			}	
		});	
		

		Dimension dialogSize = getSize();		

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();  
		if(dialogSize.height > screenSize.height) 
			dialogSize.height = screenSize.height;
		if(dialogSize.width > screenSize.width)
			dialogSize.height = screenSize.width;
			
		setLocation((screenSize.width-dialogSize.width)/2,   
						(screenSize.height-dialogSize.height)/2);
		
		Container contentPane = getContentPane();
		contentPane.setBackground(Color.white);
		contentPane.setLayout(null);
		InputStream inputStream = MainWindow.class.getResourceAsStream("/com/ludo/app/resources/jappernees.ttf");
        try{
           font = Font.createFont(Font.TRUETYPE_FONT, inputStream);
        }
        catch(Exception e){
            System.out.println(e);
        }
        font = font.deriveFont (20f);
        
		try {
			blue = new JLabel(new ImageIcon(("src/com/ludo/app/resources/images/bluePawn.png")));
			red = new JLabel(new ImageIcon(("src/com/ludo/app/resources/images/redPawn.png")));
			green = new JLabel(new ImageIcon(("src/com/ludo/app/resources/images/greenPawn.png")));
			yellow = new JLabel(new ImageIcon(("src/com/ludo/app/resources/images/yellowPawn.png")));
		} 
		catch(Exception e) { 
			e.printStackTrace();
		}
		l0 = new JLabel("CHINCZYK");
		l0.setFont(font);
		l0.setHorizontalAlignment(SwingConstants.CENTER);
		l1 = new JLabel("wersja 1.0");
		l1.setFont(font1);
		l1.setHorizontalAlignment(SwingConstants.CENTER);
		l2 = new JLabel("Copyright (C) by 2012");
		l2.setFont(font2);
		l2.setHorizontalAlignment(SwingConstants.CENTER);
		l3 = new JLabel("Mateusz Mikołajczak");
		l6 = new JLabel("Łukasz Kaczmarski");
		l3.setFont(font3);
		l6.setFont(font3);
		l3.setHorizontalAlignment(SwingConstants.CENTER);
		l6.setHorizontalAlignment(SwingConstants.CENTER);
		l4 = new JLabel("Politechnika Koszalinska - WEiI");
		l4.setFont(font3);
		l4.setHorizontalAlignment(SwingConstants.CENTER);
		l5 = new JLabel("albumy: 74-668 & 74-637");
		l5.setFont(font4);
		lBorder = new JLabel(""); 
		jBOk = new JButton("Ok");
		jBOk.addActionListener(this);
		line = new EtchedBorder(EtchedBorder.LOWERED);
		
		yellow.setBounds(30,5,120,150);
		red.setBounds(30,40,120,150);
		blue.setBounds(-2,5,120,150);
		green.setBounds(-2,40,120,150);
		l0.setBounds(135,10,210,30);
		l1.setBounds(135,40,210,30);
		l2.setBounds(135,90,210,20);
		l3.setBounds(135,110,210,20);
		l6.setBounds(135,130,210,20);
		l4.setBounds(135,150,210,20);
		lBorder.setBounds(5,175,dialogSize.width-14,2);
		l5.setBounds(10,184,200,20);
		jBOk.setBounds(dialogSize.width-75,182,60,25);
		
		lBorder.setBorder(line);
		contentPane.add(l0);
		contentPane.add(l1);
		contentPane.add(l2);
		contentPane.add(l3);
		contentPane.add(l6);
		contentPane.add(l4);
		contentPane.add(l5);
		contentPane.add(lBorder);
		contentPane.add(jBOk);
		contentPane.add(yellow);
		contentPane.add(red);
		contentPane.add(green);
		contentPane.add(blue);
	}

	public void actionPerformed(ActionEvent eAE) {
		if(eAE.getSource() == jBOk) {
			setVisible(false);
		}
	}
}
