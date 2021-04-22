package combate;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Armas {
	private int danyo,speed,knockback,frames,x,y,alto,ancho;
	private String nombre;
	private BufferedImage image = null;//imagen del arma
	public Armas (int danyo , int x , int y) {
		this.danyo = danyo;
		this.x= x;
		this.y = y;	
		this.alto = 70;
		this.ancho = 50;
	}
	// metodo para detección de las armas tipo mele solo se activara cuando estas armas sean mele

	public boolean ataque(double xe, double ye, int altoe, int anchoe) {
		boolean ataque = false;
		if(ye >= y-23 && (ye <= y+alto)) { //y >= 200 y y <= 250
			if(xe >= x-10 && xe <= x+ancho) {// x >= 100 y x <= 200
				ataque = true;
			}
		}
		return ataque;
	}
	
	public void cargaImagen(BufferedImage imagen) {// metodo para cargar la imagen
		this.image=imagen;
	}

	public int getDanyo() {return danyo;}
	public void setDanyo(int danyo) {this.danyo = danyo;}
	public int getSpeed() {return speed;}
	public void setSpeed(int speed) {this.speed = speed;}
	public int getKnockback() {return knockback;}
	public void setKnockback(int knockback) {this.knockback = knockback;}
	public int getFrames() {return frames;}
	public void setFrames(int frames) {this.frames = frames;}
	public int getX() {return x;}
	public void setX(int x) {this.x = x;}
	public int getY() {return y;}
	public void setY(int y) {this.y = y;}
	public int getAlto() {return alto;}
	public void setAlto(int alto) {this.alto = alto;}
	public int getAncho() {return ancho;}
	public void setAncho(int ancho) {this.ancho = ancho;}
	public String getNombre() {return nombre;}
	public void setNombre(String nombre) {this.nombre = nombre;}

}
