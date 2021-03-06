package interfaces;

import java.awt.Dimension;
import java.awt.Graphics;
import java.net.URL;

import javax.swing.*;

@SuppressWarnings("serial")
public class FondoTiendaCargar extends javax.swing.JPanel{
    
	static final ClassLoader loader = FondoIntCargar.class.getClassLoader();
	
	/**Declara el tamaño*/
    public FondoTiendaCargar() {
    	this.setSize(700, 700);       
    }
     
    /**Selecciona la imagen y la dibuja en un JPanel*/
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);  
    	URL imgUrl = loader.getResource("tienda/fondoTienda.png");
    	ImageIcon imagenFondo = new ImageIcon(imgUrl);
    	g.drawImage(imagenFondo.getImage(), 0, 0, 700, 700, null);
    	setOpaque(false);
    }
}
