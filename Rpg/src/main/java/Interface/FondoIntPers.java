package Interface;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.*;

@SuppressWarnings("serial")
public class FondoIntPers extends javax.swing.JPanel{
    
    public FondoIntPers() {
    	this.setSize(1024, 1536);       
    }
     
    public void paintComponent(Graphics g) {
  	  Dimension tamanio = getSize();
  	  ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/resources/fondoPersonalizacion.png"));
  	  g.drawImage(imagenFondo.getImage(), 0, 0, tamanio.width, tamanio.height, null);
  	  setOpaque(false);
  	  super.paintComponent(g);
  }
    
   
}

