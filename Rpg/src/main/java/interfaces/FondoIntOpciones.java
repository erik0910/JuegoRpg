package interfaces;

import java.awt.Dimension;
import java.awt.Graphics;
import java.net.URL;

import javax.swing.*;

@SuppressWarnings("serial")
public class FondoIntOpciones extends javax.swing.JPanel{
    
	static final ClassLoader loader = FondoIntOpciones.class.getClassLoader();
	
    public FondoIntOpciones() {
    	this.setSize(619, 539);       
    }
     
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);  
    	URL imgUrl = loader.getResource("fondoOpciones.jpg");
    	ImageIcon imagenFondo = new ImageIcon(imgUrl);
    	g.drawImage(imagenFondo.getImage(), 0, 0, 619, 539, null);
    	setOpaque(false);
  }
    
   
}

