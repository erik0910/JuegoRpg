package Interface;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.*;

@SuppressWarnings("serial")
public class FondoIntInicial extends javax.swing.JPanel{
     
    private BufferedImage mImagen = null;
    
    public FondoIntInicial() {
    	this.setSize(1024, 1536);       
    }
     
    public void paintComponent(Graphics g) {
    	  Dimension tamanio = getSize();
    	  ImageIcon imagenFondo = new ImageIcon(getClass().getResource("../Resources/fondoInicial.jpg"));
    	  g.drawImage(imagenFondo.getImage(), 0, 0, tamanio.width, tamanio.height, null);
    	  setOpaque(false);
    	  super.paintComponent(g);
    }
}