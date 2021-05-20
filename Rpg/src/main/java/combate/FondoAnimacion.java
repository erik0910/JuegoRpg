package combate;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import org.apache.log4j.helpers.Loader;
@SuppressWarnings("serial")
public class FondoAnimacion extends javax.swing.JPanel{
	static final ClassLoader loader = FondoAnimacion.class.getClassLoader();
public FondoAnimacion() {
	this.setSize(619, 539); 
	this.setVisible(true);
}
	public void paintComponents(Graphics g) {
		super.paintComponent(g);  
    	URL imgUrl = loader.getResource("combate/boss1.gif");
    	ImageIcon imagenFondo = new ImageIcon(imgUrl);
    	g.drawImage(imagenFondo.getImage(), 0, 0, 619, 539, null);
    	setOpaque(false);
	}
}
