package combate;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Fondo {
	private BufferedImage image;
	private double x;
	private double y;
	static final ClassLoader loader = Fondo.class.getClassLoader();
	/**constructor de la clase fondo */
	public Fondo(String s, double ms) {
		try {image = ImageIO.read(loader.getResource(s));}
		catch(Exception e) {
		}	
	}
	/**método de pintado de la clase fondo */
	public void draw(Graphics2D g) {g.drawImage(image, (int)x, (int)y, null);}
	
}
