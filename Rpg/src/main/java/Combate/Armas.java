package Combate;


public class Armas {
	private int danyo,speed,knockback,frames,x,y,alto,ancho;
	private String nombre;
	
	public Armas(int danyo, int speed, int knockback, int frames, int x, int y, int alto, int ancho, String nombre) {
		super();
		this.danyo = danyo;
		this.speed = speed;
		this.knockback = knockback;
		this.frames = frames;
		this.x = x;
		this.y = y;
		this.alto = alto;
		this.ancho = ancho;
		this.nombre = nombre;
	}

	public boolean ataque(double xe, double ye, int altoe, int anchoe) {
		boolean ataque = false;
		if(ye >= y && (ye <= y+alto)) { //y >= 200 y y <= 250
			if(xe >= x && xe <= x+ancho) {// x >= 100 y x <= 200
				System.out.println("Ataque");
				ataque = true;
			}
		}
		return ataque;
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
