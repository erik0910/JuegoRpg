package Prueba;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Disparo extends Objeto {
	private ColisionDisparos colisiondisp;
	int player;
	private boolean col,f,mDerecha;
	private int daño;
	private BufferedImage[] bi = new BufferedImage[2];
	private BufferedImage hoja = null;
	
	Disparo(double x, double y, boolean dir, int pl) {
		this.x = x;
		this.y = y;
		ancho = alto = daño = 10;
		mDerecha = dir; //Hacia donde mira el personaje.
		this.player = pl; //Player almacena el jugador que lanza el golpe
		this.f = false; //f es la variable de muerte del personaje.
		colisiondisp = new ColisionDisparos(this.x, this.y, this.ancho, this.alto); //Crear una máscara de colisiones para el disparo
		
		try {
			if(player==1) hoja = ImageIO.read(getClass().getResource("/Prueba/Sprites/Player/disparo.png")); //Según el jugador el disparo contendrá un aspecto o otro.
			else hoja = ImageIO.read(getClass().getResource("/Prueba/Sprites/Player/disparo2.png"));
		} catch (IOException e) {e.printStackTrace();}
		
		for(int j = 0; j < 2; j++) bi[j] = hoja.getSubimage((j * ancho)+1*(1+j), 1, ancho, alto); //Añadir las imagenes 0 o 10 + 1, 1 , 10, 10
		animacion = new Animacion();
		animacion.setAnimacion(bi);
	}

	public void draw(Graphics2D g) {super.draw(g);}
	
	
	public void update() {
		col = false;
		if(mDerecha) this.x += 2;
		else this.x -= 2;
		animacion.setDelay(100);
		animacion.update();
		colisiondisp.update(this.x, this.y);
		if(player==2) col = colisiondisp.Colision(Room.playergetX(1), Room.playergetY(1), Room.playergetAlto(1), Room.playergetAncho(1));
		else col = colisiondisp.Colision(Room.playergetX(2), Room.playergetY(2), Room.playergetAlto(2), Room.playergetAncho(2));
		if(col) f = true;
	}
	
	//Setter & Getters===================================
	public double getX() {return this.x;}
	public boolean getF() {return f;}
	public int getPlayer() {return player;}
	public int getDaño() {return daño;}
	public void setDaño(int daño) {this.daño = daño;}
	//==================================================
	
}

