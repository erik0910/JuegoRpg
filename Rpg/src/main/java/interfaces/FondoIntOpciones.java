package interfaces;

import java.awt.Dimension;
import java.awt.Graphics;
import java.net.URL;

import javax.swing.*;

@SuppressWarnings("serial")
public class FondoIntOpciones extends javax.swing.JPanel{
    
	static final ClassLoader loader = FondoIntOpciones.class.getClassLoader();
	
	/**Declara el tamaño*/
    public FondoIntOpciones() {
    	this.setSize(619, 539);       
    }
    /**Selecciona la imagen y la dibuja en un JPanel*/
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);  
    	URL imgUrl = loader.getResource("menus/fondoOpciones.jpg");
    	ImageIcon imagenFondo = new ImageIcon(imgUrl);
    	g.drawImage(imagenFondo.getImage(), 0, 0, 619, 539, null);
    	setOpaque(false);
  }
    
   
}

