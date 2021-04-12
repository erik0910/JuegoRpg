package interfaces;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.*;

@SuppressWarnings("serial")
public class FondoIntInicial extends javax.swing.JPanel{
    
    public FondoIntInicial() {
    	this.setSize(619, 539);       
    }
     
    public void paintComponent(Graphics g) {
    	  ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/resources/fondoInicial.jpg"));
    	  g.drawImage(imagenFondo.getImage(), 0, 0, 619, 539, null);
    	  setOpaque(false);
    	  super.paintComponent(g);
    }
}