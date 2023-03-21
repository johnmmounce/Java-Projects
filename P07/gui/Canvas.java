package gui;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Canvas extends JPanel {
    public Dimension getPreferredSize() {
        return new Dimension(250,200);                 
    }                                                 
    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g = (Graphics2D) graphics.create();
    
        int x = (getWidth() - 90) / 2;  
        int y = (getHeight() - 90) / 2; 
        g.drawRect(x, y, 90, 90);                   
    }  
}
