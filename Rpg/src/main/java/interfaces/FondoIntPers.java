package interfaces;

import java.awt.Dimension;
import java.awt.Graphics;
import java.net.URL;

import javax.swing.*;

@SuppressWarnings("serial")
public class FondoIntPers extends javax.swing.JPanel{
    
	static final ClassLoader loader = FondoIntOpciones.class.getClassLoader();
	
    public FondoIntPers() {
    	this.setSize(1024, 1536);       
    }
     
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);  
    	URL imgUrl = loader.getResource("fondoPersonalizacion.png");
    	ImageIcon imagenFondo = new ImageIcon(imgUrl);
    	g.drawImage(imagenFondo.getImage(), 0, 0, 1024, 1536, null);
    	setOpaque(false);
  }
    
   
}

