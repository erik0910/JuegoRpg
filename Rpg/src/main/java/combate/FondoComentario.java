package combate;

import java.awt.Dimension;
import java.awt.Graphics;
import java.net.URL;

import javax.swing.*;

@SuppressWarnings("serial")
public class FondoComentario extends javax.swing.JPanel{
    
	static final ClassLoader loader = FondoComentario.class.getClassLoader();
	
    public FondoComentario() {
    	this.setSize(619, 539);       
    }
	/**metodo de pintado de la clase fondo comentario */
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);  
    	URL imgUrl = loader.getResource("combate/boss1.gif");
    	ImageIcon imagenFondo = new ImageIcon(imgUrl);
    	g.drawImage(imagenFondo.getImage(), 0, 0, 619, 539, null);
    	setOpaque(false);
    	  
    }
}