package Interface;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.*;

@SuppressWarnings("serial")
public class FondoIntPersonalizacion extends javax.swing.JPanel{
     
    private BufferedImage mImagen = null;
    
    public FondoIntPersonalizacion() {
    	this.setSize(1024, 1536);       
    }
     
    public void paintComponent(Graphics g) {
    	  Dimension tamanio = getSize();
    	  ImageIcon imagenFondo = new ImageIcon(getClass().getResource("../Resources/FondoPersonalizacion.png"));
    	  g.drawImage(imagenFondo.getImage(), 0, 0, tamanio.width, tamanio.height, null);
    	  setOpaque(false);
    	  super.paintComponent(g);
    }
}