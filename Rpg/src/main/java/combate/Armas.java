package combate;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Armas {
	private int danyo,speed,knockback,frames,x,y,alto,ancho;
	private String nombre;
	private BufferedImage  image = null;//imagen del arma
	public Boolean derecha=true;
	static final ClassLoader loader = Armas.class.getClassLoader();
	/**costructor del arma*/
	public Armas (int danyo , int x , int y) {
		this.danyo = danyo;
		this.x= x;
		this.y = y;	
		this.alto = 70;
		this.ancho = 50;
	}
	// metodo para detección de las armas tipo mele solo se activara cuando estas armas sean mele
	/**metodo para poder detectar el ataque*/
	public boolean ataque(double xe, double ye, int altoe, int anchoe) {
		boolean ataque = false;
		if(ye >= y-23 && (ye <= y+alto)) { //y >= 200 y y <= 250
			if(xe >= x-10 && xe <= x+ancho) {// x >= 100 y x <= 200
				ataque = true;
			}
		}
		return ataque;
	}
	
	/**metodo para cargar la imagen*/
	public void cargaImagen(BufferedImage imagen) {// metodo para cargar la imagen de las espadas
		this.image=imagen;
	}
	/**getters de daño */
	public int getDanyo() {return danyo;}
	/**metodo para meter  daño*/
	public void setDanyo(int danyo) {this.danyo = danyo;}
	/**metodo para ver la velocidad*/
	public int getSpeed() {return speed;}
	/**metodo para añadir la velocidad*/
	public void setSpeed(int speed) {this.speed = speed;}
	/**añade retardo arma*/
	public int getKnockback() {return knockback;}
	/**meter retardo del arma*/
	public void setKnockback(int knockback) {this.knockback = knockback;}
	/**Devuelve frames*/
	public int getFrames() {return frames;}
	/**añadir los frames*/
	public void setFrames(int frames) {this.frames = frames;}
	/**Devuelve la x*/
	public int getX() {return x;}
	/**añade la x*/
	public void setX(int x) {this.x = x;}
	/**devuelve la y*/
	public int getY() {return y;}
	/**añadir y*/
	public void setY(int y) {this.y = y;}
	/**obtener la altura*/
	public int getAlto() {return alto;}
	/**añadir la altura*/
	public void setAlto(int alto) {this.alto = alto;}
	/**obtener anchura*/
	public int getAncho() {return ancho;}
	/**añade animación*/
	public void setAncho(int ancho) {this.ancho = ancho;}
	/**obtener el nombre*/
	public String getNombre() {return nombre;}
	/**añadir el nombre*/
	public void setNombre(String nombre) {this.nombre = nombre;}

}
