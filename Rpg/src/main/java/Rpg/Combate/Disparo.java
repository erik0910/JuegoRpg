package Rpg.Combate;


import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Disparo extends Objeto {
	private ColisionDisparos colisiondisp;
	int player;
	private boolean col,f,mDerecha;
	private int danyo;
	private BufferedImage[] bi = new BufferedImage[2];
	private BufferedImage hoja = null;
	
	Disparo(double x, double y, boolean dir, int pl) {
		this.x = x;
		this.y = y;
		ancho = alto = danyo = 10;
		mDerecha = dir; //Hacia donde mira el personaje.
		this.player = pl; //Player almacena el jugador que lanza el golpe
		this.f = false; //f es la variable de muerte del personaje.
		colisiondisp = new ColisionDisparos(this.x, this.y, this.ancho, this.alto); //Crear una m�scara de colisiones para el disparo
		
		try {
			if(player==1) hoja = ImageIO.read(getClass().getResource("/Sprites/Player/disparo.png")); //Seg�n el jugador el disparo contendr� un aspecto o otro.
			else hoja = ImageIO.read(getClass().getResource("/Sprites/Player/disparo2.png"));
		} catch (IOException e) {e.printStackTrace();}
		
		for(int j = 0; j < 2; j++) bi[j] = hoja.getSubimage((j * ancho)+1*(1+j), 1, ancho, alto); //A�adir las imagenes 0 o 10 + 1, 1 , 10, 10
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
		if(player==2) col = colisiondisp.Colision(VentanaCombate.playergetX(1), VentanaCombate.playergetY(1), VentanaCombate.playergetAlto(1), VentanaCombate.playergetAncho(1));
		else col = colisiondisp.Colision(VentanaCombate.playergetX(2), VentanaCombate.playergetY(2), VentanaCombate.playergetAlto(2), VentanaCombate.playergetAncho(2));
		if(col) f = true;
	}
	
	//Setter & Getters===================================
	public double getX() {return this.x;}
	public boolean getF() {return f;}
	public int getPlayer() {return player;}
	public int getDanyo() {return danyo;}
	public void setDanyo(int danyo) {this.danyo = danyo;}
	//==================================================
	
}

