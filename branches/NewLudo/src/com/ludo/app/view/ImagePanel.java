package com.ludo.app.view;

import java.awt.*;  
import java.awt.image.BufferedImage;  
import java.io.File;  
import java.io.IOException;  
  
import javax.imageio.ImageIO;  
import javax.swing.JPanel;  
  
public class ImagePanel extends JPanel {  
  
    private BufferedImage image;  
  
    public ImagePanel() {  
        super();  
  
        File imageFile = new File("src/com/ludo/app/resources/images/ludo.jpg");  
        try {  
            image = ImageIO.read(imageFile);  
        } catch (IOException e) {  
            System.err.println("Blad odczytu obrazka");  
            e.printStackTrace();  
        }  
  
        Dimension dimension = new Dimension(image.getWidth(), image.getHeight());  
        setPreferredSize(dimension);  
    }  
  
    @Override  
    public void paintComponent(Graphics g) {  
        Graphics2D g2d = (Graphics2D) g;  
        g2d.drawImage(image, 0, 0, this);  
    }  
}  
