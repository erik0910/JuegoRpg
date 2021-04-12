package combate;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Fondo {
	private BufferedImage image;
	private double x;
	private double y;
	
	public Fondo(String s, double ms) {
		try {image = ImageIO.read(getClass().getResource(s));}
		catch(Exception e) {e.printStackTrace();}	
	}
	
	public void draw(Graphics2D g) {g.drawImage(image, (int)x, (int)y, null);}
	
}
