package com.ludo.app.view;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URL;
import javax.swing.*;
import javax.swing.event.*;

public class Help extends JDialog {

	private static final long serialVersionUID = 1L;
	private JEditorPane editorPane = null;
	private URL descriptionUrl = null;
	
	public Help() {
		this.setTitle("Pomoc - aplikacja testowa");
		this.setModal(false);
		this.setResizable(true);
		this.setSize(800,600);
	
		this.addWindowListener	(new WindowAdapter(){ 
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
		
		this.setLayout(new BorderLayout());

		editorPane = new JEditorPane();
		editorPane.setEditable(false);
		descriptionUrl = com.ludo.app.view.Help.class.getResource(
				"/com/ludo/app/resources/help/info.html");
		
		setURLPage();
		
		editorPane.addHyperlinkListener(new HyperlinkListener() {
			public void hyperlinkUpdate(HyperlinkEvent event) {
				if(event.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
					try {
						editorPane.setPage(event.getURL());
					}
					catch(IOException e) {
						editorPane.setText("Exception: "+e);
					}
				}
			}
		}); 
		this.add(new JScrollPane(editorPane), BorderLayout.CENTER);
	}

	private void setURLPage() {
		try {
			editorPane.setPage(descriptionUrl);
		}
		catch(Exception e) {
			editorPane.setText("Nie można otworzyć plików z pomocą " +
					descriptionUrl);
		} 
	}
}
