package Combate;
import java.util.ArrayList;
import javax.imageio.ImageIO;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Objeto  {
	
	// player stuff
	private int health, maxHealth;
	private int manad1 = 30;
	
	private boolean parpadeo;
	private long parpadeoT;
	//private int player;
	//private int enemigo;
	//private int objetivo;
	// gliding
	private boolean planeo;
	boolean ataquef;
	private double mana;
	
	// animacions
	private ArrayList<BufferedImage[]> sprites;
	private final int[] numFrames = {
		2, 8, 1, 2, 4, 2, 5
		};

	// animacion actions
	private static final int NORMAL = 0;
	private static final int ANDAR = 1;
	private static final int SALTAR = 2;
	private static final int CAER = 3;
	private static final int PLANEAR = 4;
	private static final int[] fps = {400,40,-1,100,100};
	
	//Arma
	//private Armas espada =new Armas(20/*Da�o*/, 10/*Speed*/, 0/*Knockback*/, 3/*Frames*/,(int) this.x+5/*x*/,(int) this.y+5/*y*/, 6/*alto*/, 2/*ancho*/, "Stegosaurio"/*Da�o*/);
	
	public Player(int player) {
		ancho = 30;
		alto = 30;
		moveSpeed = 0.3;
		maxSpeed = 1.6;
		stopSpeed = 0.4;
		vCaida = 0.15;
		maxCaida = 4.0;
		vSalto = -4.8;
		pSalto = 0.3;
		this.mana = 100;
		//this.player = player;
		mDerecha = true;
		
		health = maxHealth = 100;	
		
		/*Imagenes===================================================*/
		try {
			/*Cargar hoja de im�genes================================*/
			BufferedImage hoja = ImageIO.read(
				getClass().getResource(
					"/Prueba/Sprites/Player/player.png"
				)
			);
			/*======================================================*/
			sprites = new ArrayList<BufferedImage[]>();
			/*Array de im�genes====================================*/
			/*Crear en bucle cada imagen separada*/
			for(int i = 0; i < 5; i++) {
				BufferedImage[] bi = new BufferedImage[numFrames[i]];//Crear la array de imagenes
				for(int j = 0; j < numFrames[i]; j++) bi[j] = hoja.getSubimage(j * ancho, i * (alto-1), ancho, alto); //A�adir las imagenes
				sprites.add(bi); 
				/*Se a�ade en cada posici�n de la arraylist el conjunto de imagenes de cada animaci�n
				 *lo que luego vale para aplicarlas llamandolas con un n�mero que es asignado a cada nombre clave.*/
			}
			/*====================================================*/
		}
		catch(Exception e) {e.printStackTrace();}
		animacion = new Animacion();
		accion = NORMAL;
		animacion.setAnimacion(sprites.get(NORMAL));
		animacion.setDelay(400);
		ancho = 30;
		
	}
	public void setHealth(int health) {
		this.health = health;
	}
	/*===============================================================*/
	public int getHealth() { return health; }
	public int getMaxHealth() { return maxHealth; }
	
	public void setPlaneo(boolean b) { 
		planeo = b;
	}
	
	public void hit(int damage) {
		if(parpadeo) return;
		health -= damage;
		if(health < 0) health = 0;
		parpadeo = true;
		parpadeoT = System.nanoTime();
	}
	
	private void pTemporal() {
		if(izquierda) {
			dx -= moveSpeed;
			if(dx < -maxSpeed) dx = -maxSpeed;
		}
		else if(derecha) {
			dx += moveSpeed;
			if(dx > maxSpeed) dx = maxSpeed;
		}
		else {
			if(dx > 0) {
				dx -= stopSpeed;
				if(dx < 0) dx = 0;
			}
			else if(dx < 0) {
				dx += stopSpeed;
				if(dx > 0) dx = 0;
			}
		}
		
		// jumping
		if(salto && !caer) {
			dy = vSalto;
			caer = true;
		}
		
		// caer
		if(caer) {
				if(dy > 0 && planeo) dy += vCaida * 0.1;
				else dy += vCaida;
				if(dy > 0) salto = false;
				if(dy < 0 && !salto) dy += pSalto;
				if(dy > maxCaida) dy = maxCaida;
		}
	}
	
	public void update() {
		
		// update position
		pTemporal();
		checkSuelo();
		if(mana < 100) {
			this.mana += 0.5;
		}
		// check done parpadeo
		if(parpadeo) {
			long elapsed = (System.nanoTime() - parpadeoT) / 1000000;
			if(elapsed > 1000) parpadeo = false;
		}
		
		// set animacion
		if(dy > 0) {
			if(planeo) {
				if(accion != PLANEAR) {
					accion = PLANEAR;
					animacion.setAnimacion(sprites.get(PLANEAR));
				}
			}
			else if(accion != CAER) {
				accion = CAER;
				animacion.setAnimacion(sprites.get(CAER));
			}
		}
		else if(dy < 0) {
			if(accion != SALTAR) {
				accion = SALTAR;
				animacion.setAnimacion(sprites.get(SALTAR));
			}
		}
		else if(izquierda || derecha) {
			if(accion != ANDAR) {
				accion = ANDAR;
				animacion.setAnimacion(sprites.get(ANDAR));
			}
		}
		else {
			if(accion != NORMAL) {
				accion = NORMAL;
				animacion.setAnimacion(sprites.get(NORMAL));
			}
		}	
		animacion.setDelay(fps[accion]);
		animacion.update();
		
		// set direction
		if(derecha) mDerecha = true;
		if(izquierda) mDerecha = false;
		
		//Arma
//		espada.setX((int)this.x+5);
//		espada.setY((int)this.x+5);
	}
	
	public void draw(Graphics2D g) {
		if(parpadeo) {
			long elapsed = (System.nanoTime() - parpadeoT) / 1000000;
			if(elapsed / 100 % 2 == 0) return;
		}
		//HP
		
		g.drawRect ((int)x-10, (int)y-30, (((health*100/maxHealth)*30)/100), 5);
		g.setColor(Color.red);
		g.fillRect((int)x-9, (int)y-29, (((health*100/maxHealth)*30)/100)-1, 4);
		//Mana
		
		
		g.setColor(Color.BLACK);
		g.drawRect ((int)x-10, (int)y-15, (int)(((mana*100/100)*30)/100), 5);
		g.setColor(Color.green);
		g.fillRect((int)x-9, (int)y-14, (int)(((mana*100/100)*30)/100)-1, 4);
		g.setColor(Color.BLACK);
		super.draw(g);
		
	}
	
	public void setFalse() {
		this.abajo = false;
		this.izquierda = false;
		this.salto = false;
		this.planeo = false;
		this.derecha = false;
		this.ataque = false;
	}
	
	public void setAtaque(boolean b) {this.ataque = true;}
	public boolean getAtaque() {return this.ataque;}
	public boolean getmDerecha() {return this.mDerecha;}
	public double getAlto() {return this.alto;}
	public double getMana() {
		return mana;
	}
	public void setMana(double d) {
		this.mana = d;
	}
	public int getManad1() {
		return manad1;
	}
	public void setManad1(int manad1) {
		this.manad1 = manad1;
	}
}

