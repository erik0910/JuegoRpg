package Prueba;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Ventana {
	public static void main(String[] args) {
		JFrame window = new JFrame("Batalla cobtra Boss");
		window.setContentPane(new Juego());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.pack();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Point middle = new Point(screenSize.width / 2, screenSize.height / 2);
		Point newLocation = new Point(middle.x - (window.getWidth() / 2), 
		                              middle.y - (window.getHeight() / 2));
		window.setLocation(newLocation);
		window.setVisible(true);
	}
}
